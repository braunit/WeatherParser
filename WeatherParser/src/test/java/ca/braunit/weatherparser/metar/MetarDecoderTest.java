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
package ca.braunit.weatherparser.metar;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.braunit.weatherparser.exception.DecoderException;

/**
 * Unit test simple MetarDecoder.
 */
public class MetarDecoderTest {
	

	@Test
	/**
	 * Check Airport ICAO Code Decoding
	 * 
	 * @throws DecoderException
	 */
	public void testAirportIcaoCode() throws DecoderException {
		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_1);
		assertEquals("CYVR", mdResult.getMetar().getAirportIcaoCode());
	}
	
	@Test(expected=DecoderException.class)
	/**
	 * Check Airport ICAO Code is missing
	 * 
	 * @throws DecoderException
	 */
	public void testAirportIcaoCodeMissing() throws DecoderException {
		MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_1.substring(5));
	}
	
	@Test
	/**
	 * Check Report Time Decoding
	 * @throws DecoderException
	 */
	public void testReportTime() throws DecoderException {
		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_1);
		assertEquals(3, mdResult.getMetar().getReportTime().getDayOfMonth().intValue());
		assertEquals(1, mdResult.getMetar().getReportTime().getHour().intValue());
		assertEquals(0, mdResult.getMetar().getReportTime().getMinute().intValue());
	}
	
}
