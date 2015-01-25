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

public class Clouds {

	private String cloudAmountCode;
	private String cloudAmount;
	private Integer cloudHeight;
	private Integer verticalVisability;
	private boolean nsc = false;
	private boolean ncd = false;
	private boolean tcu = false;
	private boolean cb = false;
	private boolean acc = false;
	private boolean skyClear = false;

	public String getCloudAmountCode() {
		return cloudAmountCode;
	}
	public void setCloudAmountCode(String cloudAmountCode) {
		this.cloudAmountCode = cloudAmountCode;
	}
	public String getCloudAmount() {
		return cloudAmount;
	}
	public void setCloudAmount(String cloudAmount) {
		this.cloudAmount = cloudAmount;
	}
	public Integer getCloudHeight() {
		return cloudHeight;
	}
	public void setCloudHeight(Integer cloudHeight) {
		this.cloudHeight = cloudHeight;
	}
	public Integer getVerticalVisability() {
		return verticalVisability;
	}
	public void setVerticalVisability(Integer verticalVisability) {
		this.verticalVisability = verticalVisability;
	}
	public boolean isNsc() {
		return nsc;
	}
	public void setNsc(boolean nsc) {
		this.nsc = nsc;
	}
	public boolean isNcd() {
		return ncd;
	}
	public void setNcd(boolean ncd) {
		this.ncd = ncd;
	}
	public boolean isTcu() {
		return tcu;
	}
	public void setTcu(boolean tcu) {
		this.tcu = tcu;
	}
	public boolean isCb() {
		return cb;
	}
	public void setCb(boolean cb) {
		this.cb = cb;
	}
	public boolean isAcc() {
		return acc;
	}
	public void setAcc(boolean acc) {
		this.acc = acc;
	}
	public boolean isSkyClear() {
		return skyClear;
	}
	public void setSkyClear(boolean skyClear) {
		this.skyClear = skyClear;
	}

	
}
