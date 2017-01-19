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
@Table(name="tbl_log")
public class LogVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lno;
	
	@Column(nullable = false)
	private Integer dno;
	
	@Column(nullable = false)
	private Integer age;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private Integer adno;

	@Column(nullable = false)
	private Integer watch_time;
	
	private Date curr_time;
	
	@Column(nullable = false)
	private Double bef_happiness;
	
	@Column(nullable = false)
	private Double bef_anger;
	
	@Column(nullable = false)
	private Double bef_sadness;
	
	@Column(nullable = false)
	private Double bef_neutral;

	@Column(nullable = false)
	private Double bef_surprise;
	
	@Column(nullable = false)
	private Double bef_fear;
	
	@Column(nullable = false)
	private Double bef_contempt;
	
	@Column(nullable = false)
	private Double bef_disgust;
	
//	@Column(nullable = false)
	private Double aft_happiness;
	
//	@Column(nullable = false)
	private Double aft_anger;
	
//	@Column(nullable = false)
	private Double aft_sadness;
	
//	@Column(nullable = false)
	private Double aft_neutral;

//	@Column(nullable = false)
	private Double aft_surprise;
	
//	@Column(nullable = false)
	private Double aft_fear;
	
//	@Column(nullable = false)
	private Double aft_contempt;
	
//	@Column(nullable = false)
	private Double aft_disgust;
	
	private Double cha_happiness;
	
	private Double cha_anger;
	
	private Double cha_sadness;
	
	private Double cha_neutral;

	private Double cha_surprise;
	
	private Double cha_fear;
	
	private Double cha_contempt;
	
	private Double cha_disgust;
	
	private String rule;
	
	@PrePersist
	protected void onCreate() {
		this.curr_time = new Date();
		
//		this.cha_happiness = this.aft_happiness - this.bef_happiness;
//		this.cha_anger = this.aft_anger - this.bef_anger;
//		this.cha_sadness = this.aft_sadness - this.bef_sadness;
//		this.cha_neutral = this.aft_neutral - this.bef_neutral;
//		this.cha_surprise = this.aft_surprise - this.bef_surprise;
//		this.cha_fear = this.aft_fear - this.bef_fear;
//		this.cha_contempt = this.aft_contempt - this.bef_contempt;
//		this.cha_disgust = this.aft_disgust - this.bef_disgust;
	}
	
	
	public Integer getLno() {
		return lno;
	}

	public void setLno(Integer lno) {
		this.lno = lno;
	}

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
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

	
	public Integer getAdno() {
		return adno;
	}

	public void setAdno(Integer adno) {
		this.adno = adno;
	}

	public Integer getWatch_time() {
		return watch_time;
	}

	public void setWatch_time(Integer watch_time) {
		this.watch_time = watch_time;
	}

	public Date getCurr_time() {
		return curr_time;
	}

	public void setCurr_time(Date curr_time) {
		this.curr_time = curr_time;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}


	@Override
	public String toString() {
		return "LogVO [lno=" + lno + ", dno=" + dno + ", age=" + age + ", gender=" + gender + ", adno=" + adno
				+ ", watch_time=" + watch_time + ", curr_time=" + curr_time + ", bef_happiness=" + bef_happiness
				+ ", bef_anger=" + bef_anger + ", bef_sadness=" + bef_sadness + ", bef_neutral=" + bef_neutral
				+ ", bef_surprise=" + bef_surprise + ", bef_fear=" + bef_fear + ", bef_contempt=" + bef_contempt
				+ ", bef_disgust=" + bef_disgust + ", aft_happiness=" + aft_happiness + ", aft_anger=" + aft_anger
				+ ", aft_sadness=" + aft_sadness + ", aft_neutral=" + aft_neutral + ", aft_surprise=" + aft_surprise
				+ ", aft_fear=" + aft_fear + ", aft_contempt=" + aft_contempt + ", aft_disgust=" + aft_disgust
				+ ", cha_happiness=" + cha_happiness + ", cha_anger=" + cha_anger + ", cha_sadness=" + cha_sadness
				+ ", cha_neutral=" + cha_neutral + ", cha_surprise=" + cha_surprise + ", cha_fear=" + cha_fear
				+ ", cha_contempt=" + cha_contempt + ", cha_disgust=" + cha_disgust + ", rule=" + rule + "]";
	}
	
	
	
}
