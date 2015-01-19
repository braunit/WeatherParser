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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.braunit.weatherparser.metar.domain.Weather;

public class WeatherDecoder {

	private static final String PRESENT_WEATHER_PATTERN = "(\\+|\\-|VC)?(([a-zA-Z]){2})+(\\s)(.)*";
	private static final String RECENT_WEATHER_PATTERN = "RE(\\+|\\-|VC)?(([a-zA-Z]){2})+(.)*";
	
	private static final String INTENSITY_PATTERN = "^(\\+|\\-|VC).*";
	
	private static final Map<String,String> INTENSITY_MAP = new HashMap<String,String>();
	private static final Map<String,String> DESCRIPTOR_MAP = new HashMap<String,String>();
	private static final Map<String,String> PRECIPITATION_MAP = new HashMap<String,String>();
	private static final Map<String,String> OBSCURATION_MAP = new HashMap<String,String>();
	private static final Map<String,String> OTHER_MAP = new HashMap<String,String>();
	
	static {
		INTENSITY_MAP.put("-", "Light");
		INTENSITY_MAP.put("+", "Heavy");
		INTENSITY_MAP.put("VC", "In the vicinity");
		INTENSITY_MAP.put("DEFAULT", "Moderate");
	}
	
	static {
		DESCRIPTOR_MAP.put("MI", "Shallow");
		DESCRIPTOR_MAP.put("PR", "Partial");
		DESCRIPTOR_MAP.put("BC", "Patches");
		DESCRIPTOR_MAP.put("DR", "Drifting");
		DESCRIPTOR_MAP.put("BL", "Blowing");
		DESCRIPTOR_MAP.put("SH", "Showers");
		DESCRIPTOR_MAP.put("TS", "Thunderstorm");
		DESCRIPTOR_MAP.put("FZ", "Freezing");
	}

	static {
		PRECIPITATION_MAP.put("DZ", "Drizzle");
		PRECIPITATION_MAP.put("RA", "Rain");
		PRECIPITATION_MAP.put("SN", "Snow");
		PRECIPITATION_MAP.put("SG", "Snow Grains");
		PRECIPITATION_MAP.put("IC", "Ice Crystals");
		PRECIPITATION_MAP.put("PL", "Ice Pellets");
		PRECIPITATION_MAP.put("GR", "Hail");
		PRECIPITATION_MAP.put("GS", "Small Hail / Snow Pellets");
		PRECIPITATION_MAP.put("UP", "Unknown");
	}

	static {
		OBSCURATION_MAP.put("BR", " Mist");
		OBSCURATION_MAP.put("FG", "Fog");
		OBSCURATION_MAP.put("FU", "Smoke");
		OBSCURATION_MAP.put("VA", "Volcanic ash");
		OBSCURATION_MAP.put("DU", "Widespread dust");
		OBSCURATION_MAP.put("SA", "Sand");
		OBSCURATION_MAP.put("HZ", "Haze");
		OBSCURATION_MAP.put("PY", "Spray");
	}

	static {
		OTHER_MAP.put("PO", "Well developed Dust/Sand Whirls");
		OTHER_MAP.put("SQ", "Squalls");
		OTHER_MAP.put("FC", "Funnel Cloud");
		OTHER_MAP.put("+FC", "Tornado / Water Spout");
		OTHER_MAP.put("SS", "Sandstorm");
		OTHER_MAP.put("DS", "Dust storm");
	}

	
	public static List<Weather> decodeObject(StringBuffer metarAsString, boolean presentWeather) {
		if (presentWeather) {
			return decodeWeather(metarAsString, PRESENT_WEATHER_PATTERN);
		}
		return decodeWeather(metarAsString, RECENT_WEATHER_PATTERN);
	}
	
	private static List<Weather> decodeWeather(StringBuffer metarAsString, String weatherPattern) {
		List<Weather> weatherList = new ArrayList<Weather>();
		
		while (metarAsString.toString().matches(weatherPattern)) {

			Weather weather = new Weather();

			if (metarAsString.toString().startsWith("RE")) {
				metarAsString.delete(0, 2);
			}
			
			if (metarAsString.toString().matches(INTENSITY_PATTERN)) {
				if (metarAsString.toString().startsWith("+") || metarAsString.toString().startsWith("-")) {
					weather.setIntensityCode(metarAsString.substring(0, 1));
					metarAsString.delete(0, 1);
				} else {
					weather.setIntensityCode(metarAsString.substring(0,2));
					metarAsString.delete(0, 2);
				}
				weather.setIntensity(INTENSITY_MAP.get(weather.getIntensityCode()));
			} else {
				weather.setIntensityCode("");
				weather.setIntensity(INTENSITY_MAP.get("DEFAULT"));
			}
			
			StringBuffer weatherInfo = new StringBuffer(metarAsString.substring(0,metarAsString.indexOf(" ")));
			
			while (weatherInfo.length() >= 2) {
				String checkString = weatherInfo.substring(0,2);
				if (null != DESCRIPTOR_MAP.get(checkString)) {
					weather.setDescriptor(DESCRIPTOR_MAP.get(checkString));
					weather.setDescriptorCode(checkString);
				} else if (null != PRECIPITATION_MAP.get(checkString)) {
					weather.setPrecipitation(PRECIPITATION_MAP.get(checkString));
					weather.setPrecipitationCode(checkString);
				} else if (null != OBSCURATION_MAP.get(checkString)) {
					weather.setObscuration(OBSCURATION_MAP.get(checkString));
					weather.setObscurationCode(checkString);
				} else if (null != OTHER_MAP.get(checkString)) {
					if (null != OTHER_MAP.get(weather.getIntensity() + checkString)) {
						weather.setOther(OTHER_MAP.get(weather.getIntensity() + checkString));
					} else {
						weather.setOther(OTHER_MAP.get(checkString));
					}
					weather.setOtherCode(checkString);
				}
				weatherInfo.delete(0, 2);
			}
			
			metarAsString.delete(0, metarAsString.indexOf(" ") + 1);
			
			weatherList.add(weather);
			
		}
		
		return weatherList;

	}
}
