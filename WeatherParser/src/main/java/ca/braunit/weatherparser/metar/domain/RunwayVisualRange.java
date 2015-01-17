package ca.braunit.weatherparser.metar.domain;

public class RunwayVisualRange {

	private String runway;

	private boolean lessThan = false;
	private boolean moreThan = false;
	private Integer visibileRange;
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
