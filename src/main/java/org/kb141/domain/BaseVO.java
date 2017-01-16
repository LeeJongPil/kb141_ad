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
@Table(name = "tbl_base") // table 생성할때 만들어지는 이름

public class BaseVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bno;
	
	@Column(nullable = false)
	private Integer bage;
	
	@Column(nullable = false)
	private String bgender;
	
	@Column(nullable = false)
	private String bemotion;
	
	@Column(nullable = false)
	private String b_first;
	
	@Column(nullable = false)
	private String b_second;
	
	@Column(nullable = false)
	private String b_third;

	
	
	public Integer getBno() {
		return bno;
	}



	public void setBno(Integer bno) {
		this.bno = bno;
	}



	public Integer getBage() {
		return bage;
	}



	public void setBage(Integer bage) {
		this.bage = bage;
	}



	public String getBgender() {
		return bgender;
	}



	public void setBgender(String bgender) {
		this.bgender = bgender;
	}



	public String getBemotion() {
		return bemotion;
	}



	public void setBemotion(String bemotion) {
		this.bemotion = bemotion;
	}



	public String getB_first() {
		return b_first;
	}



	public void setB_first(String b_first) {
		this.b_first = b_first;
	}



	public String getB_second() {
		return b_second;
	}



	public void setB_second(String b_second) {
		this.b_second = b_second;
	}



	public String getB_third() {
		return b_third;
	}



	public void setB_third(String b_third) {
		this.b_third = b_third;
	}



	@Override
	public String toString() {
		return "BaseVO [bno=" + bno + ", bage=" + bage + ", bgender=" + bgender + ", bemotion=" + bemotion
				+ ", b_first=" + b_first + ", b_second=" + b_second + ", b_third=" + b_third + "]";
	}
	
	
}