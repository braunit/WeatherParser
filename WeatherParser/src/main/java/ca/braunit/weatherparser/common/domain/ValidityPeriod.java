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
 * This class represents the period of time the weather data/forecast
 * is valid. Usually the time range only includes the day of the month
 * and the hour. Important information such as month and year is 
 * missing. This information has to be retrieved from other sources.
 * @author Alexander Braun
 */
public class ValidityPeriod {
	
	private Integer fromDayOfMonth;
	private Integer fromHour;
	private Integer toDayOfMonth;
	private Integer toHour;

	/**
	 * returns the day of the month (1 = January, 12 = December)
	 * - the start of the period
	 * @return the day of the month (start of the period)
	 */
	public Integer getFromDayOfMonth() {
		return fromDayOfMonth;
	}
	
	/**
	 * sets the day of the month (1 = January, 12 = December)
	 * - the start of the period
	 * @param fromDayOfMonth the day of the month (start of the period)
	 */
	public void setFromDayOfMonth(Integer fromDayOfMonth) {
		this.fromDayOfMonth = fromDayOfMonth;
	}
	
	/**
	 * returns the hour of the start of the period - depending on the type of 
	 * weather report the valid range is 0 to 24
	 * @return the hour (start of the period)
	 */
	public Integer getFromHour() {
		return fromHour;
	}
	
	/**
	 * sets the hour of the start of the period - depending on the type of 
	 * weather report the valid range is 0 to 24
	 * @param fromHour the hour (start of the period)
	 */
	public void setFromHour(Integer fromHour) {
		this.fromHour = fromHour;
	}
	
	/**
	 * returns the day of the month (1 = January, 12 = December)
	 * - the end of the period
	 * @return the day of the month (end of the period)
	 */
	public Integer getToDayOfMonth() {
		return toDayOfMonth;
	}
	
	/**
	 * sets the day of the month (1 = January, 12 = December)
	 * - the end of the period
	 * @param toDayOfMonth the day of the month (end of the period)
	 */
	public void setToDayOfMonth(Integer toDayOfMonth) {
		this.toDayOfMonth = toDayOfMonth;
	}
	
	/**
	 * returns the hour of the end of the period - depending on the type of 
	 * weather report the valid range is 0 to 24
	 * @return the hour (end of the period)
	 */
	public Integer getToHour() {
		return toHour;
	}
	
	/**
	 * sets the hour of the end of the period - depending on the type of 
	 * weather report the valid range is 0 to 24
	 * @param toHour the hour (end of the period)
	 */
	public void setToHour(Integer toHour) {
		this.toHour = toHour;
	}

}
