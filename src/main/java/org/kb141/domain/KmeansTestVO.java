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
@Table(name="tbl_kmeanstest")
public class KmeansTestVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lno;
	
	@Column(nullable = false)
	private Integer age;

	@Column(nullable = false)
	private String gender;
	
	@Column(nullable = false)
	private Double emotion_before;
	
	@Column(nullable = false)
	private Double emotion_after;
	
	@Column(nullable = false)
	private String category;

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


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Double getEmotion_before() {
		return emotion_before;
	}

	public void setEmotion_before(Double emotion_before) {
		this.emotion_before = emotion_before;
	}

	public Double getEmotion_after() {
		return emotion_after;
	}

	public void setEmotion_after(Double emotion_after) {
		this.emotion_after = emotion_after;
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
		return "KmeansTestVO [lno=" + lno + ", age=" + age + ", gender=" + gender + ", emotion_before=" + emotion_before
				+ ", emotion_after=" + emotion_after + ", category=" + category + ", watch_time=" + watch_time
				+ ", curr_time=" + curr_time + "]";
	}
	
}
