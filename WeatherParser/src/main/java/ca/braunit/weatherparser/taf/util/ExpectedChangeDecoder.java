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

import java.util.ArrayList;
import java.util.List;

import ca.braunit.weatherparser.common.util.CloudsDecoder;
import ca.braunit.weatherparser.common.util.TimeInfoDecoder;
import ca.braunit.weatherparser.common.util.ValidityPeriodDecoder;
import ca.braunit.weatherparser.common.util.VisibilityDecoder;
import ca.braunit.weatherparser.common.util.WeatherDecoder;
import ca.braunit.weatherparser.common.util.WindDecoder;
import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.util.CommonDecoder;
import ca.braunit.weatherparser.taf.domain.ExpectedChange;
import ca.braunit.weatherparser.taf.domain.ExpectedChange.ChangeType;

public class ExpectedChangeDecoder {

	private static final String EXPECTED_CHANGE_PATTERN = "(TEMPO |BECMG |FM[\\d]{6} |PROB[\\d]{2} )(.)*";
	
	private static final String FROM_PATTERN = "FM[\\d]{6} (.)*";
	private static final String BECOMING_PATTERN = "BECMG (.)*";
	private static final String TEMPORARY_PATTERN = "TEMPO (.)*";
	private static final String PROBABILITY_PATTERN = "PROB[\\d]{2} (.)*";
	
	public static List<ExpectedChange> decodeObject(StringBuffer tafAsString) throws DecoderException {
		List<ExpectedChange> expectedChanges = new ArrayList<ExpectedChange>();
		
		while(tafAsString.toString().matches(EXPECTED_CHANGE_PATTERN)) {
			ExpectedChange expectedChange = new ExpectedChange();
			
			decodeChangeType(tafAsString, expectedChange);
			decodeValidityPeriodOrFromTime(tafAsString, expectedChange);
			
			expectedChange.setWind(WindDecoder.decodeObject(tafAsString));
			expectedChange.setVisibility(VisibilityDecoder.decodeObject(tafAsString));
			expectedChange.setForecastWeather(WeatherDecoder.decodeObject(tafAsString));
			expectedChange.setClouds(CloudsDecoder.decodeObject(tafAsString));
			expectedChange.setIcingConditions(IcingConditionsDecoder.decodeObject(tafAsString));
			expectedChange.setTurbulence(TurbulenceDecoder.decodeObject(tafAsString));
			expectedChange.setWindShear(WindShearDecoder.decodeObject(tafAsString));
			expectedChange.setMinimumAltimeterSettings(MinimumAltimeterSettingDecoder.decodeObject(tafAsString));
			expectedChange.setMaximumTemperature(TemperatureDecoder.decodeObject(tafAsString));
			expectedChange.setMinimumTemperature(TemperatureDecoder.decodeObject(tafAsString));
			//Has to be added 2nd time as for some location wind shear group might follow after minimum altimerter setting group
			if (null == expectedChange.getWindShear()) {
				expectedChange.setWindShear(WindShearDecoder.decodeObject(tafAsString));
			}

			expectedChanges.add(expectedChange);
		}
		
		return expectedChanges;
	}
	
	private static void decodeChangeType(StringBuffer tafAsString, ExpectedChange expectedChange) {
		if (tafAsString.toString().matches(FROM_PATTERN)) {
			expectedChange.setChangeType(ChangeType.FROM);
			tafAsString.delete(0, 2);
		} else if (tafAsString.toString().matches(BECOMING_PATTERN)) {
			expectedChange.setChangeType(ChangeType.BECOMING);
			CommonDecoder.deleteParsedContent(tafAsString);
		} else if (tafAsString.toString().matches(TEMPORARY_PATTERN)) {
			expectedChange.setChangeType(ChangeType.TEMPORARY);
			CommonDecoder.deleteParsedContent(tafAsString);
		} else if (tafAsString.toString().matches(PROBABILITY_PATTERN)) {
			expectedChange.setChangeType(ChangeType.PROBABILITY);
			tafAsString.delete(0, 4);
			decodeProbability(tafAsString, expectedChange);
		}
	}
	
	private static void decodeProbability(StringBuffer tafAsString, ExpectedChange expectedChange) {
		expectedChange.setProbabilityOfChange(Integer.parseInt(tafAsString.substring(0, 2)));
		CommonDecoder.deleteParsedContent(tafAsString);
	}
	
	private static void decodeValidityPeriodOrFromTime(StringBuffer tafAsString, ExpectedChange expectedChange) throws DecoderException {
		
		if (expectedChange.getChangeType().equals(ChangeType.FROM)) {
			expectedChange.setFromTime(TimeInfoDecoder.decodeObject(tafAsString, true));
		} else {
			expectedChange.setValidityPeriod(ValidityPeriodDecoder.decodeObject(tafAsString));
		}
		//CommonDecoder.deleteParsedContent(tafAsString);
	}
	
}
