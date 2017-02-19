package org.kb141.domain;

public class DeviceListVO {

	private String state;
	private String city;
	private Integer logcnt;
	private Integer logPercent;
	
	private Integer log_area_male;
	private Integer log_area_female;
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getLogcnt() {
		return logcnt == null ? 0 : logcnt;
	}

	public void setLogcnt(Integer logcnt) {
		this.logcnt = logcnt;
	}

	public Integer getLogPercent() {
		return logPercent == null ? 0 : logPercent;
	}

	public void setLogPercent(Integer logPercent) {
		this.logPercent = logPercent;
	}

	public Integer getLog_area_male() {
		return log_area_male == null ? 0 : log_area_male;
	}

	public void setLog_area_male(Integer log_area_male) {
		this.log_area_male = log_area_male;
	}

	public Integer getLog_area_female() {
		return log_area_female == null ? 0 : log_area_female;
	}

	public void setLog_area_female(Integer log_area_female) {
		this.log_area_female = log_area_female;
	}

	@Override
	public String toString() {
		return "DeviceListVO [state=" + state + ", city=" + city + ", logcnt=" + logcnt + ", logPercent=" + logPercent
				+ ", log_area_male=" + log_area_male + ", log_area_female=" + log_area_female + "]";
	}

}
