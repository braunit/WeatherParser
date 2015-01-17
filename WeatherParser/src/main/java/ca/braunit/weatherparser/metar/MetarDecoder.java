package ca.braunit.weatherparser.metar;

import ca.braunit.weatherparser.exception.DecoderException;
import ca.braunit.weatherparser.metar.domain.Metar;
import ca.braunit.weatherparser.metar.util.ReportTimeDecoder;
import ca.braunit.weatherparser.metar.util.RunwayVisualRangeDecoder;
import ca.braunit.weatherparser.metar.util.VisibilityDecoder;
import ca.braunit.weatherparser.metar.util.WindDecoder;

public class MetarDecoder {

	private static final String METAR = "METAR";
	private static final String SPECI = "SPECI";
	private static final String CORRECTED = "COR";
	private static final String AUTOMATED_OBSERVATION = "AUTO";

	private static final String ICAO_CODE_PATTERN = "[A-Za-z]{4}";

	public static void main(String[] args) throws DecoderException {
		Metar m = MetarDecoder.decodeMetar("CYVR 030100Z 08006KT 6SM -RA SCT009 BKN021 OVC050 10/09 A3007 RESHRA WS RWY11L WS RWY11R RMK SF3SC3SC2 SLP181");
	}
	
	public static Metar decodeMetar(String metarAsString) throws DecoderException {
		return decodeObject(new StringBuffer(metarAsString.trim()));
	}

	public static Metar decodeObject(StringBuffer metarAsString) throws DecoderException {
		Metar metar = new Metar();
		deodeReportType(metar, metarAsString);
		decodeAirportIcaoCode(metar, metarAsString);
		
		metar.setReportTime(ReportTimeDecoder.decodeObject(metarAsString));
		
		decodeAutomatedObservation(metar, metarAsString);
		
		metar.setWind(WindDecoder.decodeObject(metarAsString));
		metar.setVisibility(VisibilityDecoder.decodeObject(metarAsString));
		metar.setRunwayVisualRanges(RunwayVisualRangeDecoder.decodeObject(metarAsString));
		
		return metar;
	}
	
	private static void deodeReportType(Metar metar, StringBuffer metarAsString) {
		if (metarAsString.substring(0, METAR.length()).equals(METAR)) {
			metar.setMetarType(true);
			metarAsString.delete(0, METAR.length()+1);
		} else if (metarAsString.substring(0, SPECI.length()).equals(SPECI)) {
			metar.setSpeciType(true);
			metarAsString.delete(0, SPECI.length()+1);
		} else {
			metar.setMetarType(true);
		}
	}
	
	private static void decodeAirportIcaoCode(Metar metar, StringBuffer metarAsString) throws DecoderException {
		if (metarAsString.substring(0,metarAsString.indexOf(" ")).matches(ICAO_CODE_PATTERN)) {
			metar.setAirportIcaoCode(metarAsString.substring(0,metarAsString.indexOf(" ")));
			metarAsString.delete(0, metarAsString.indexOf(" ")+1);
		} else {
			throw new DecoderException("No Airport ICAO Code available");
		}
	}
	
	private static void decodeAutomatedObservation(Metar metar, StringBuffer metarAsString) {
		if(metarAsString.substring(0,AUTOMATED_OBSERVATION.length()).equals(AUTOMATED_OBSERVATION)) {
			metar.setAutomatedObservation(true);
			metarAsString.delete(0, AUTOMATED_OBSERVATION.length()+1);
		}
	}
}
