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
import ca.braunit.weatherparser.taf.domain.ExpectedChange.ChangeType;
import ca.braunit.weatherparser.util.WeatherParserConstants;

public class ExpectedChangeDecoderTest {

	@Test
	/**
	 * Check ExpectedChange Decoding
	 * 
	 * @throws DecoderException
	 */
	public void testExpectedChange() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_1);
		
		assertEquals(ChangeType.FROM, tdResult.getTaf().getExpectedChanges().get(1).getChangeType());
		assertEquals(new BigDecimal("1.5"), tdResult.getTaf().getExpectedChanges().get(1).getVisibility().get(0).getVisibility());
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES, tdResult.getTaf().getExpectedChanges().get(1).getVisibility().get(0).getVisibilityUnitOfMeasure());
		assertTrue(tdResult.getTaf().getExpectedChanges().get(1).getWindShear().isPotentialWindShear());
		assertEquals(2, tdResult.getTaf().getExpectedChanges().get(1).getIcingConditions().getIcingIntensityCode().intValue());
		assertEquals(3000, tdResult.getTaf().getExpectedChanges().get(1).getIcingConditions().getIcingLayerBase().intValue());
		assertEquals(4000, tdResult.getTaf().getExpectedChanges().get(1).getIcingConditions().getIcingLayerDepth().intValue());
		assertEquals(2, tdResult.getTaf().getExpectedChanges().get(1).getTurbulence().getTurbulenceIntensityCode().intValue());
		assertEquals(2000, tdResult.getTaf().getExpectedChanges().get(1).getTurbulence().getTurbulenceLayerBase().intValue());
		assertEquals(4000, tdResult.getTaf().getExpectedChanges().get(1).getTurbulence().getTurbulenceLayerDepth().intValue());
		
		assertEquals(999, tdResult.getTaf().getExpectedChanges().get(1).getMinimumAltimeterSettings().getPressure().intValue());

		assertEquals(10, tdResult.getTaf().getExpectedChanges().get(1).getTemperature().get(0).getTemperature().intValue());
		assertEquals(21, tdResult.getTaf().getExpectedChanges().get(1).getTemperature().get(0).getTime().getDayOfMonth().intValue());
		assertEquals(4, tdResult.getTaf().getExpectedChanges().get(1).getTemperature().get(0).getTime().getHour().intValue());

		assertEquals(-5, tdResult.getTaf().getExpectedChanges().get(1).getTemperature().get(1).getTemperature().intValue());
		assertEquals(21, tdResult.getTaf().getExpectedChanges().get(1).getTemperature().get(1).getTime().getDayOfMonth().intValue());
		assertEquals(6, tdResult.getTaf().getExpectedChanges().get(1).getTemperature().get(1).getTime().getHour().intValue());
		
	}

	
	@Test
	/**
	 * Check ExpectedChange Decoding empty probability
	 * 
	 * @throws DecoderException
	 */
	public void testEmptyProbability() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_2);
		
		assertEquals(ChangeType.TEMPORARY, tdResult.getTaf().getExpectedChanges().get(0).getChangeType());
		assertEquals(40, tdResult.getTaf().getExpectedChanges().get(0).getProbabilityOfChange().intValue());
		
		
		assertEquals("AAAA", tdResult.getUnparsedTokens().get(0));
		assertEquals("BBBB", tdResult.getUnparsedTokens().get(1));
		
	}

	
	@Test
	/**
	 * Check ExpectedChange Decoding probability
	 * 
	 * @throws DecoderException
	 */
	public void testProbability() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_5);
		
		assertEquals(ChangeType.PROBABILITY, tdResult.getTaf().getExpectedChanges().get(4).getChangeType());
		assertEquals(30, tdResult.getTaf().getExpectedChanges().get(4).getProbabilityOfChange().intValue());
			
	}
	
	@Test
	/**
	 * 
	 * Check ExpectedChange, only WInd Information available
	 * 
	 * @throws DecoderException
	 */
	public void testBecomingWindChangeOnly() throws DecoderException {
		TafDecoderResult tdResult = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_7);
		
		assertEquals(ChangeType.BECOMING, tdResult.getTaf().getExpectedChanges().get(0).getChangeType());
		
	}
	
}