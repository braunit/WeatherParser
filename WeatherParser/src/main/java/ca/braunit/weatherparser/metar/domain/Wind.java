/*
 * Copyright (c)2014 Braun IT Solutions Ltd, Vancouver, Canada
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

public class Wind {

	private Integer windDirection;
	private Integer windSpeed;
	private Integer windSpeedGusts;
	private Integer variableWindDirectionFrom;
	private Integer variableWindDirectionTo;
	private String speedUnitOfMeasure;

	public Integer getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}
	public Integer getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(Integer windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Integer getWindSpeedGusts() {
		return windSpeedGusts;
	}
	public void setWindSpeedGusts(Integer windSpeedGusts) {
		this.windSpeedGusts = windSpeedGusts;
	}
	public Integer getVariableWindDirectionFrom() {
		return variableWindDirectionFrom;
	}
	public void setVariableWindDirectionFrom(Integer variableWindDirectionFrom) {
		this.variableWindDirectionFrom = variableWindDirectionFrom;
	}
	public Integer getVariableWindDirectionTo() {
		return variableWindDirectionTo;
	}
	public void setVariableWindDirectionTo(Integer variableWindDirectionTo) {
		this.variableWindDirectionTo = variableWindDirectionTo;
	}
	public String getSpeedUnitOfMeasure() {
		return speedUnitOfMeasure;
	}
	public void setSpeedUnitOfMeasure(String speedUnitOfMeasure) {
		this.speedUnitOfMeasure = speedUnitOfMeasure;
	}

	
}
