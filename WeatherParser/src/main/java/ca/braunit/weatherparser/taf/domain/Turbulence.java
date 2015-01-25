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
package ca.braunit.weatherparser.taf.domain;

public class Turbulence {

	private Integer turbulenceLayerBase;
	private Integer turbulenceLayerDepth;
	
	private Integer turbulenceIntensityCode;
	private String turbulenceIntensity;

	public Integer getTurbulenceLayerBase() {
		return turbulenceLayerBase;
	}
	public void setTurbulenceLayerBase(Integer turbulenceLayerBase) {
		this.turbulenceLayerBase = turbulenceLayerBase;
	}
	public Integer getTurbulenceLayerDepth() {
		return turbulenceLayerDepth;
	}
	public void setTurbulenceLayerDepth(Integer turbulenceLayerDepth) {
		this.turbulenceLayerDepth = turbulenceLayerDepth;
	}
	public Integer getTurbulenceIntensityCode() {
		return turbulenceIntensityCode;
	}
	public void setTurbulenceIntensityCode(Integer turbulenceIntensityCode) {
		this.turbulenceIntensityCode = turbulenceIntensityCode;
	}
	public String getTurbulenceIntensity() {
		return turbulenceIntensity;
	}
	public void setTurbulenceIntensity(String turbulenceIntensity) {
		this.turbulenceIntensity = turbulenceIntensity;
	}

	
}
