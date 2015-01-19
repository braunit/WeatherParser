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
package ca.braunit.weatherparser.metar.util;

import ca.braunit.weatherparser.metar.domain.Wind;

public class WindDecoder {
	
	private static final String KILOMETERS_PER_HOUR = "KMH";
	private static final String MILES_PER_HOUR = "MPS";
	private static final String KNOTS = "KT";
	private static final String WIND_GUSTS_DIVIDER = "G";
	private static final String VARIABLE_WIND_DIVIDER = "V";

	private static final int WINDDIRECTION_LENGTH = 3;
	private static final int WINDSPEED_LENGTH = 2;

	private static final String WIND_PATTERN = String.format("[\\d]{%s}(%s|%s|%s.)", WINDDIRECTION_LENGTH+WINDSPEED_LENGTH, KILOMETERS_PER_HOUR, MILES_PER_HOUR, KNOTS);
	private static final String WIND_WITH_GUSTS_PATTERN = String.format("[\\d]{%s}(%s)[\\d]{%s}(%s|%s|%s.)", WINDDIRECTION_LENGTH+WINDSPEED_LENGTH, WIND_GUSTS_DIVIDER, WINDSPEED_LENGTH, KILOMETERS_PER_HOUR, MILES_PER_HOUR, KNOTS);
	private static final String VARIABLE_WIND_PATTERN = String.format("[\\d]{%s}%s[\\d]{%s}", WINDDIRECTION_LENGTH, VARIABLE_WIND_DIVIDER, WINDDIRECTION_LENGTH);
	
	public static Wind decodeObject(StringBuffer metarAsString) {
		Wind wind = new Wind();
		if(metarAsString.substring(0,WINDDIRECTION_LENGTH+WINDSPEED_LENGTH+KILOMETERS_PER_HOUR.length()).matches(WIND_PATTERN)) {
			decodeWindPattern(metarAsString, wind);
		} else if(metarAsString.substring(0,WINDDIRECTION_LENGTH+WINDSPEED_LENGTH+VARIABLE_WIND_DIVIDER.length()+WINDSPEED_LENGTH+KILOMETERS_PER_HOUR.length()).matches(WIND_WITH_GUSTS_PATTERN)) {
			decodeWindWithGustsPattern(metarAsString, wind);
		}
		decodeVariableWindDirection(metarAsString, wind);
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
		wind.setSpeedUnitOfMeasure(metarAsString.substring(0,KILOMETERS_PER_HOUR.length()).trim());
		metarAsString.delete(0, wind.getSpeedUnitOfMeasure().length()+1);
	}
	
	private static void decodeWindSpeedGusts(StringBuffer metarAsString, Wind wind) {
		wind.setWindSpeedGusts(Integer.parseInt(metarAsString.substring(0, WINDSPEED_LENGTH)));
		metarAsString.delete(0, WINDSPEED_LENGTH);
	}
	
	private static void decodeVariableWindDirection(StringBuffer metarAsString, Wind wind) {
		if (metarAsString.substring(0,WINDDIRECTION_LENGTH+VARIABLE_WIND_DIVIDER.length()+WINDDIRECTION_LENGTH).matches(VARIABLE_WIND_PATTERN)) {
			wind.setVariableWindDirectionFrom(Integer.parseInt(metarAsString.substring(0, WINDDIRECTION_LENGTH)));
			metarAsString.delete(0, WINDDIRECTION_LENGTH+1);
			wind.setVariableWindDirectionTo(Integer.parseInt(metarAsString.substring(0, WINDDIRECTION_LENGTH)));
			metarAsString.delete(0, WINDDIRECTION_LENGTH+1);
		}
	}
}
