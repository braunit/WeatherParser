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
package ca.braunit.weatherparser.taf.util;

import java.util.ArrayList;
import java.util.List;

import ca.braunit.weatherparser.taf.domain.Temperature;
import ca.braunit.weatherparser.util.WeatherParserConstants;
import ca.braunit.weatherparser.common.domain.TimeInfo;
import ca.braunit.weatherparser.metar.util.CommonDecoder;

public class TemperatureDecoder {
	
	private static final String MAXIMUM_TEMPERATURE = "X";
	private static final String MINIMUM_TEMPERATURE = "N";
	
	private static final String TEMPERATURE_PATTERN = "T(N|X)?(M)?(\\d){2}/(\\d){4}(z|Z)( |\\Z)(.)*";
	
	public static List<Temperature> decodeObject(StringBuffer tafAsString) {

		List<Temperature> tempList = new ArrayList<Temperature>();
		
		Temperature temperature = null;		
		while (tafAsString.toString().matches(TEMPERATURE_PATTERN)) {
			temperature = new Temperature();
			
			tafAsString.delete(0, 1);
			int multiplier = 1;
			if (tafAsString.toString().startsWith(MAXIMUM_TEMPERATURE)) {
				temperature.setMaximumTemperature(true);
				tafAsString.delete(0, 1);
			}
			if (tafAsString.toString().startsWith(MINIMUM_TEMPERATURE)) {
				temperature.setMinimumTemperature(true);
				tafAsString.delete(0, 1);
			}
			if (tafAsString.toString().startsWith(WeatherParserConstants.NEGATIVE_VALUE_CODE)) {
				multiplier = -1;
				tafAsString.delete(0, 1);
			}
			temperature.setTemperature(Integer.parseInt(tafAsString.substring(0,2)) * multiplier);
			tafAsString.delete(0, 3);
			TimeInfo time = new TimeInfo();
			
			time.setDayOfMonth(Integer.parseInt(tafAsString.substring(0,2)));
			tafAsString.delete(0, 2);
			time.setHour(Integer.parseInt(tafAsString.substring(0,2)));
			time.setMinute(0);
			temperature.setTime(time);
			
			CommonDecoder.deleteParsedContent(tafAsString);
			
			tempList.add(temperature);
		}
		return tempList;

	}


}
