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

import java.math.BigDecimal;

import org.junit.Test;

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.ExampleMessagesMetar;
import ca.braunit.weatherparser.metar.MetarDecoder;
import ca.braunit.weatherparser.metar.domain.Metar;
import ca.braunit.weatherparser.util.WeatherParserConstants;

/**
 * Unit Test for Visibility Decoder
 * @author abraun
 */
public class VisibilityDecoderTest {

	@Test
	/**
	 * Check Visibility Decoding (Statute Miles)
	 * @throws DecoderException
	 */
	public void testVisibilityStatuteMiles() throws DecoderException {
		Metar metar = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_1);
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES, metar.getVisibility().getVisibilityUnitOfMeasure());
		assertEquals(new BigDecimal("6"), metar.getVisibility().getVisibility());
	}
	
	@Test
	/**
	 * Check Visibility Decoding (Meters)
	 * @throws DecoderException
	 */
	public void testVisibilityMeter() throws DecoderException {
		Metar metar = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_2);
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_METER, metar.getVisibility().getVisibilityUnitOfMeasure());
		assertEquals(new BigDecimal("2000"), metar.getVisibility().getVisibility());
	}
	
	@Test
	/**
	 * Check Visibility Decoding (CAVOK)
	 * @throws DecoderException
	 */
	public void testVisibilityCavok() throws DecoderException {
		Metar metar = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_3);
		assertTrue(metar.getVisibility().isCavok());
	}

	@Test
	/**
	 * Check Visibility Decoding (Fraction Statute Miles)
	 * @throws DecoderException
	 */
	public void testVisibilityFractionStatuteMiles() throws DecoderException {
		Metar metar = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_4);
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES, metar.getVisibility().getVisibilityUnitOfMeasure());
		assertEquals(new BigDecimal("0.75"), metar.getVisibility().getVisibility());
	}

	@Test
	/**
	 * Check Visibility Decoding (Meters with NDV Indicator)
	 * @throws DecoderException
	 */
	public void testVisibilityMetersWithNDV() throws DecoderException {
		Metar metar = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_5);
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_METER, metar.getVisibility().getVisibilityUnitOfMeasure());
		assertEquals(new BigDecimal("2000"), metar.getVisibility().getVisibility());
		assertTrue(metar.getVisibility().isNdv());
	}

	@Test
	/**
	 * Check Visibility Decoding (Meters with Direction)
	 * @throws DecoderException
	 */
	public void testVisibilityMetersWithDirection() throws DecoderException {
		Metar metar = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_6);
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_METER, metar.getVisibility().getVisibilityUnitOfMeasure());
		assertEquals(new BigDecimal("2000"), metar.getVisibility().getVisibility());
		assertEquals("NE", metar.getVisibility().getDirection());
	}

	
}
