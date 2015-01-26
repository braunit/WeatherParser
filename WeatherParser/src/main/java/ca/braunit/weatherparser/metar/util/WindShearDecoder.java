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

import java.util.ArrayList;
import java.util.List;

import ca.braunit.weatherparser.metar.domain.WindShear;

public class WindShearDecoder {

	private static final String WIND_SHEAR_PATTERN = "WS ((RWY([\\d]{2}(L|R|C)?))|ALL RWY)( |\\Z)(.)*";

	public static List<WindShear> decodeObject(StringBuffer metarAsString) {
		List<WindShear> windShearList = new ArrayList<WindShear>();
		
		while (metarAsString.toString().matches(WIND_SHEAR_PATTERN)) {
			WindShear windShear = new WindShear();
			
			metarAsString.delete(0, 3);
			
			if (metarAsString.toString().startsWith("ALL RWY")) {
				windShear.setAllRunways(true);
				metarAsString.delete(0, 7);
			} else {
				metarAsString.delete(0, 3);				
				windShear.setRunwayIdentifier(CommonDecoder.getContentToParse(metarAsString));
				CommonDecoder.deleteParsedContent(metarAsString);
			}
			windShearList.add(windShear);
		}
		return windShearList;
		
	}
}
