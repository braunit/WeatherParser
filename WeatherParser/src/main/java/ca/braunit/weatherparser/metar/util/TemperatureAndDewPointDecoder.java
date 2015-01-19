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

import ca.braunit.weatherparser.metar.domain.TemperatureAndDewPoint;

public class TemperatureAndDewPointDecoder {

	private static final String TEMPERATURE_AND_DEW_POINT_PATTERN = "(M)?(\\d){2}/(M)?(\\d){2}";

	public static TemperatureAndDewPoint decodeObject(StringBuffer metarAsString) {

		TemperatureAndDewPoint tad = null;
		
		if (metarAsString.substring(0, metarAsString.indexOf(" ")).toString().matches(TEMPERATURE_AND_DEW_POINT_PATTERN)) {
			tad = new TemperatureAndDewPoint();
			int multiplier = 1;
			if (metarAsString.toString().startsWith("M")) {
				metarAsString.delete(0, 1);
				multiplier = -1;
			}
			tad.setTemperature(Integer.parseInt(metarAsString.substring(0, 2)) * multiplier);
			metarAsString.delete(0, 3);
			if (metarAsString.toString().startsWith("M")) {
				metarAsString.delete(0, 1);
				multiplier = -1;
			} else {
				multiplier = 1;
			}
			tad.setDewPoint(Integer.parseInt(metarAsString.substring(0, 2)) * multiplier);
			
			metarAsString.delete(0, metarAsString.indexOf(" ") + 1);
			
		}
		return tad;

	}
}
