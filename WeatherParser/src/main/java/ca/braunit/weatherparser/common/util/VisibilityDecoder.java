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

import java.math.BigDecimal;
import java.math.MathContext;

import ca.braunit.weatherparser.common.domain.Visibility;
import ca.braunit.weatherparser.metar.util.CommonDecoder;
import ca.braunit.weatherparser.util.WeatherParserConstants;

public class VisibilityDecoder {

	private static final String NDV_STRING = "NDV";
	private static final String CAVOK_PATTERN = "(CAVOK)(.)*";
	private static final String STANDARD_VISIBILITY_PATTERN = "[\\d]{4}(\\s|NDV)(.)*";
	private static final String STANDARD_WITH_DIRECTION_VISIBILITY_PATTERN = "[\\d]{4}(N|NW|W|SW|S|SE|E|NE)(.)*";
	private static final String STATUTE_MILE_VISIBILITY_PATTERN = "(P)?[\\d]{1,4}SM(.)*";
	private static final String STATUTE_MILE_FRACTION_VISIBILITY_PATTERN = "([\\d] )?[\\d]/[\\d]SM(.)*";

	//Examples
	//8000 = 8000m
	//7000NW = 7000m to NorthWest
	//30SM = 30 Statue Miles
	//3/4SM = 3/4 Statue Miles

	public static Visibility decodeObject(StringBuffer metarAsString) {
		Visibility visibility = new Visibility();

		//Check for CAVOK
		if (metarAsString.toString().matches(CAVOK_PATTERN)) {
			visibility.setCavok(true);
			metarAsString.delete(0, "CAVOK".length()+1);
		} else if (metarAsString.toString().matches(STATUTE_MILE_VISIBILITY_PATTERN)) {
			if (metarAsString.toString().startsWith("P")) {
				visibility.setGreaterThan(true);
				metarAsString.delete(0, 1);
			}
			String visibilityString = metarAsString.substring(0, metarAsString.indexOf(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES));
			visibility.setVisibility(new BigDecimal(visibilityString));
			metarAsString.delete(0, visibilityString.length()+3);
			visibility.setVisibilityUnitOfMeasure(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES);
		} else if (metarAsString.toString().matches(STANDARD_VISIBILITY_PATTERN)) {
			
			if (metarAsString.substring(0,4).equals("9999")) {
				visibility.setVisibility(BigDecimal.TEN);
				visibility.setGreaterThan(true);
			} else {
				visibility.setVisibility(new BigDecimal(metarAsString.substring(0, 4)));				
			}
			metarAsString.delete(0, 4);
			if (metarAsString.substring(0, 3).equals(NDV_STRING)) {
				visibility.setNdv(true);
				metarAsString.delete(0, 4);				
			} else {
				metarAsString.delete(0, 1);								
			}
		} else if (metarAsString.toString().matches(STANDARD_WITH_DIRECTION_VISIBILITY_PATTERN)) {
			visibility.setVisibility(new BigDecimal(metarAsString.substring(0, 4))); 
			metarAsString.delete(0, 4);
			visibility.setDirection(metarAsString.substring(0, metarAsString.indexOf(" ")));
			metarAsString.delete(0, visibility.getDirection().length()+1);
		} else if (metarAsString.toString().matches(STATUTE_MILE_FRACTION_VISIBILITY_PATTERN)) {		
			//Check if 
			BigDecimal additionalStatuteMiles = BigDecimal.ZERO;
			if (" ".equals(metarAsString.substring(1, 2))) {
				additionalStatuteMiles = new BigDecimal(metarAsString.substring(0, metarAsString.indexOf(" ")));
				CommonDecoder.deleteParsedContent(metarAsString);
			}
			
			BigDecimal numerator = new BigDecimal(metarAsString.substring(0, metarAsString.indexOf("/")));
			BigDecimal divisor = new BigDecimal(metarAsString.substring(metarAsString.indexOf("/")+1,metarAsString.indexOf(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES)));
			visibility.setVisibility(numerator.divide(divisor, MathContext.DECIMAL32).add(additionalStatuteMiles));
			CommonDecoder.deleteParsedContent(metarAsString);
			visibility.setVisibilityUnitOfMeasure(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES);
		}
		
		return visibility;
	}
}
