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

import java.util.HashMap;
import java.util.Map;

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.util.CommonDecoder;
import ca.braunit.weatherparser.taf.domain.Turbulence;

public class TurbulenceDecoder {

	private static final String TURBULENCE_PATTERN = "5[\\d]{5}( |\\Z)(.)*";
	
	private static final Map<Integer,String> INTENSITY_MAP = new HashMap<Integer,String>();
	
	static {
		INTENSITY_MAP.put(0, "none");
		INTENSITY_MAP.put(1, "light turbulence");
		INTENSITY_MAP.put(2, "moderate turbulence in clean air, occasional");
		INTENSITY_MAP.put(3, "moderate turbulence in clean air, frequent");
		INTENSITY_MAP.put(4, "moderate turbulence in cloud, occasional");
		INTENSITY_MAP.put(5, "moderate turbulence in cloud, frequent");
		INTENSITY_MAP.put(6, "severe turbulence in clean air, occasional");
		INTENSITY_MAP.put(7, "severe turbulence in clean air, frequent");
		INTENSITY_MAP.put(8, "severe turbulence in cloud, occasional");
		INTENSITY_MAP.put(9, "severe turbulence in cloud, frequent");
	}
	
	public static Turbulence decodeObject(StringBuffer tafAsString) throws DecoderException {
		
		Turbulence turbulence = null;
		if(tafAsString.toString().matches(TURBULENCE_PATTERN)) {
			
			turbulence = new Turbulence();
			tafAsString.delete(0, 1);
			
			turbulence.setTurbulenceIntensityCode(Integer.parseInt(tafAsString.substring(0, 1)));
			turbulence.setTurbulenceIntensity(INTENSITY_MAP.get(turbulence.getTurbulenceIntensityCode()));
			
			tafAsString.delete(0, 1);

			turbulence.setTurbulenceLayerBase(Integer.parseInt(tafAsString.substring(0, 3)) * 100);
			tafAsString.delete(0, 3);

			turbulence.setTurbulenceLayerDepth(Integer.parseInt(tafAsString.substring(0, 1)) * 1000);
			CommonDecoder.deleteParsedContent(tafAsString);
			
		}
		return turbulence;
	}
	
}
