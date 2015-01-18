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
package ca.braunit.weatherparser.metar;

public final class ExampleMessagesMetar {

	/**
	 * Visibility in Statute Miles <br>
	 * Runway Visual Range in feet
	 */
	public static final String METAR_EXAMPLE_1 = "CYVR 030100Z 08006KT 6SM R01L/0800FT -RA SCT009 BKN021 OVC050 10/09 A3007 RESHRA WS RWY11L WS RWY11R RMK SF3SC3SC2 SLP181";

	/**
	 * Visibility in Meters <br>
	 * Runway Visual Range with Variety in Feet
	 */
	public static final String METAR_EXAMPLE_2 = "CYVR 030100Z 08006KT 2000 R01L/0800V1600FT -RA SCT009 BKN021 OVC050 10/09 A3007 RESHRA WS RWY11L WS RWY11R RMK SF3SC3SC2 SLP181";
	
	/**
	 * CAVOK <br>
	 * Runway Visual Range in meter
	 */
	public static final String METAR_EXAMPLE_3 = "BIKF 250600Z 02013KT CAVOK R20/0900 07/04 Q1020";

	/**
	 * Fraction Statute Miles
	 */
	public static final String METAR_EXAMPLE_4 = "CYVR 030100Z 08006KT 3/4SM -RA SCT009 BKN021 OVC050 10/09 A3007 RESHRA WS RWY11L WS RWY11R RMK SF3SC3SC2 SLP181";

	/**
	 * Visibility in Meters with NDV Indicator
	 */
	public static final String METAR_EXAMPLE_5 = "CYVR 030100Z 08006KT 2000NDV -RA SCT009 BKN021 OVC050 10/09 A3007 RESHRA WS RWY11L WS RWY11R RMK SF3SC3SC2 SLP181";
	
	/**
	 * Visibility in Meters with direction
	 */
	public static final String METAR_EXAMPLE_6 = "CYVR 030100Z 08006KT 2000NE -RA SCT009 BKN021 OVC050 10/09 A3007 RESHRA WS RWY11L WS RWY11R RMK SF3SC3SC2 SLP181";
	
}
