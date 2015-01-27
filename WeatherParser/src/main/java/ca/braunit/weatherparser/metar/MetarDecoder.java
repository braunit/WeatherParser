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
package ca.braunit.weatherparser.metar;

import ca.braunit.weatherparser.common.util.CloudsDecoder;
import ca.braunit.weatherparser.common.util.TimeInfoDecoder;
import ca.braunit.weatherparser.common.util.VisibilityDecoder;
import ca.braunit.weatherparser.common.util.WeatherDecoder;
import ca.braunit.weatherparser.common.util.WindDecoder;
import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.domain.Metar;
import ca.braunit.weatherparser.metar.util.CommonDecoder;
import ca.braunit.weatherparser.metar.util.PressureDecoder;
import ca.braunit.weatherparser.metar.util.RemarksDecoder;
import ca.braunit.weatherparser.metar.util.RunwayVisualRangeDecoder;
import ca.braunit.weatherparser.metar.util.TemperatureAndDewPointDecoder;
import ca.braunit.weatherparser.metar.util.WindShearDecoder;

/**
 * This class implements the functionality to decode METAR (Meteorological Terminal Aviation 
 * Routine Weather Report) weather data.
 * @author Alexander Braun
 */
public class MetarDecoder {

	private static final String METAR = "METAR";
	private static final String SPECI = "SPECI";
	private static final String CORRECTED = "COR";
	private static final String AUTOMATED_OBSERVATION = "AUTO";

	private static final String ICAO_CODE_PATTERN = "[A-Za-z]{4}( |\\Z)(.)*";

	/**
	 * This method decodes TAF METAR (Meteorological Terminal Aviation 
	 * Routine Weather Report) weather data.
	 * @param weatherString the weather String encoded in METAR format.
	 * @return a {@link Metar} object 
	 * @throws DecoderException in case of missing or unknown patterns.
	 */
	public static MetarDecoderResult decodeMetar(String weatherString) throws DecoderException {
		return decodeObject(new StringBuffer(CommonDecoder.prepareWeatherString(weatherString)));
	}

	private static MetarDecoderResult decodeObject(StringBuffer weatherSb) throws DecoderException {

		MetarDecoderResult mdResult = new MetarDecoderResult();
		
		Metar metar = new Metar();
		deodeReportType(metar, weatherSb);
		decodeAirportIcaoCode(metar, weatherSb);
		
		metar.setReportTime(TimeInfoDecoder.decodeObject(weatherSb, true));
		
		decodeAutomatedObservation(metar, weatherSb);
				
		while(weatherSb.length() > 0) {
			metar.setWind(WindDecoder.decodeObject(weatherSb));
			metar.setVisibility(VisibilityDecoder.decodeObject(weatherSb));
			metar.setRunwayVisualRanges(RunwayVisualRangeDecoder.decodeObject(weatherSb));
			
			metar.setPresentWeather(WeatherDecoder.decodeObject(weatherSb));
			
			metar.setClouds(CloudsDecoder.decodeObject(weatherSb));
			
			metar.setTemperatureAndDewPoint(TemperatureAndDewPointDecoder.decodeObject(weatherSb));
			
			metar.setPressure(PressureDecoder.decodeObject(weatherSb));
			
			metar.setRecentWeather(WeatherDecoder.decodeObject(weatherSb));
			
			metar.setWindShear(WindShearDecoder.decodeObject(weatherSb));
			
			metar.setRemarks(RemarksDecoder.decodeObject(weatherSb));

			if (weatherSb.length() > 0) {
				mdResult.addUnparsedToken(CommonDecoder.getContentToParse(weatherSb));
				CommonDecoder.deleteParsedContent(weatherSb);
			}

		}
		
		mdResult.setMetar(metar);
		
		return mdResult;
	}
	
	private static void deodeReportType(Metar metar, StringBuffer weatherSb) {
		if (weatherSb.toString().startsWith(CORRECTED)) {
			metar.setCorrectedReport(true);
			CommonDecoder.deleteParsedContent(weatherSb);
		}
		
		if (weatherSb.substring(0, METAR.length()).equals(METAR)) {
			metar.setMetarType(true);
			weatherSb.delete(0, METAR.length()+1);
		} else if (weatherSb.substring(0, SPECI.length()).equals(SPECI)) {
			metar.setSpeciType(true);
			weatherSb.delete(0, SPECI.length()+1);
		} else {
			metar.setMetarType(true);
		}
	}
	
	private static void decodeAirportIcaoCode(Metar metar, StringBuffer weatherSb) throws DecoderException {
		if (weatherSb.toString().matches(ICAO_CODE_PATTERN)) {
			metar.setAirportIcaoCode(CommonDecoder.getContentToParse(weatherSb));
			CommonDecoder.deleteParsedContent(weatherSb);
		} else {
			throw new DecoderException("No Airport ICAO Code available");
		}
	}
	
	private static void decodeAutomatedObservation(Metar metar, StringBuffer weatherSb) {
		if(weatherSb.substring(0,AUTOMATED_OBSERVATION.length()).equals(AUTOMATED_OBSERVATION)) {
			metar.setAutomatedObservation(true);
			weatherSb.delete(0, AUTOMATED_OBSERVATION.length()+1);
		}
	}
}
