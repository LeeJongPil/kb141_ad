package org.kb141.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_device")
@Getter
@Setter
public class DeviceVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dno;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String city;

	@Override
	public String toString() {
		return "DeviceVO [dno=" + dno + ", state=" + state + ", city=" + city + "]";
	}
	
	
}
