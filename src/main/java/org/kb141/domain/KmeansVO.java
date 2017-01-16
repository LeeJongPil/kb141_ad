package org.kb141.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_kmeans") // table 생성할때 만들어지는 이름

public class KmeansVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer kno;
	
	@Column(nullable = false)
	private Integer kage;
	
	@Column(nullable = false)
	private String kgender;
	
	@Column(nullable = false)
	private String kemotion;
	
	@Column(nullable = false)
	private String k_first;
	
	@Column(nullable = false)
	private String k_second;
	
	@Column(nullable = false)
	private String k_third;

	
	
	
	public Integer getKno() {
		return kno;
	}




	public void setKno(Integer kno) {
		this.kno = kno;
	}




	public Integer getKage() {
		return kage;
	}




	public void setKage(Integer kage) {
		this.kage = kage;
	}




	public String getKgender() {
		return kgender;
	}




	public void setKgender(String kgender) {
		this.kgender = kgender;
	}




	public String getKemotion() {
		return kemotion;
	}




	public void setKemotion(String kemotion) {
		this.kemotion = kemotion;
	}




	public String getK_first() {
		return k_first;
	}




	public void setK_first(String k_first) {
		this.k_first = k_first;
	}




	public String getK_second() {
		return k_second;
	}




	public void setK_second(String k_second) {
		this.k_second = k_second;
	}




	public String getK_third() {
		return k_third;
	}




	public void setK_third(String k_third) {
		this.k_third = k_third;
	}

	

	@Override
	public String toString() {
		return "KmeansVO [kno=" + kno + ", kage=" + kage + ", kgender=" + kgender + ", kemotion=" + kemotion
				+ ", k_first=" + k_first + ", k_second=" + k_second + ", k_third=" + k_third + "]";
	}
	
	
	
}
