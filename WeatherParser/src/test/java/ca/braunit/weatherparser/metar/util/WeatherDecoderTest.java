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

public class WeatherDecoderTest {

	@Test
	/**
	 * Check Weather Decoding (Light Rain)
	 * @throws DecoderException
	 */
	public void testPresentWeatherLightRain() throws DecoderException {
		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_1);
		
		assertEquals("Light", mdResult.getMetar().getPresentWeather().get(0).getIntensity());
		assertEquals("Rain", mdResult.getMetar().getPresentWeather().get(0).getPrecipitation());
		
	}

	@Test
	/**
	 * Check Weather Decoding (Light Rain)
	 * @throws DecoderException
	 */
	public void testRecentWeatherShowerRain() throws DecoderException {
		MetarDecoderResult mdResult = MetarDecoder.decodeMetar(ExampleMessagesMetar.METAR_EXAMPLE_1);
		
		assertEquals("Showers", mdResult.getMetar().getRecentWeather().get(0).getDescriptor());
		assertEquals("Rain", mdResult.getMetar().getRecentWeather().get(0).getPrecipitation());
		
	}

}
