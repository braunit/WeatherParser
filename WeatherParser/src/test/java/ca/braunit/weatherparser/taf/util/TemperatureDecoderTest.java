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

import org.junit.Test;

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.taf.ExampleMessagesTaf;
import ca.braunit.weatherparser.taf.TafDecoder;
import ca.braunit.weatherparser.taf.TafDecoderResult;

public class TemperatureDecoderTest {

	@Test
	/**
	 * Check Temperature Decoding (Min and Max Temperature)
	 * 
	 * @throws DecoderException
	 */
	public void testMinAndMaxTemperature() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_4);
		
		assertEquals(14, tdResult.getTaf().getTemperature().get(0).getTemperature().intValue());
		assertEquals(13, tdResult.getTaf().getTemperature().get(0).getTime().getDayOfMonth().intValue());
		assertEquals(16, tdResult.getTaf().getTemperature().get(0).getTime().getHour().intValue());
		assertTrue(tdResult.getTaf().getTemperature().get(0).isMaximumTemperature());

		assertEquals(10, tdResult.getTaf().getTemperature().get(1).getTemperature().intValue());
		assertEquals(14, tdResult.getTaf().getTemperature().get(1).getTime().getDayOfMonth().intValue());
		assertEquals(4, tdResult.getTaf().getTemperature().get(1).getTime().getHour().intValue());
		assertTrue(tdResult.getTaf().getTemperature().get(1).isMinimumTemperature());
		
	}

}
