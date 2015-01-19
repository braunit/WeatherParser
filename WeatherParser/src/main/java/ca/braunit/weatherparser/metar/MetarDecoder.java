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

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.domain.Metar;
import ca.braunit.weatherparser.metar.util.CloudsDecoder;
import ca.braunit.weatherparser.metar.util.PressureDecoder;
import ca.braunit.weatherparser.metar.util.ReportTimeDecoder;
import ca.braunit.weatherparser.metar.util.RunwayVisualRangeDecoder;
import ca.braunit.weatherparser.metar.util.TemperatureAndDewPointDecoder;
import ca.braunit.weatherparser.metar.util.VisibilityDecoder;
import ca.braunit.weatherparser.metar.util.WeatherDecoder;
import ca.braunit.weatherparser.metar.util.WindDecoder;
import ca.braunit.weatherparser.metar.util.WindShearDecoder;

public class MetarDecoder {

	private static final String METAR = "METAR";
	private static final String SPECI = "SPECI";
	private static final String CORRECTED = "COR";
	private static final String AUTOMATED_OBSERVATION = "AUTO";

	private static final String ICAO_CODE_PATTERN = "[A-Za-z]{4}";

	public static Metar decodeMetar(String metarAsString) throws DecoderException {
		return decodeObject(new StringBuffer(metarAsString.trim()));
	}

	public static Metar decodeObject(StringBuffer metarAsString) throws DecoderException {
		Metar metar = new Metar();
		deodeReportType(metar, metarAsString);
		decodeAirportIcaoCode(metar, metarAsString);
		
		metar.setReportTime(ReportTimeDecoder.decodeObject(metarAsString));
		
		decodeAutomatedObservation(metar, metarAsString);
		
		metar.setWind(WindDecoder.decodeObject(metarAsString));
		metar.setVisibility(VisibilityDecoder.decodeObject(metarAsString));
		metar.setRunwayVisualRanges(RunwayVisualRangeDecoder.decodeObject(metarAsString));
		
		metar.setPresentWeather(WeatherDecoder.decodeObject(metarAsString, true));
		
		metar.setClouds(CloudsDecoder.decodeObject(metarAsString));
		
		metar.setTemperatureAndDewPoint(TemperatureAndDewPointDecoder.decodeObject(metarAsString));
		
		metar.setPressure(PressureDecoder.decodeObject(metarAsString));
		
		metar.setRecentWeather(WeatherDecoder.decodeObject(metarAsString, false));
		
		metar.setWindShear(WindShearDecoder.decodeObject(metarAsString));
		
		return metar;
	}
	
	private static void deodeReportType(Metar metar, StringBuffer metarAsString) {
		if (metarAsString.substring(0, METAR.length()).equals(METAR)) {
			metar.setMetarType(true);
			metarAsString.delete(0, METAR.length()+1);
		} else if (metarAsString.substring(0, SPECI.length()).equals(SPECI)) {
			metar.setSpeciType(true);
			metarAsString.delete(0, SPECI.length()+1);
		} else {
			metar.setMetarType(true);
		}
	}
	
	private static void decodeAirportIcaoCode(Metar metar, StringBuffer metarAsString) throws DecoderException {
		if (metarAsString.substring(0,metarAsString.indexOf(" ")).matches(ICAO_CODE_PATTERN)) {
			metar.setAirportIcaoCode(metarAsString.substring(0,metarAsString.indexOf(" ")));
			metarAsString.delete(0, metarAsString.indexOf(" ")+1);
		} else {
			throw new DecoderException("No Airport ICAO Code available");
		}
	}
	
	private static void decodeAutomatedObservation(Metar metar, StringBuffer metarAsString) {
		if(metarAsString.substring(0,AUTOMATED_OBSERVATION.length()).equals(AUTOMATED_OBSERVATION)) {
			metar.setAutomatedObservation(true);
			metarAsString.delete(0, AUTOMATED_OBSERVATION.length()+1);
		}
	}
}
