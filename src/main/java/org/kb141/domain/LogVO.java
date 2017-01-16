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
	private String emotion_before;
	
	@Column(nullable = false)
	private String emotion_after;
	
	@Column(nullable = false)
	private String emotion_change;
	
	@Column(nullable = false)
	private Integer adno;

	@Column(nullable = false)
	private Integer watch_time;
	
	private Date curr_time;
	
	@PrePersist
	protected void onCreate() {
		curr_time = new Date();
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

	public String getEmotion_before() {
		return emotion_before;
	}

	public void setEmotion_before(String emotion_before) {
		this.emotion_before = emotion_before;
	}

	public String getEmotion_after() {
		return emotion_after;
	}

	public void setEmotion_after(String emotion_after) {
		this.emotion_after = emotion_after;
	}

	public String getEmotion_change() {
		return emotion_change;
	}

	public void setEmotion_change(String emotion_change) {
		this.emotion_change = emotion_change;
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

	@Override
	public String toString() {
		return "LogVO [lno=" + lno + ", dno=" + dno + ", age=" + age + ", gender=" + gender + ", emotion_before="
				+ emotion_before + ", emotion_after=" + emotion_after + ", emotion_change=" + emotion_change + ", adno="
				+ adno + ", watch_time=" + watch_time + ", curr_time=" + curr_time + "]";
	}

}
