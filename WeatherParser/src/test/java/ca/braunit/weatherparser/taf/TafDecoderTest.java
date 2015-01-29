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
package ca.braunit.weatherparser.taf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.braunit.weatherparser.exception.DecoderException;

public class TafDecoderTest {

	@Test
	/**
	 * Check update over previous report
	 * 
	 * @throws DecoderException
	 */
	public void testUpdateOverPreviousReport() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_1);
		assertTrue(tdResult.getTaf().isUpdateOverPreviousReport());
	}

	@Test
	/**
	 * Check Airport ICAO Code Decoding
	 * 
	 * @throws DecoderException
	 */
	public void testAirportIcaoCode() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_1);
		assertEquals("CYVR", tdResult.getTaf().getAirportIcaoCode());
	}
	
	@Test
	/**
	 * Check Corrected Report Decoding
	 * 
	 * @throws DecoderException
	 */
	public void testCorrectedReport() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_3);
		assertTrue(tdResult.getTaf().isCorrectedReport());
	}

	@Test
	/**
	 * Check Issuance Time Decoding
	 * 
	 * @throws DecoderException
	 */
	public void testIssuanceTime() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_1);
		assertEquals(20, tdResult.getTaf().getIssuanceTime().getDayOfMonth().intValue());
		assertEquals(21, tdResult.getTaf().getIssuanceTime().getHour().intValue());
		assertEquals(00, tdResult.getTaf().getIssuanceTime().getMinute().intValue());
	}

}
