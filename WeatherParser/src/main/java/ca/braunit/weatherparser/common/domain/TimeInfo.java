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
 * This class represents the basic time information that is included 
 * within a weather report. The time information usually only includes
 * the day of the month, the hour and the minute. Important information
 * such as month and year is missing. This information has to be retrieved
 * from other sources.
 * @author Alexander Braun
 */
public class TimeInfo {

	private Integer dayOfMonth;
	private Integer hour;
	private Integer minute;

	/**
	 * returns the day of the month (1 = January, 12 = December)
	 * @return  the day of the month
	 */
	public Integer getDayOfMonth() {
		return dayOfMonth;
	}
	
	/**
	 * sets  the day of the month (1 = January, 12 = December)
	 * @param dayOfMonth  the day of the month
	 */
	public void setDayOfMonth(Integer dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	
	/**
	 * returns the hour - depending on the type of weather report the valid
	 * range is 0 to 24
	 * @return the hour
	 */
	public Integer getHour() {
		return hour;
	}
	
	/**
	 * sets the hour - depending on the type of weather report the valid
	 * range is 0 to 24
	 * @param hour the hour
	 */
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	
	/**
	 * returns the minute
	 * @return the minute
	 */
	public Integer getMinute() {
		return minute;
	}
	
	/**
	 * sets the minute
	 * @param minute the minute
	 */
	public void setMinute(Integer minute) {
		this.minute = minute;
	}

}
