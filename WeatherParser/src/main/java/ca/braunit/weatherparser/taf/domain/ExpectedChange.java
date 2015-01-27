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
package ca.braunit.weatherparser.taf.domain;

import java.util.List;

import ca.braunit.weatherparser.common.domain.Clouds;
import ca.braunit.weatherparser.common.domain.TimeInfo;
import ca.braunit.weatherparser.common.domain.ValidityPeriod;
import ca.braunit.weatherparser.common.domain.Visibility;
import ca.braunit.weatherparser.common.domain.Weather;
import ca.braunit.weatherparser.common.domain.Wind;
import ca.braunit.weatherparser.metar.domain.Pressure;

public class ExpectedChange {

	public enum ChangeType { FROM, PROBABILITY, TEMPORARY, BECOMING };
	
	private TimeInfo fromTime;
	private ValidityPeriod validityPeriod;
	private ChangeType changeType;
	private Integer probabilityOfChange;
	
	private Wind wind;
	private List<Visibility> visibility;
	private List<Clouds> clouds;
	private List<Weather> forecastWeather;
	private WindShear windShear;

	private IcingConditions icingConditions;
	private Turbulence turbulence;
	private Pressure minimumAltimeterSettings;
	private Temperature maximumTemperature; 
	private Temperature minimumTemperature; 

	public TimeInfo getFromTime() {
		return fromTime;
	}
	public void setFromTime(TimeInfo fromTime) {
		this.fromTime = fromTime;
	}
	public ValidityPeriod getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(ValidityPeriod validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	public List<Visibility> getVisibility() {
		return visibility;
	}
	public void setVisibility(List<Visibility> visibility) {
		this.visibility = visibility;
	}
	public List<Clouds> getClouds() {
		return clouds;
	}
	public void setClouds(List<Clouds> clouds) {
		this.clouds = clouds;
	}
	public ChangeType getChangeType() {
		return changeType;
	}
	public void setChangeType(ChangeType changeType) {
		this.changeType = changeType;
	}
	public Integer getProbabilityOfChange() {
		return probabilityOfChange;
	}
	public void setProbabilityOfChange(Integer probabilityOfChange) {
		this.probabilityOfChange = probabilityOfChange;
	}
	public List<Weather> getForecastWeather() {
		return forecastWeather;
	}
	public void setForecastWeather(List<Weather> forecastWeather) {
		this.forecastWeather = forecastWeather;
	}
	public WindShear getWindShear() {
		return windShear;
	}
	public void setWindShear(WindShear windShear) {
		this.windShear = windShear;
	}
	public IcingConditions getIcingConditions() {
		return icingConditions;
	}
	public void setIcingConditions(IcingConditions icingConditions) {
		this.icingConditions = icingConditions;
	}
	public Turbulence getTurbulence() {
		return turbulence;
	}
	public void setTurbulence(Turbulence turbulence) {
		this.turbulence = turbulence;
	}
	public Pressure getMinimumAltimeterSettings() {
		return minimumAltimeterSettings;
	}
	public void setMinimumAltimeterSettings(Pressure minimumAltimeterSettings) {
		this.minimumAltimeterSettings = minimumAltimeterSettings;
	}
	public Temperature getMaximumTemperature() {
		return maximumTemperature;
	}
	public void setMaximumTemperature(Temperature maximumTemperature) {
		this.maximumTemperature = maximumTemperature;
	}
	public Temperature getMinimumTemperature() {
		return minimumTemperature;
	}
	public void setMinimumTemperature(Temperature minimumTemperature) {
		this.minimumTemperature = minimumTemperature;
	}

	
}
