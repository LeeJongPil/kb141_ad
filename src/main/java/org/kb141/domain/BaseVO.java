package org.kb141.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_base") // table 생성할때 만들어지는 이름

public class BaseVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bno;

	@Column
	private Integer age;

	@Column
	private String gender;

	@Column
	private String emotion;

	@Column
	private String area;

	@Column(nullable = false)
	private String ad;

	private Date bdate;

	@PrePersist
	protected void onCreate() {
		this.bdate = new Date();
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}


	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	@Override
	public String toString() {
		return "BaseVO [bno=" + bno + ", age=" + age + ", gender=" + gender + ", emotion=" + emotion + ", area=" + area
				+ ", ad=" + ad + ", bdate=" + bdate + "]";
	}


}
