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

import ca.braunit.weatherparser.common.domain.TimeInfo;
import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.util.CommonDecoder;

public class TimeInfoDecoder {

	private static final String TIME_INFO_PATTERN = "(\\d){6}(z|Z)?";

	public static TimeInfo decodeObject(StringBuffer tafAsString, boolean required) throws DecoderException {

		TimeInfo timeInfo = new TimeInfo();
		
		if (tafAsString.substring(0,tafAsString.indexOf(" ")).matches(TIME_INFO_PATTERN)) {
			timeInfo.setDayOfMonth(Integer.parseInt(tafAsString.substring(0,2)));
			timeInfo.setHour(Integer.parseInt(tafAsString.substring(2,4)));
			timeInfo.setMinute(Integer.parseInt(tafAsString.substring(4,6)));
		} else if (required) {
			throw new DecoderException("No ReportTime available");
		}
		CommonDecoder.deleteParsedContent(tafAsString);
		
		return timeInfo;
	}
}
