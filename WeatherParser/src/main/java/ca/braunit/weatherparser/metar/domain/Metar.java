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
package ca.braunit.weatherparser.metar.domain;

import java.util.List;

import ca.braunit.weatherparser.common.domain.Clouds;
import ca.braunit.weatherparser.common.domain.TimeInfo;
import ca.braunit.weatherparser.common.domain.Visibility;
import ca.braunit.weatherparser.common.domain.Weather;
import ca.braunit.weatherparser.common.domain.Wind;

public class Metar {
	
	private String airportIcaoCode;
	private boolean metarType = false;
	private boolean speciType = false;
	private boolean correctedReport = false;
	private boolean automatedObservation = false;

	private TimeInfo reportTime;
	private Wind wind;
	private Visibility visibility;
	private List<RunwayVisualRange> runwayVisualRanges;
	private List<Weather> presentWeather;
	private List<Weather> recentWeather;
	private List<Clouds> clouds;
	private TemperatureAndDewPoint temperatureAndDewPoint;
	private Pressure pressure;
	private List<WindShear> windShear;
	private Remarks remarks;

	public String getAirportIcaoCode() {
		return airportIcaoCode;
	}

	public void setAirportIcaoCode(String airportIcaoCode) {
		this.airportIcaoCode = airportIcaoCode;
	}

	public boolean isMetarType() {
		return metarType;
	}

	public void setMetarType(boolean metarType) {
		this.metarType = metarType;
	}

	public boolean isSpeciType() {
		return speciType;
	}

	public void setSpeciType(boolean speciType) {
		this.speciType = speciType;
	}

	public boolean isCorrectedReport() {
		return correctedReport;
	}

	public void setCorrectedReport(boolean correctedReport) {
		this.correctedReport = correctedReport;
	}

	public boolean isAutomatedObservation() {
		return automatedObservation;
	}

	public void setAutomatedObservation(boolean automatedObservation) {
		this.automatedObservation = automatedObservation;
	}

	public TimeInfo getReportTime() {
		return reportTime;
	}

	public void setReportTime(TimeInfo reportTime) {
		this.reportTime = reportTime;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public List<RunwayVisualRange> getRunwayVisualRanges() {
		return runwayVisualRanges;
	}

	public void setRunwayVisualRanges(List<RunwayVisualRange> runwayVisualRanges) {
		this.runwayVisualRanges = runwayVisualRanges;
	}

	public List<Weather> getPresentWeather() {
		return presentWeather;
	}

	public void setPresentWeather(List<Weather> presentWeather) {
		this.presentWeather = presentWeather;
	}

	public List<Weather> getRecentWeather() {
		return recentWeather;
	}

	public void setRecentWeather(List<Weather> recentWeather) {
		this.recentWeather = recentWeather;
	}

	public List<Clouds> getClouds() {
		return clouds;
	}

	public void setClouds(List<Clouds> clouds) {
		this.clouds = clouds;
	}

	public TemperatureAndDewPoint getTemperatureAndDewPoint() {
		return temperatureAndDewPoint;
	}

	public void setTemperatureAndDewPoint(TemperatureAndDewPoint temperatureAndDewPoint) {
		this.temperatureAndDewPoint = temperatureAndDewPoint;
	}

	public Pressure getPressure() {
		return pressure;
	}

	public void setPressure(Pressure pressure) {
		this.pressure = pressure;
	}

	public List<WindShear> getWindShear() {
		return windShear;
	}

	public void setWindShear(List<WindShear> windShear) {
		this.windShear = windShear;
	}

	public Remarks getRemarks() {
		return remarks;
	}

	public void setRemarks(Remarks remarks) {
		this.remarks = remarks;
	}

}
