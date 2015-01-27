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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.taf.ExampleMessagesTaf;
import ca.braunit.weatherparser.taf.TafDecoder;
import ca.braunit.weatherparser.taf.TafDecoderResult;

public class ValidityPeriodDecoderTest {

	@Test
	/**
	 * Check Validity Period Decoding
	 * 
	 * @throws DecoderException
	 */
	public void testValidityPeriod() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_1);
		assertEquals(20, tdResult.getTaf().getValidityPeriod().getFromDayOfMonth().intValue());
		assertEquals(21, tdResult.getTaf().getValidityPeriod().getFromHour().intValue());
		assertEquals(21, tdResult.getTaf().getValidityPeriod().getToDayOfMonth().intValue());
		assertEquals(24, tdResult.getTaf().getValidityPeriod().getToHour().intValue());
	}

}
