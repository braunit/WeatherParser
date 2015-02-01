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
package ca.braunit.weatherparser.common.domain;

/**
 * This class represents the detailed weather information described by
 * the following criteria: <br>
 * - intensity, <br>
 * - proximity, <br>
 * - descriptor, <br>
 * - precipitation, <br>
 * - obscuration and <br>
 * - other
 * @author Alexander Braun
 *
 */
public class Weather {

	private String intensityCode;
	private String descriptorCode;
	private String precipitationCode;
	private String obscurationCode;
	private String otherCode;

	private String intensity;
	private String descriptor;
	private String precipitation;
	private String obscuration;
	private String other;
	//Combination if precipitation, obscuration and other
	private String weatherPhenomena;
	
	private boolean onStation = false;
	private boolean inTheVicinity = false;
	private boolean inTheDistant = false;
	private boolean noSignificantWeather = false;
	
	public String getIntensityCode() {
		return intensityCode;
	}
	public void setIntensityCode(String intensityCode) {
		this.intensityCode = intensityCode;
	}
	public String getDescriptorCode() {
		return descriptorCode;
	}
	public void setDescriptorCode(String descriptorCode) {
		this.descriptorCode = descriptorCode;
	}
	public String getPrecipitationCode() {
		return precipitationCode;
	}
	public void setPrecipitationCode(String precipitationCode) {
		this.precipitationCode = precipitationCode;
	}
	public String getObscurationCode() {
		return obscurationCode;
	}
	public void setObscurationCode(String obscurationCode) {
		this.obscurationCode = obscurationCode;
	}
	public String getOtherCode() {
		return otherCode;
	}
	public void setOtherCode(String otherCode) {
		this.otherCode = otherCode;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public String getDescriptor() {
		return descriptor;
	}
	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}
	public String getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
	}
	public String getObscuration() {
		return obscuration;
	}
	public void setObscuration(String obscuration) {
		this.obscuration = obscuration;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getWeatherPhenomena() {
		return weatherPhenomena;
	}
	public void setWeatherPhenomena(String weatherPhenomena) {
		this.weatherPhenomena = weatherPhenomena;
	}
	public boolean isOnStation() {
		return onStation;
	}
	public void setOnStation(boolean onStation) {
		this.onStation = onStation;
	}
	public boolean isInTheVicinity() {
		return inTheVicinity;
	}
	public void setInTheVicinity(boolean inTheVicinity) {
		this.inTheVicinity = inTheVicinity;
	}
	public boolean isInTheDistant() {
		return inTheDistant;
	}
	public void setInTheDistant(boolean inTheDistant) {
		this.inTheDistant = inTheDistant;
	}
	public boolean isNoSignificantWeather() {
		return noSignificantWeather;
	}
	public void setNoSignificantWeather(boolean noSignificantWeather) {
		this.noSignificantWeather = noSignificantWeather;
	}

}
