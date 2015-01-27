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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.ExampleMessagesMetar;
import ca.braunit.weatherparser.metar.MetarDecoder;
import ca.braunit.weatherparser.metar.MetarDecoderResult;
import ca.braunit.weatherparser.util.WeatherParserConstants;

/**
 * Unit Test for Wind Decoder
 * @author abraun
 *
 */
public class WindDecoderTest {

	@Test
	/**
	 * Check Wind Decoder (with Gusts)
	 * @throws DecoderException
	 */
	public void testWindWithGusts() throws DecoderException {

		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_2);
		
		assertEquals(80, mdResult.getMetar().getWind().getWindDirection().intValue());
		assertEquals(6, mdResult.getMetar().getWind().getWindSpeed().intValue());
		assertEquals(10, mdResult.getMetar().getWind().getWindSpeedGusts().intValue());
		
	}

	@Test
	/**
	 * Check Wind Decoder (with Gusts)
	 * @throws DecoderException
	 */
	public void testLightVariableWind() throws DecoderException {

		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_3);
		
		assertTrue(mdResult.getMetar().getWind().isVariableWind());
		assertEquals(2, mdResult.getMetar().getWind().getWindSpeed().intValue());
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_KNOTS, mdResult.getMetar().getWind().getSpeedUnitOfMeasure());
		
	}

}
