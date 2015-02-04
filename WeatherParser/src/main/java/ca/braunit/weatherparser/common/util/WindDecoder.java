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
package ca.braunit.weatherparser.common.util;

import ca.braunit.weatherparser.common.domain.Wind;
import ca.braunit.weatherparser.metar.util.CommonDecoder;

public class WindDecoder {
	
	private static final String VARIABLE_WIND_DIVIDER = "V";

	private static final int WINDDIRECTION_LENGTH = 3;
	private static final int WINDSPEED_LENGTH = 2;

	private static final String WIND_PATTERN = "[\\d]{5}(KMH|MPS|KT)( |\\Z)(.)*";
	private static final String WIND_WITH_GUSTS_PATTERN = "[\\d]{5}(G)[\\d]{2}(KMH|MPS|KT)( |\\Z)(.)*";
	private static final String VARIABLE_WIND_PATTERN = "[\\d]{3}V[\\d]{3}( |\\Z)(.)*";
	private static final String VARIABLE_LIGHT_WIND_PATTERN = "VRB[\\d]{2}KT( |\\Z)(.)*";
	private static final String VARIABLE_WIND_WITH_GUSTS_PATTERN = "VRB[\\d]{2}((G)[\\d]{2})?KT( |\\Z)(.)*";
	
	public static Wind decodeObject(StringBuffer metarAsString) {
		Wind wind = new Wind();
		if(metarAsString.toString().matches(WIND_PATTERN)) {
			decodeWindPattern(metarAsString, wind);
		} else if(metarAsString.toString().matches(WIND_WITH_GUSTS_PATTERN)) {
			decodeWindWithGustsPattern(metarAsString, wind);
		}
		if (metarAsString.toString().matches(VARIABLE_WIND_PATTERN)) {
			decodeVariableWindDirection(metarAsString, wind);			
		} else if (metarAsString.toString().matches(VARIABLE_LIGHT_WIND_PATTERN)) {
			decodeLightVariableWind(metarAsString, wind);
		} else if (metarAsString.toString().matches(VARIABLE_WIND_WITH_GUSTS_PATTERN)) {
			decodeVariableWindWithGusts(metarAsString, wind);
		}
		return wind;
	}

	private static void decodeWindPattern(StringBuffer metarAsString, Wind wind) {
		decodeWindDirectionAndSpeed(metarAsString, wind);
		decodeSpeedUnitOfMeasure(metarAsString, wind);
	}

	private static void decodeWindWithGustsPattern(StringBuffer metarAsString, Wind wind) {
		decodeWindDirectionAndSpeed(metarAsString, wind);
		decodeWindSpeedGusts(metarAsString, wind);
		decodeSpeedUnitOfMeasure(metarAsString, wind);
	}

	private static void decodeWindDirectionAndSpeed(StringBuffer metarAsString, Wind wind) {
		wind.setWindDirection(Integer.parseInt(metarAsString.substring(0, WINDDIRECTION_LENGTH)));
		metarAsString.delete(0, WINDDIRECTION_LENGTH);
		wind.setWindSpeed(Integer.parseInt(metarAsString.substring(0, WINDSPEED_LENGTH)));
		metarAsString.delete(0, WINDSPEED_LENGTH);
	}
		
	private static void decodeSpeedUnitOfMeasure(StringBuffer metarAsString, Wind wind) {
		wind.setSpeedUnitOfMeasure(CommonDecoder.getContentToParse(metarAsString));
		CommonDecoder.deleteParsedContent(metarAsString);
	}
	
	private static void decodeWindSpeedGusts(StringBuffer metarAsString, Wind wind) {
		metarAsString.delete(0, 1);
		wind.setWindSpeedGusts(Integer.parseInt(metarAsString.substring(0, WINDSPEED_LENGTH)));
		metarAsString.delete(0, WINDSPEED_LENGTH);
	}
	
	private static void decodeVariableWindDirection(StringBuffer metarAsString, Wind wind) {
		if (metarAsString.substring(0,WINDDIRECTION_LENGTH+VARIABLE_WIND_DIVIDER.length()+WINDDIRECTION_LENGTH).matches(VARIABLE_WIND_PATTERN)) {
			wind.setVariableWindDirectionFrom(Integer.parseInt(metarAsString.substring(0, WINDDIRECTION_LENGTH)));
			metarAsString.delete(0, WINDDIRECTION_LENGTH+1);
			wind.setVariableWindDirectionTo(Integer.parseInt(metarAsString.substring(0, WINDDIRECTION_LENGTH)));
			metarAsString.delete(0, WINDDIRECTION_LENGTH+1);
			wind.setVariableWind(true);
		}
	}
	
	private static void decodeLightVariableWind(StringBuffer metarAsString, Wind wind) {
		metarAsString.delete(0, 3);
		wind.setVariableWind(true);
		wind.setWindSpeed(Integer.parseInt(metarAsString.substring(0, WINDSPEED_LENGTH)));
		metarAsString.delete(0, 2);
		decodeSpeedUnitOfMeasure(metarAsString, wind);
	}
	private static void decodeVariableWindWithGusts(StringBuffer metarAsString, Wind wind) {
		metarAsString.delete(0, 3);
		wind.setVariableWind(true);
		wind.setWindSpeed(Integer.parseInt(metarAsString.substring(0, WINDSPEED_LENGTH)));
		metarAsString.delete(0, 3);
		wind.setWindSpeedGusts(Integer.parseInt(metarAsString.substring(0, WINDSPEED_LENGTH)));
		metarAsString.delete(0, 2);
		decodeSpeedUnitOfMeasure(metarAsString, wind);
	}
}
