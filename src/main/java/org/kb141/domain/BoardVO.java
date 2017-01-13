package org.kb141.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_ad") // table 생성할때 만들어지는 이름
@Getter
@Setter
public class BoardVO {
	// 기본자료형은 잘 쓰지 않고 객체형을 주로 쓴다. Integer 형보다는 Long 타입을 써라

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ano;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private Integer age;

	@Column(nullable = false)
	private double bef;

	@Column(nullable = false)
	private double aft;

	@Column(nullable = false)
	private String category;

	@Column(nullable = false)
	private Integer ad_time;

	@Column(nullable = false)
	private Date view_time;

	@PrePersist
	protected void onCreate() {
		view_time = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		view_time = new Date();
	}

	@Override
	public String toString() {
		return "BoardVO [ano=" + ano + ", gender=" + gender + ", age=" + age + ", bef=" + bef + ", aft=" + aft
				+ ", category=" + category + ", ad_time=" + ad_time + ", view_time=" + view_time + "]";
	}
	
	
}
