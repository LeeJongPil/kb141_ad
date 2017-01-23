package org.kb141.domain;

public class DeviceListVO {

	private String state;
	private String city;
	private Integer logcnt;
	private Integer logPercent;
	
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
		return logcnt;
	}
	public void setLogcnt(Integer logcnt) {
		this.logcnt = logcnt;
	}
	public Integer getLogPercent() {
		return logPercent;
	}
	public void setLogPercent(Integer logPercent) {
		this.logPercent = logPercent;
	}
	@Override
	public String toString() {
		return "DeviceListVO [state=" + state + ", city=" + city + ", logcnt=" + logcnt + ", logPercent=" + logPercent
				+ "]";
	}

	
}
