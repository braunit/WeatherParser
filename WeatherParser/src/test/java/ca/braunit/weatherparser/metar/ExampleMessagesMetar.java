package ca.braunit.weatherparser.metar;

public final class ExampleMessagesMetar {

	/**
	 * Visibility in Statute Miles 
	 */
	public static final String METAR_EXAMPLE_1 = "CYVR 030100Z 08006KT 6SM -RA SCT009 BKN021 OVC050 10/09 A3007 RESHRA WS RWY11L WS RWY11R RMK SF3SC3SC2 SLP181";

	/**
	 * Visibility in Meters 
	 */
	public static final String METAR_EXAMPLE_2 = "CYVR 030100Z 08006KT 2000 -RA SCT009 BKN021 OVC050 10/09 A3007 RESHRA WS RWY11L WS RWY11R RMK SF3SC3SC2 SLP181";
	
	/**
	 * CAVOK
	 */
	public static final String METAR_EXAMPLE_3 = "BIKF 250600Z 02013KT CAVOK 07/04 Q1020";

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
