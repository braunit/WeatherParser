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
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.taf.ExampleMessagesTaf;
import ca.braunit.weatherparser.taf.TafDecoder;
import ca.braunit.weatherparser.taf.TafDecoderResult;
import ca.braunit.weatherparser.util.WeatherParserConstants;

public class VisibilityDecoderTest {

	@Test
	/**
	 * Check Visibility Decoding
	 * 
	 * @throws DecoderException
	 */
	public void testVisibility() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_1);
		assertEquals(new BigDecimal("6"), tdResult.getTaf().getVisibility().get(0).getVisibility());
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES, tdResult.getTaf().getVisibility().get(0).getVisibilityUnitOfMeasure());
		assertTrue(tdResult.getTaf().getVisibility().get(0).isGreaterThan());
	}

}
