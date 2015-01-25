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
import ca.braunit.weatherparser.taf.domain.IcingConditions;

public class IcingConditionsDecoder {

	private static final String ICING_CONDITIONS_PATTERN = "6[\\d]{5}( |\\Z)(.)*";
	
	private static final Map<Integer,String> INTENSITY_MAP = new HashMap<Integer,String>();
	
	static {
		INTENSITY_MAP.put(0, "no icing / trace of icing");
		INTENSITY_MAP.put(1, "light mixed icing");
		INTENSITY_MAP.put(2, "light rime icing in cloud");
		INTENSITY_MAP.put(3, "light clear icing in precipitation");
		INTENSITY_MAP.put(4, "moderate mixed icing");
		INTENSITY_MAP.put(5, "moderate rime icing in cloud");
		INTENSITY_MAP.put(6, "moderate clear icing in precipitation");
		INTENSITY_MAP.put(7, "severe mixed icing");
		INTENSITY_MAP.put(8, "severe rime icing in cloud");
		INTENSITY_MAP.put(9, "severe clear icing in precipitation");
	}
	
	public static IcingConditions decodeObject(StringBuffer tafAsString) throws DecoderException {
		
		IcingConditions icingConditions = null;
		if(tafAsString.toString().matches(ICING_CONDITIONS_PATTERN)) {
			
			icingConditions = new IcingConditions();
			tafAsString.delete(0, 1);
			
			icingConditions.setIcingIntensityCode(Integer.parseInt(tafAsString.substring(0, 1)));
			icingConditions.setIcingIntensity(INTENSITY_MAP.get(icingConditions.getIcingIntensityCode()));
			
			tafAsString.delete(0, 1);

			icingConditions.setIcingLayerBase(Integer.parseInt(tafAsString.substring(0, 3)) * 100);
			tafAsString.delete(0, 3);

			icingConditions.setIcingLayerDepth(Integer.parseInt(tafAsString.substring(0, 1)) * 1000);
			CommonDecoder.deleteParsedContent(tafAsString);
			
		}
		return icingConditions;
	}
	
}
