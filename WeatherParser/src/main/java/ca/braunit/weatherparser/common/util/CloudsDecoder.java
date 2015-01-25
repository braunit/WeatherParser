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
package ca.braunit.weatherparser.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.braunit.weatherparser.common.domain.Clouds;
import ca.braunit.weatherparser.metar.util.CommonDecoder;

public class CloudsDecoder {

	private static final String CLOUDS_PATTERN = "(([a-zA-Z]){3}(\\d){3}(TCU|CB|ACC)?)|(([vV]){2}(\\d){3})|NCS|NCD|SKC";

	private static final String CLOUD_AMOUNT_AND_HEIGHT_PATTERN = "(([a-zA-Z]){3}(\\d){3}(TCU|CB|ACC)?)";
	private static final String VERTICAL_VISIBILITY_PATTERN = "(([vV]){2}(\\d){3})";
	
	private static final Map<String,String> CLOUD_AMOUNT_MAP = new HashMap<String,String>();

	static {
		CLOUD_AMOUNT_MAP.put("SKC", "Clear");
		CLOUD_AMOUNT_MAP.put("CLR", "Clear");
		CLOUD_AMOUNT_MAP.put("FEW", "Few");
		CLOUD_AMOUNT_MAP.put("SCT", "Scattered");
		CLOUD_AMOUNT_MAP.put("BKN", "Broken");
		CLOUD_AMOUNT_MAP.put("OVC", "Overcast");
	}

	public static List<Clouds> decodeObject(StringBuffer weatherSb) {

		List<Clouds> cloudsList = new ArrayList<Clouds>();
		
		while (weatherSb.substring(0, weatherSb.indexOf(" ")).toString().matches(CLOUDS_PATTERN)) {

			Clouds clouds = new Clouds();
			
			if (weatherSb.substring(0, weatherSb.indexOf(" ")).toString().matches(CLOUD_AMOUNT_AND_HEIGHT_PATTERN)) {
				clouds.setCloudAmountCode(weatherSb.substring(0,3));
				clouds.setCloudAmount(CLOUD_AMOUNT_MAP.get(clouds.getCloudAmountCode()));
				clouds.setCloudHeight(Integer.parseInt(weatherSb.substring(3, 6))*100);
				if (!weatherSb.substring(6, 7).equals(" ")) {
					if (weatherSb.substring(6).startsWith("TCU")) {
						clouds.setTcu(true);
					} else if (weatherSb.substring(6).startsWith("CB")) {
						clouds.setCb(true);
					} else if (weatherSb.substring(6).startsWith("ACC")) {
						clouds.setAcc(true);
					}
				}
			} else if (weatherSb.substring(0, weatherSb.indexOf(" ")).toString().matches(VERTICAL_VISIBILITY_PATTERN)) {
				clouds.setVerticalVisability(Integer.parseInt(weatherSb.substring(2, 5))*100);
			} else if (weatherSb.toString().startsWith("NSC")) {
				clouds.setNsc(true);
			} else if (weatherSb.toString().startsWith("NCD")) {
				clouds.setNcd(true);
			} else if (weatherSb.toString().startsWith("SKC") || weatherSb.toString().startsWith("CLR")) {
				clouds.setSkyClear(true);
			}
			CommonDecoder.deleteParsedContent(weatherSb);
			
			cloudsList.add(clouds);
			
		}
		
		return cloudsList;
	}

}
