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

public class RunwayVisualRange {

	private String runway;

	private boolean lessThan = false;
	private boolean moreThan = false;
	private Integer visibileRange;
	private String unitOfMeasure = "M";
	private boolean upwardTendency;
	private boolean downwardTendency;
	private boolean noTendency;
	
	private boolean lessThanVariety = false;
	private boolean moreThanVariety = false;
	private Integer visibileRangeVariety;
	private boolean upwardTendencyVariety;
	private boolean downwardTendencyVariety;
	private boolean noTendencyVariety;

	public String getRunway() {
		return runway;
	}
	public void setRunway(String runway) {
		this.runway = runway;
	}
	public boolean isLessThan() {
		return lessThan;
	}
	public void setLessThan(boolean lessThan) {
		this.lessThan = lessThan;
	}
	public boolean isMoreThan() {
		return moreThan;
	}
	public void setMoreThan(boolean moreThan) {
		this.moreThan = moreThan;
	}
	public Integer getVisibileRange() {
		return visibileRange;
	}
	public void setVisibileRange(Integer visibileRange) {
		this.visibileRange = visibileRange;
	}
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public boolean isUpwardTendency() {
		return upwardTendency;
	}
	public void setUpwardTendency(boolean upwardTendency) {
		this.upwardTendency = upwardTendency;
	}
	public boolean isDownwardTendency() {
		return downwardTendency;
	}
	public void setDownwardTendency(boolean downwardTendency) {
		this.downwardTendency = downwardTendency;
	}
	public boolean isNoTendency() {
		return noTendency;
	}
	public void setNoTendency(boolean noTendency) {
		this.noTendency = noTendency;
	}
	public boolean isLessThanVariety() {
		return lessThanVariety;
	}
	public void setLessThanVariety(boolean lessThanVariety) {
		this.lessThanVariety = lessThanVariety;
	}
	public boolean isMoreThanVariety() {
		return moreThanVariety;
	}
	public void setMoreThanVariety(boolean moreThanVariety) {
		this.moreThanVariety = moreThanVariety;
	}
	public Integer getVisibileRangeVariety() {
		return visibileRangeVariety;
	}
	public void setVisibileRangeVariety(Integer visibileRangeVariety) {
		this.visibileRangeVariety = visibileRangeVariety;
	}
	public boolean isUpwardTendencyVariety() {
		return upwardTendencyVariety;
	}
	public void setUpwardTendencyVariety(boolean upwardTendencyVariety) {
		this.upwardTendencyVariety = upwardTendencyVariety;
	}
	public boolean isDownwardTendencyVariety() {
		return downwardTendencyVariety;
	}
	public void setDownwardTendencyVariety(boolean downwardTendencyVariety) {
		this.downwardTendencyVariety = downwardTendencyVariety;
	}
	public boolean isNoTendencyVariety() {
		return noTendencyVariety;
	}
	public void setNoTendencyVariety(boolean noTendencyVariety) {
		this.noTendencyVariety = noTendencyVariety;
	}
	

	
}
