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

import ca.braunit.weatherparser.common.domain.ValidityPeriod;
import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.util.CommonDecoder;

public class ValidityPeriodDecoder {

	private static final String VALIDITY_PERIOD_PATTERN = "(\\d){4}(/)(\\d){4}.*";

	public static ValidityPeriod decodeObject(StringBuffer tafAsString) throws DecoderException {
		ValidityPeriod validityPeriod = new ValidityPeriod();
		if (tafAsString.toString().matches(VALIDITY_PERIOD_PATTERN)) {
			validityPeriod.setFromDayOfMonth(Integer.parseInt(tafAsString.substring(0,2)));
			validityPeriod.setFromHour(Integer.parseInt(tafAsString.substring(2,4)));
			validityPeriod.setToDayOfMonth(Integer.parseInt(tafAsString.substring(5,7)));
			validityPeriod.setToHour(Integer.parseInt(tafAsString.substring(7,9)));
			CommonDecoder.deleteParsedContent(tafAsString);
		}
		
		return validityPeriod;
	}
}
