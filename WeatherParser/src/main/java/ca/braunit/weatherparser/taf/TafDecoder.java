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
import ca.braunit.weatherparser.taf.domain.Taf;
import ca.braunit.weatherparser.taf.util.ExpectedChangeDecoder;
import ca.braunit.weatherparser.taf.util.IcingConditionsDecoder;
import ca.braunit.weatherparser.taf.util.MinimumAltimeterSettingDecoder;
import ca.braunit.weatherparser.taf.util.TemperatureDecoder;
import ca.braunit.weatherparser.taf.util.TurbulenceDecoder;
import ca.braunit.weatherparser.taf.util.WindShearDecoder;

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
public class TafDecoder {

	private static final String TAF = "TAF";
	private static final String AMD = "AMD";
	
	private static final String ICAO_CODE_PATTERN = "[A-Za-z]{4}";
	
	public static Taf decodeTaf(String tafAsString) throws DecoderException {
		return decodeObject(new StringBuffer(tafAsString.trim()));
	}

	public static Taf decodeObject(StringBuffer tafAsString) throws DecoderException {
		Taf taf = new Taf();
		decodeReportType(taf, tafAsString);
		decodeAirportIcaoCode(taf, tafAsString);
		taf.setIssuanceTime(TimeInfoDecoder.decodeObject(tafAsString, true));
		taf.setValidityPeriod(ValidityPeriodDecoder.decodeObject(tafAsString));
		taf.setWind(WindDecoder.decodeObject(tafAsString));
		taf.setVisibility(VisibilityDecoder.decodeObject(tafAsString));
		taf.setForecastWeather(WeatherDecoder.decodeObject(tafAsString));
		taf.setClouds(CloudsDecoder.decodeObject(tafAsString));
		taf.setIcingConditions(IcingConditionsDecoder.decodeObject(tafAsString));
		taf.setTurbulence(TurbulenceDecoder.decodeObject(tafAsString));
		taf.setWindShear(WindShearDecoder.decodeObject(tafAsString));
		taf.setMinimumAltimeterSettings(MinimumAltimeterSettingDecoder.decodeObject(tafAsString));
		taf.setMaximumTemperature(TemperatureDecoder.decodeObject(tafAsString));
		taf.setMinimumTemperature(TemperatureDecoder.decodeObject(tafAsString));
		
		//Has to be added 2nd time as for some location wind shear group might follow after minimum altimerter setting group
		if (null == taf.getWindShear()) {
			taf.setWindShear(WindShearDecoder.decodeObject(tafAsString));
		}
		
		taf.setExpectedChanges(ExpectedChangeDecoder.decodeObject(tafAsString));
		return taf;
	}

	
	private static void decodeReportType(Taf taf, StringBuffer tafAsString) {
		if (tafAsString.substring(0, TAF.length()).equals(TAF)) {
			tafAsString.delete(0, TAF.length() + 1);
		}
		if (tafAsString.subSequence(0, AMD.length()).equals(AMD)) {
			taf.setUpdateOverPreviousReport(true);
			tafAsString.delete(0, TAF.length() + 1);
		}
	}

	private static void decodeAirportIcaoCode(Taf taf, StringBuffer tafAsString) throws DecoderException {
		if (tafAsString.substring(0,tafAsString.indexOf(" ")).matches(ICAO_CODE_PATTERN)) {
			taf.setAirportIcaoCode(tafAsString.substring(0,tafAsString.indexOf(" ")));
			tafAsString.delete(0, tafAsString.indexOf(" ")+1);
		} else {
			throw new DecoderException("No Airport ICAO Code available");
		}
	}

}
