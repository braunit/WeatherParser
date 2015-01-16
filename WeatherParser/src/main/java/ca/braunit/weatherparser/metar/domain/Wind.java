package ca.braunit.weatherparser.metar.domain;

public class Wind {

	private Integer windDirection;
	private Integer windSpeed;
	private Integer windSpeedGusts;
	private Integer variableWindDirectionFrom;
	private Integer variableWindDirectionTo;
	private String speedUnitOfMeasure;

	public Integer getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}
	public Integer getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(Integer windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Integer getWindSpeedGusts() {
		return windSpeedGusts;
	}
	public void setWindSpeedGusts(Integer windSpeedGusts) {
		this.windSpeedGusts = windSpeedGusts;
	}
	public Integer getVariableWindDirectionFrom() {
		return variableWindDirectionFrom;
	}
	public void setVariableWindDirectionFrom(Integer variableWindDirectionFrom) {
		this.variableWindDirectionFrom = variableWindDirectionFrom;
	}
	public Integer getVariableWindDirectionTo() {
		return variableWindDirectionTo;
	}
	public void setVariableWindDirectionTo(Integer variableWindDirectionTo) {
		this.variableWindDirectionTo = variableWindDirectionTo;
	}
	public String getSpeedUnitOfMeasure() {
		return speedUnitOfMeasure;
	}
	public void setSpeedUnitOfMeasure(String speedUnitOfMeasure) {
		this.speedUnitOfMeasure = speedUnitOfMeasure;
	}

	
}
