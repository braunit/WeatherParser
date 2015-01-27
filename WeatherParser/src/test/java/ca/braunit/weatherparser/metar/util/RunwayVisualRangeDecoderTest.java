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

import org.junit.Test;

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.ExampleMessagesMetar;
import ca.braunit.weatherparser.metar.MetarDecoder;
import ca.braunit.weatherparser.metar.MetarDecoderResult;
import ca.braunit.weatherparser.util.WeatherParserConstants;

public class RunwayVisualRangeDecoderTest {

	@Test
	/**
	 * Check Visibility Decoding (Meter)
	 * @throws DecoderException
	 */
	public void testRunwayVisualRangeMeter() throws DecoderException {
		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_3);
		assertEquals("20", mdResult.getMetar().getRunwayVisualRanges().get(0).getRunway());
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_METER, mdResult.getMetar().getRunwayVisualRanges().get(0).getUnitOfMeasure());
		assertEquals(900, mdResult.getMetar().getRunwayVisualRanges().get(0).getVisibileRange().intValue());
	}
	
	@Test
	/**
	 * Check Visibility Decoding (Feet)
	 * @throws DecoderException
	 */
	public void testRunwayVisualRangeFeet() throws DecoderException {
		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_1);
		assertEquals("01L", mdResult.getMetar().getRunwayVisualRanges().get(0).getRunway());
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_FEET, mdResult.getMetar().getRunwayVisualRanges().get(0).getUnitOfMeasure());
		assertEquals(800, mdResult.getMetar().getRunwayVisualRanges().get(0).getVisibileRange().intValue());
	}

	@Test
	/**
	 * Check Visibility Decoding (Feet with Variety)
	 * @throws DecoderException
	 */
	public void testRunwayVisualRangeFeetWithVariety() throws DecoderException {
		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_2);
		assertEquals("01L", mdResult.getMetar().getRunwayVisualRanges().get(0).getRunway());
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_FEET, mdResult.getMetar().getRunwayVisualRanges().get(0).getUnitOfMeasure());
		assertEquals(800, mdResult.getMetar().getRunwayVisualRanges().get(0).getVisibileRange().intValue());
		assertEquals(1600, mdResult.getMetar().getRunwayVisualRanges().get(0).getVisibileRangeVariety().intValue());
	}

	
}
