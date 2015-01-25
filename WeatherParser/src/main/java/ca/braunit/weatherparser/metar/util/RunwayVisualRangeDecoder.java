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

import java.util.ArrayList;
import java.util.List;

import ca.braunit.weatherparser.metar.domain.RunwayVisualRange;
import ca.braunit.weatherparser.util.WeatherParserConstants;

public class RunwayVisualRangeDecoder {
	
	private static final String RVR_PATTERN = "R[\\d]{2}(L|R|C)?/(M|P)?[\\d]{4}(FT)?(U|D|N)?(V(M|P)?[\\d]{4}(FT)?(U|D|N)?)?(\\s)(.)*";

	public static List<RunwayVisualRange> decodeObject(StringBuffer metarAsString) {
		List<RunwayVisualRange> rvrList = new ArrayList<RunwayVisualRange>();
		
		while (metarAsString.toString().matches(RVR_PATTERN)) {

			RunwayVisualRange rvr = new RunwayVisualRange();
			
			// Remove "R"
			metarAsString.delete(0, 1);
			
			//Extract Runway
			rvr.setRunway(metarAsString.substring(0,metarAsString.indexOf("/")));
			metarAsString.delete(0, rvr.getRunway().length()+1);
			
			//Extract P|M
			if (metarAsString.substring(0,1).equals(WeatherParserConstants.LESS_THAN_CODE)) {
				rvr.setLessThan(true);
				metarAsString.delete(0, 1);
			} else if (metarAsString.substring(0, 1).equals(WeatherParserConstants.MORE_THAN_CODE)) {
				rvr.setMoreThan(true);
				metarAsString.delete(0, 1);
			}
			
			//Extract Visibility
			rvr.setVisibileRange(Integer.parseInt(metarAsString.substring(0,4)));
			metarAsString.delete(0, 4);
			
			checkUnitOfMeasure(rvr, metarAsString);
			
			//Extract U|D|N
			if (metarAsString.substring(0,1).equals("U")) {
				rvr.setUpwardTendency(true);
				metarAsString.delete(0, 1);
			} else if (metarAsString.substring(0, 1).equals("D")) {
				rvr.setDownwardTendency(true);
				metarAsString.delete(0, 1);
			} else if (metarAsString.substring(0, 1).equals("N")) {
				rvr.setNoTendency(true);
				metarAsString.delete(0, 1);
			}
				
			
			//Check for Variety
			if (metarAsString.substring(0,1).equals("V")) {
				metarAsString.delete(0, 1);

				//Extract P|M
				if (metarAsString.substring(0,1).equals("M")) {
					rvr.setLessThanVariety(true);
					metarAsString.delete(0, 1);
				} else if (metarAsString.substring(0, 1).equals("P")) {
					rvr.setMoreThanVariety(true);
					metarAsString.delete(0, 1);
				}
				
				//Extract Visibility
				rvr.setVisibileRangeVariety(Integer.parseInt(metarAsString.substring(0,4)));
				metarAsString.delete(0, 4);
				
				checkUnitOfMeasure(rvr, metarAsString);
				
				//Extract U|D|N
				if (metarAsString.substring(0,1).equals("U")) {
					rvr.setUpwardTendencyVariety(true);
					metarAsString.delete(0, 1);
				} else if (metarAsString.substring(0, 1).equals("D")) {
					rvr.setDownwardTendencyVariety(true);
					metarAsString.delete(0, 1);
				} else if (metarAsString.substring(0, 1).equals("N")) {
					rvr.setNoTendencyVariety(true);
					metarAsString.delete(0, 1);
				}

				
			}
			metarAsString.delete(0, metarAsString.indexOf(" ") + 1);
			
			rvrList.add(rvr);
		}
		return rvrList;
	}
	
	private static void checkUnitOfMeasure(RunwayVisualRange rvr, StringBuffer metarAsString) {

		//Extract Feet
		if (metarAsString.substring(0,2).equals(WeatherParserConstants.UNIT_OF_MEASURE_FEET)) {
			rvr.setUnitOfMeasure(WeatherParserConstants.UNIT_OF_MEASURE_FEET);
			metarAsString.delete(0, 1);
		}

	}
	
}
