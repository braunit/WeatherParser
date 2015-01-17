package ca.braunit.weatherparser.metar.domain;

import java.math.BigDecimal;

public class Visibility {

	private boolean cavok = false;
	private BigDecimal visibility;
	private String visibilityUnitOfMeasure = "M";
	private String direction = null;
	private boolean ndv = false;

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

	
}
