package ca.braunit.weatherparser.metar.domain;

import java.util.List;

public class Metar {
	
	private String airportIcaoCode;
	private boolean metarType = false;
	private boolean speciType = false;
	private boolean correctedReport = false;
	private boolean automatedObservation = false;

	private ReportTime reportTime;
	private Wind wind;
	private Visibility visibility;
	private List<RunwayVisualRange> runwayVisualRanges;
	private List<Weather> presentWeather;
	private List<Weather> recentWeather;
	private List<Clouds> cloudsList;
	private TemperatureAndDewPoint temperatureAndDewPoint;
	private Pressure pressure;
	private List<WindShear> windShear;
	private Remarks remarks;

	public String getAirportIcaoCode() {
		return airportIcaoCode;
	}

	public void setAirportIcaoCode(String airportIcaoCode) {
		this.airportIcaoCode = airportIcaoCode;
	}

	public boolean isMetarType() {
		return metarType;
	}

	public void setMetarType(boolean metarType) {
		this.metarType = metarType;
	}

	public boolean isSpeciType() {
		return speciType;
	}

	public void setSpeciType(boolean speciType) {
		this.speciType = speciType;
	}

	public boolean isCorrectedReport() {
		return correctedReport;
	}

	public void setCorrectedReport(boolean correctedReport) {
		this.correctedReport = correctedReport;
	}

	public boolean isAutomatedObservation() {
		return automatedObservation;
	}

	public void setAutomatedObservation(boolean automatedObservation) {
		this.automatedObservation = automatedObservation;
	}

	public ReportTime getReportTime() {
		return reportTime;
	}

	public void setReportTime(ReportTime reportTime) {
		this.reportTime = reportTime;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public List<RunwayVisualRange> getRunwayVisualRanges() {
		return runwayVisualRanges;
	}

	public void setRunwayVisualRanges(List<RunwayVisualRange> runwayVisualRanges) {
		this.runwayVisualRanges = runwayVisualRanges;
	}

	public List<Weather> getPresentWeather() {
		return presentWeather;
	}

	public void setPresentWeather(List<Weather> presentWeather) {
		this.presentWeather = presentWeather;
	}

	public List<Weather> getRecentWeather() {
		return recentWeather;
	}

	public void setRecentWeather(List<Weather> recentWeather) {
		this.recentWeather = recentWeather;
	}

	public List<Clouds> getCloudsList() {
		return cloudsList;
	}

	public void setCloudsList(List<Clouds> cloudsList) {
		this.cloudsList = cloudsList;
	}

	public TemperatureAndDewPoint getTemperatureAndDewPoint() {
		return temperatureAndDewPoint;
	}

	public void setTemperatureAndDewPoint(TemperatureAndDewPoint temperatureAndDewPoint) {
		this.temperatureAndDewPoint = temperatureAndDewPoint;
	}

	public Pressure getPressure() {
		return pressure;
	}

	public void setPressure(Pressure pressure) {
		this.pressure = pressure;
	}

	public List<WindShear> getWindShear() {
		return windShear;
	}

	public void setWindShear(List<WindShear> windShear) {
		this.windShear = windShear;
	}

	public Remarks getRemarks() {
		return remarks;
	}

	public void setRemarks(Remarks remarks) {
		this.remarks = remarks;
	}

}
