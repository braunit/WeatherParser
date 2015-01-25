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

import ca.braunit.weatherparser.util.WeatherParserConstants;

/**
 * This class represents the prevailing visibility - the greatest
 * horizontal visibility observed throughout at least half of the 
 * horizon circle.
 * @author Alexander Braun
 *
 */
public class Visibility {

	private boolean cavok = false;
	private BigDecimal visibility;
	private String visibilityUnitOfMeasure = WeatherParserConstants.UNIT_OF_MEASURE_METER;
	private String direction = null;
	private boolean ndv = false;
	private boolean greaterThan;

	/**
	 * returns the CAVOK flag (ceiling and visibility OK). This flag
	 * will usually be set to true if: <br>
	 * - there is no significant weather, <br>
	 * - the visibility is greater than 10 kilometers and <br>
	 * - the ceilings are greater than 5000 feet.
	 * @return the CAVOK flag
	 */
	public boolean isCavok() {
		return cavok;
	}
	
	/**
	 * sets the CAVOK flag (ceiling and visibility OK). This flag
	 * will usually be set to true if: <br>
	 * - there is no significant weather, <br>
	 * - the visibility is greater than 10 kilometers and <br>
	 * - the ceilings are greater than 5000 feet.
	 * @param cavok the CAVOK flag
	 */
	public void setCavok(boolean cavok) {
		this.cavok = cavok;
	}
	
	/**
	 * returns the prevailing visibility, the unit of measure of this
	 * value can be retrieved using the 
	 * {@link #getVisibilityUnitOfMeasure() getVisibilityUnitOfMeasure}
	 * method.
	 * @return the prevailing visibility
	 */
	public BigDecimal getVisibility() {
		return visibility;
	}
	
	/**
	 * sets the prevailing visibility, the unit of measure of this
	 * value can be set using the 
	 * {@link #setVisibilityUnitOfMeasure(String) setVisibilityUnitOfMeasure}
	 * method.
	 * @param visibility
	 */
	public void setVisibility(BigDecimal visibility) {
		this.visibility = visibility;
	}

	/**
	 * returns the unit of measure for the visibility value.
	 * @return the unit of measure for the visibility value
	 */
	public String getVisibilityUnitOfMeasure() {
		return visibilityUnitOfMeasure;
	}
	
	/**
	 * sets the unit of measure for the visibility value
	 * @param visibilityUnitOfMeasure the unit of measure for the visibility value
	 */
	public void setVisibilityUnitOfMeasure(String visibilityUnitOfMeasure) {
		this.visibilityUnitOfMeasure = visibilityUnitOfMeasure;
	}
	
	/**
	 * returns the direction of the visibility information, typical examples for
	 * the direction values are: N, NW, W, SW, S, SE, E and NE.
	 * @return the direction of the visibility information
	 */
	public String getDirection() {
		return direction;
	}
	
	/**
	 * sets the direction of the visibility information, typical examples for
	 * the direction values are: N, NW, W, SW, S, SE, E and NE.
	 * @param direction the direction of the visibility information
	 */
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
	
	/**
	 * returns true if the visibility is greater than the stored value 
	 * @return true if the visibility is greater than the stored value 
	 */
	public boolean isGreaterThan() {
		return greaterThan;
	}
	
	/**
	 * sets the greaterThan flag to true if the visibility is greater 
	 * than the stored value
	 * @param greaterThan true if the visibility is greater than the stored value 
	 */
	public void setGreaterThan(boolean greaterThan) {
		this.greaterThan = greaterThan;
	}

}
