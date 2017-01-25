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
		this.cha_happiness = this.aft_happiness - this.bef_happiness;
		this.cha_anger = this.aft_anger - this.bef_anger;
		this.cha_sadness = this.aft_sadness - this.bef_sadness;
		this.cha_neutral = this.aft_neutral - this.bef_neutral;
		this.cha_surprise = this.aft_surprise - this.bef_surprise;
		this.cha_fear = this.aft_fear - this.bef_fear;
		this.cha_contempt = this.aft_contempt - this.bef_contempt;
		this.cha_disgust = this.aft_disgust - this.bef_disgust;
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


	public Double getBef_happiness() {
		return bef_happiness;
	}


	public void setBef_happiness(Double bef_happiness) {
		this.bef_happiness = bef_happiness;
	}


	public Double getBef_anger() {
		return bef_anger;
	}


	public void setBef_anger(Double bef_anger) {
		this.bef_anger = bef_anger;
	}


	public Double getBef_sadness() {
		return bef_sadness;
	}


	public void setBef_sadness(Double bef_sadness) {
		this.bef_sadness = bef_sadness;
	}


	public Double getBef_neutral() {
		return bef_neutral;
	}


	public void setBef_neutral(Double bef_neutral) {
		this.bef_neutral = bef_neutral;
	}


	public Double getBef_surprise() {
		return bef_surprise;
	}


	public void setBef_surprise(Double bef_surprise) {
		this.bef_surprise = bef_surprise;
	}


	public Double getBef_fear() {
		return bef_fear;
	}


	public void setBef_fear(Double bef_fear) {
		this.bef_fear = bef_fear;
	}


	public Double getBef_contempt() {
		return bef_contempt;
	}


	public void setBef_contempt(Double bef_contempt) {
		this.bef_contempt = bef_contempt;
	}


	public Double getBef_disgust() {
		return bef_disgust;
	}


	public void setBef_disgust(Double bef_disgust) {
		this.bef_disgust = bef_disgust;
	}


	public Double getAft_happiness() {
		return aft_happiness;
	}


	public void setAft_happiness(Double aft_happiness) {
		this.aft_happiness = aft_happiness;
	}


	public Double getAft_anger() {
		return aft_anger;
	}


	public void setAft_anger(Double aft_anger) {
		this.aft_anger = aft_anger;
	}


	public Double getAft_sadness() {
		return aft_sadness;
	}


	public void setAft_sadness(Double aft_sadness) {
		this.aft_sadness = aft_sadness;
	}


	public Double getAft_neutral() {
		return aft_neutral;
	}


	public void setAft_neutral(Double aft_neutral) {
		this.aft_neutral = aft_neutral;
	}


	public Double getAft_surprise() {
		return aft_surprise;
	}


	public void setAft_surprise(Double aft_surprise) {
		this.aft_surprise = aft_surprise;
	}


	public Double getAft_fear() {
		return aft_fear;
	}


	public void setAft_fear(Double aft_fear) {
		this.aft_fear = aft_fear;
	}


	public Double getAft_contempt() {
		return aft_contempt;
	}


	public void setAft_contempt(Double aft_contempt) {
		this.aft_contempt = aft_contempt;
	}


	public Double getAft_disgust() {
		return aft_disgust;
	}


	public void setAft_disgust(Double aft_disgust) {
		this.aft_disgust = aft_disgust;
	}

	
	public Double getCha_happiness() {
		return cha_happiness;
	}


	public void setCha_happiness(Double cha_happiness) {
		this.cha_happiness = cha_happiness;
	}


	public Double getCha_anger() {
		return cha_anger;
	}


	public void setCha_anger(Double cha_anger) {
		this.cha_anger = cha_anger;
	}


	public Double getCha_sadness() {
		return cha_sadness;
	}


	public void setCha_sadness(Double cha_sadness) {
		this.cha_sadness = cha_sadness;
	}


	public Double getCha_neutral() {
		return cha_neutral;
	}


	public void setCha_neutral(Double cha_neutral) {
		this.cha_neutral = cha_neutral;
	}


	public Double getCha_surprise() {
		return cha_surprise;
	}


	public void setCha_surprise(Double cha_surprise) {
		this.cha_surprise = cha_surprise;
	}


	public Double getCha_fear() {
		return cha_fear;
	}


	public void setCha_fear(Double cha_fear) {
		this.cha_fear = cha_fear;
	}


	public Double getCha_contempt() {
		return cha_contempt;
	}


	public void setCha_contempt(Double cha_contempt) {
		this.cha_contempt = cha_contempt;
	}


	public Double getCha_disgust() {
		return cha_disgust;
	}


	public void setCha_disgust(Double cha_disgust) {
		this.cha_disgust = cha_disgust;
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
