package org.kb141.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_device")

public class DeviceVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dno;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String city;

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
	}

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

	@Override
	public String toString() {
		return "DeviceVO [dno=" + dno + ", state=" + state + ", city=" + city + "]";
	}

}
