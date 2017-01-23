package org.kb141.domain;

public class DeviceListVO {

	private String state;
	private String city;
	private Integer logcnt;
	private Integer logpercent;

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

	public Integer getLogpercent() {
		return logpercent;
	}

	public void setLogpercent(Integer logpercent) {
		this.logpercent = logpercent;
	}

	@Override
	public String toString() {
		return "DeviceListVO [state=" + state + ", city=" + city + ", logcnt=" + logcnt + ", logpercent=" + logpercent
				+ "]";
	}

}
