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

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.domain.ReportTime;

public class ReportTimeDecoder {

	private static final String REPORT_TIME_PATTERN = "(\\d){6}(z|Z)";

	public static ReportTime decodeObject(StringBuffer metarAsString) throws DecoderException {
		ReportTime repTime = new ReportTime();
		if (metarAsString.substring(0,metarAsString.indexOf(" ")).matches(REPORT_TIME_PATTERN)) {
			repTime.setDayOfMonth(Integer.parseInt(metarAsString.substring(0,2)));
			repTime.setHour(Integer.parseInt(metarAsString.substring(2,4)));
			repTime.setMinute(Integer.parseInt(metarAsString.substring(4,6)));
		} else {
			throw new DecoderException("No ReportTime available");
		}
		
		metarAsString.delete(0, metarAsString.indexOf(" ")+1);
		
		return repTime;
	}

}
