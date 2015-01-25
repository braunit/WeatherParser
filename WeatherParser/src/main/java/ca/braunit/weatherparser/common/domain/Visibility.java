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

import java.math.BigDecimal;

public class Visibility {

	private boolean cavok = false;
	private BigDecimal visibility;
	private String visibilityUnitOfMeasure = "M";
	private String direction = null;
	private boolean ndv = false;
	private boolean greaterThan;

	public boolean isCavok() {
		return cavok;
	}
	public void setCavok(boolean cavok) {
		this.cavok = cavok;
	}
	public BigDecimal getVisibility() {
		return visibility;
	}
	public void setVisibility(BigDecimal visibility) {
		this.visibility = visibility;
	}
	public String getVisibilityUnitOfMeasure() {
		return visibilityUnitOfMeasure;
	}
	public void setVisibilityUnitOfMeasure(String visibilityUnitOfMeasure) {
		this.visibilityUnitOfMeasure = visibilityUnitOfMeasure;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	/**
	 * Returns the NDV ("no direction variable") status
	 * @return ndv the NDV status
	 */
	public boolean isNdv() {
		return ndv;
	}
	
	/**
	 * Sets the NDV ("no direction variable") status
	 * @param ndv the NDV status
	 */
	public void setNdv(boolean ndv) {
		this.ndv = ndv;
	}
	public boolean isGreaterThan() {
		return greaterThan;
	}
	public void setGreaterThan(boolean greaterThan) {
		this.greaterThan = greaterThan;
	}

	
}
