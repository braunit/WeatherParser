/*
 * Copyright (c)2014 Braun IT Solutions Ltd, Vancouver, Canada
 * http://www.braun-it.ca
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in 
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ca.braunit.weatherparser.taf;

import ca.braunit.weatherparser.common.util.CloudsDecoder;
import ca.braunit.weatherparser.common.util.TimeInfoDecoder;
import ca.braunit.weatherparser.common.util.ValidityPeriodDecoder;
import ca.braunit.weatherparser.common.util.VisibilityDecoder;
import ca.braunit.weatherparser.common.util.WeatherDecoder;
import ca.braunit.weatherparser.common.util.WindDecoder;
import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.util.CommonDecoder;
import ca.braunit.weatherparser.taf.domain.Taf;
import ca.braunit.weatherparser.taf.util.ExpectedChangeDecoder;
import ca.braunit.weatherparser.taf.util.IcingConditionsDecoder;
import ca.braunit.weatherparser.taf.util.MinimumAltimeterSettingDecoder;
import ca.braunit.weatherparser.taf.util.TemperatureDecoder;
import ca.braunit.weatherparser.taf.util.TurbulenceDecoder;
import ca.braunit.weatherparser.taf.util.WindShearDecoder;

/**
 * This class implements the functionality to decode TAF (terminal aerodrome forecast)
 * weather data.
 * @author Alexander Braun
 */
public class TafDecoder {

	private static final String TAF = "TAF";
	private static final String AMD = "AMD";
	private static final String COR = "COR";
	
	private static final String ICAO_CODE_PATTERN = "[A-Za-z]{4}( |\\Z)(.)*";
	
	/**
	 * This method decodes TAF (terminal aerodrome forecast) weather data.
	 * @param weatherString the weather String encoded in TAF format.
	 * @return a {@link Taf} object
	 * @throws DecoderException in case of missing or unknown patterns.
	 */
	public static TafDecoderResult decodeTaf(String weatherString) throws DecoderException {
		return decodeObject(new StringBuffer(CommonDecoder.prepareWeatherString(weatherString)));
	}

	private static TafDecoderResult decodeObject(StringBuffer weatherSb) throws DecoderException {
		
		TafDecoderResult tdResult = new TafDecoderResult();
		
		Taf taf = new Taf();
		decodeReportType(taf, weatherSb);
		decodeAirportIcaoCode(taf, weatherSb);
		taf.setIssuanceTime(TimeInfoDecoder.decodeObject(weatherSb, true));
		taf.setValidityPeriod(ValidityPeriodDecoder.decodeObject(weatherSb));
		
		while(weatherSb.length() > 0) {
		
			taf.setWind(WindDecoder.decodeObject(weatherSb));
			taf.setVisibility(VisibilityDecoder.decodeObject(weatherSb));
			taf.setForecastWeather(WeatherDecoder.decodeObject(weatherSb));
			taf.setClouds(CloudsDecoder.decodeObject(weatherSb));
			taf.setIcingConditions(IcingConditionsDecoder.decodeObject(weatherSb));
			taf.setTurbulence(TurbulenceDecoder.decodeObject(weatherSb));
			taf.setWindShear(WindShearDecoder.decodeObject(weatherSb));
			taf.setMinimumAltimeterSettings(MinimumAltimeterSettingDecoder.decodeObject(weatherSb));
			taf.setTemperature(TemperatureDecoder.decodeObject(weatherSb));
			
			//Has to be added 2nd time as for some location wind shear group might follow after minimum altimerter setting group
			if (null == taf.getWindShear()) {
				taf.setWindShear(WindShearDecoder.decodeObject(weatherSb));
			}
			
			taf.setExpectedChanges(ExpectedChangeDecoder.decodeObject(weatherSb, tdResult));

			if (weatherSb.length() > 0) {
				tdResult.addUnparsedToken(CommonDecoder.getContentToParse(weatherSb));
				CommonDecoder.deleteParsedContent(weatherSb);
			}

		}		
		
		tdResult.setTaf(taf);
		
		return tdResult;
	}

	
	private static void decodeReportType(Taf taf, StringBuffer weatherSb) {
		if (weatherSb.substring(0, TAF.length()).equals(TAF)) {
			weatherSb.delete(0, TAF.length() + 1);
		}
		if (weatherSb.subSequence(0, COR.length()).equals(COR)) {
			taf.setCorrectedReport(true);
			weatherSb.delete(0, COR.length() + 1);
		}
		if (weatherSb.subSequence(0, AMD.length()).equals(AMD)) {
			taf.setUpdateOverPreviousReport(true);
			weatherSb.delete(0, TAF.length() + 1);
		}
	}

	private static void decodeAirportIcaoCode(Taf taf, StringBuffer weatherSb) throws DecoderException {
		if (weatherSb.toString().matches(ICAO_CODE_PATTERN)) {
			taf.setAirportIcaoCode(CommonDecoder.getContentToParse(weatherSb));
			CommonDecoder.deleteParsedContent(weatherSb);
		} else {
			throw new DecoderException("No Airport ICAO Code available");
		}
	}

}
