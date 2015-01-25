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

public class ValidityPeriod {
	
	private Integer fromDayOfMonth;
	private Integer fromHour;

	private Integer toDayOfMonth;
	private Integer toHour;

	public Integer getFromDayOfMonth() {
		return fromDayOfMonth;
	}
	public void setFromDayOfMonth(Integer fromDayOfMonth) {
		this.fromDayOfMonth = fromDayOfMonth;
	}
	public Integer getFromHour() {
		return fromHour;
	}
	public void setFromHour(Integer fromHour) {
		this.fromHour = fromHour;
	}
	public Integer getToDayOfMonth() {
		return toDayOfMonth;
	}
	public void setToDayOfMonth(Integer toDayOfMonth) {
		this.toDayOfMonth = toDayOfMonth;
	}
	public Integer getToHour() {
		return toHour;
	}
	public void setToHour(Integer toHour) {
		this.toHour = toHour;
	}


}
