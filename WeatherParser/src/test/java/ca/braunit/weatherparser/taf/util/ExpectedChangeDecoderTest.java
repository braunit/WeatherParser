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
import ca.braunit.weatherparser.taf.domain.Taf;
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
		Taf taf = TafDecoder.decodeTaf(ExampleMessagesTaf.TAF_EXAMPLE_1);
		
		assertEquals(ChangeType.FROM, taf.getExpectedChanges().get(1).getChangeType());
		assertEquals(new BigDecimal("1.5"), taf.getExpectedChanges().get(1).getVisibility().getVisibility());
		assertEquals(WeatherParserConstants.UNIT_OF_MEASURE_STATUTE_MILES, taf.getExpectedChanges().get(1).getVisibility().getVisibilityUnitOfMeasure());
		assertTrue(taf.getExpectedChanges().get(1).getWindShear().isPotentialWindShear());
		assertEquals(2, taf.getExpectedChanges().get(1).getIcingConditions().getIcingIntensityCode().intValue());
		assertEquals(3000, taf.getExpectedChanges().get(1).getIcingConditions().getIcingLayerBase().intValue());
		assertEquals(4000, taf.getExpectedChanges().get(1).getIcingConditions().getIcingLayerDepth().intValue());
		assertEquals(2, taf.getExpectedChanges().get(1).getTurbulence().getTurbulenceIntensityCode().intValue());
		assertEquals(2000, taf.getExpectedChanges().get(1).getTurbulence().getTurbulenceLayerBase().intValue());
		assertEquals(4000, taf.getExpectedChanges().get(1).getTurbulence().getTurbulenceLayerDepth().intValue());
		
		assertEquals(999, taf.getExpectedChanges().get(1).getMinimumAltimeterSettings().getPressure().intValue());

		assertEquals(10, taf.getExpectedChanges().get(1).getMaximumTemperature().getTemperature().intValue());
		assertEquals(21, taf.getExpectedChanges().get(1).getMaximumTemperature().getTime().getDayOfMonth().intValue());
		assertEquals(4, taf.getExpectedChanges().get(1).getMaximumTemperature().getTime().getHour().intValue());

		assertEquals(-5, taf.getExpectedChanges().get(1).getMinimumTemperature().getTemperature().intValue());
		assertEquals(21, taf.getExpectedChanges().get(1).getMinimumTemperature().getTime().getDayOfMonth().intValue());
		assertEquals(6, taf.getExpectedChanges().get(1).getMinimumTemperature().getTime().getHour().intValue());
		
	}

}
