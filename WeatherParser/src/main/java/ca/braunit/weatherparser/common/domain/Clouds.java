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
 * This class represents an observed or forecasted cloud layer. The cloud
 * information includes altitude of the cloud base above ground level and 
 * the sky coverage (e.g. few or scattered clouds).
 * @author Alexander Braun
 */
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

	/**
	 * returns the code for the amount of clouds (sky coverage), e.g. FEW or SCT 
	 * @return the code for the amount of clouds
	 */
	public String getCloudAmountCode() {
		return cloudAmountCode;
	}
	
	/**
	 * sets the code for the amount of clouds (sky coverage), e.g. FEW or SCT 
	 * @param cloudAmountCode the code for the amount of clouds
	 */
	public void setCloudAmountCode(String cloudAmountCode) {
		this.cloudAmountCode = cloudAmountCode;
	}
	
	/**
	 * returns the decoded value for the amount of clouds (sky coverage), 
	 * e.g. FEW or SCT 
	 * @return the decoded value for the amount of clouds
	 */
	public String getCloudAmount() {
		return cloudAmount;
	}
	
	/**
	 * sets the decoded value for the amount of clouds (sky coverage), 
	 * e.g. FEW or SCT 
	 * @param cloudAmount the decoded value for the amount of clouds
	 */
	public void setCloudAmount(String cloudAmount) {
		this.cloudAmount = cloudAmount;
	}
	
	/**
	 * returns the altitude (feet) of the cloud base above ground level
	 * @return the altitude (feet) of the cloud base above ground level
	 */
	public Integer getCloudHeight() {
		return cloudHeight;
	}
	
	/**
	 * sets the altitude (feet) of the cloud base above ground level
	 * @param cloudHeight the altitude (feet) of the cloud base above ground level
	 */
	public void setCloudHeight(Integer cloudHeight) {
		this.cloudHeight = cloudHeight;
	}
	
	/**
	 * returns the vertical visibility (feet)
	 * @return the vertical visibility (feet)
	 */
	public Integer getVerticalVisability() {
		return verticalVisability;
	}
	
	/**
	 * sets the vertical visibility (feet)
	 * @param verticalVisability the vertical visibility (feet)
	 */
	public void setVerticalVisability(Integer verticalVisability) {
		this.verticalVisability = verticalVisability;
	}
	
	/**
	 * returns the No (nil) significant cloud flag
	 * @return the No (nil) significant cloud flag
	 */
	public boolean isNsc() {
		return nsc;
	}
	
	/**
	 * sets the No (nil) significant cloud flag
	 * @param nsc the No (nil) significant cloud flag
	 */
	public void setNsc(boolean nsc) {
		this.nsc = nsc;
	}
	
	/**
	 * returns the no cloud detected flag
	 * @return the no cloud detected flag
	 */
	public boolean isNcd() {
		return ncd;
	}
	
	/**
	 * sets the no cloud detected flag
	 * @param ncd the no cloud detected flag
	 */
	public void setNcd(boolean ncd) {
		this.ncd = ncd;
	}
	
	/**
	 * returns the towering cumulus flag
	 * @return the towering cumulus flag
	 */
	public boolean isTcu() {
		return tcu;
	}
	
	/**
	 * sets the towering cumulus flag
	 * @param tcu the towering cumulus flag
	 */
	public void setTcu(boolean tcu) {
		this.tcu = tcu;
	}
	
	/**
	 * returns the cumulonimbus flag
	 * @return the cumulonimbus flag
	 */
	public boolean isCb() {
		return cb;
	}
	
	/**
	 * sets the cumulonimbus flag
	 * @param cb the cumulonimbus flag
	 */
	public void setCb(boolean cb) {
		this.cb = cb;
	}
	
	/**
	 * returns the altocumulus castellanus flag
	 * @return the altocumulus castellanus flag
	 */
	public boolean isAcc() {
		return acc;
	}
	
	/**
	 * sets the altocumulus castellanus flag
	 * @param acc the altocumulus castellanus flag
	 */
	public void setAcc(boolean acc) {
		this.acc = acc;
	}
	
	/**
	 * returns the isSkyClear flag that is being set when no clouds are visible
	 * @return the isSkyClear flag
	 */
	public boolean isSkyClear() {
		return skyClear;
	}
	
	/**
	 * sets the isSkyClear flag that is being set when no clouds are visible
	 * @param skyClear the isSkyClear flag
	 */
	public void setSkyClear(boolean skyClear) {
		this.skyClear = skyClear;
	}

}
