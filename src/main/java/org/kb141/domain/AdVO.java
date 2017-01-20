package org.kb141.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_ad") // table 생성할때 만들어지는 이름
public class AdVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adno;

	@Column(nullable = false)
	private String ad_title;

	@Column(nullable = false)
	private String cid;

	@Column(nullable = false)
	private String category;

	@Column(nullable = false)
	private Date start_duration;

	@Column(nullable = false)
	private Date end_duration;

	@Column(nullable = false)
	private String ad_image;

	@Column(nullable = false)
	private String ad_video;
	
	@Column(nullable = false)
	private boolean permission;
	
	@Column(nullable = false)
	private String target_emotions;

	@Column(nullable = false)
	private String ad_content;

	public Integer getAdno() {
		return adno;
	}

	public void setAdno(Integer adno) {
		this.adno = adno;
	}

	public String getAd_title() {
		return ad_title;
	}

	public void setAd_title(String ad_title) {
		this.ad_title = ad_title;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getStart_duration() {
		return start_duration;
	}

	public void setStart_duration(Date start_duration) {
		this.start_duration = start_duration;
	}

	public Date getEnd_duration() {
		return end_duration;
	}

	public void setEnd_duration(Date end_duration) {
		this.end_duration = end_duration;
	}

	public String getAd_image() {
		return ad_image;
	}

	public void setAd_image(String ad_image) {
		this.ad_image = ad_image;
	}

	public String getAd_video() {
		return ad_video;
	}

	public void setAd_video(String ad_video) {
		this.ad_video = ad_video;
	}

	public boolean isPermission() {
		return permission;
	}

	public void setPermission(boolean permission) {
		this.permission = permission;
	}

	public String getTarget_emotions() {
		return target_emotions;
	}

	public void setTarget_emotions(String target_emotions) {
		this.target_emotions = target_emotions;
	}

	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}

	@Override
	public String toString() {
		return "AdVO [adno=" + adno + ", ad_title=" + ad_title + ", cid=" + cid + ", category=" + category
				+ ", start_duration=" + start_duration + ", end_duration=" + end_duration + ", ad_image=" + ad_image
				+ ", ad_video=" + ad_video + ", permission=" + permission + ", target_emotions=" + target_emotions
				+ ", ad_content=" + ad_content + "]";
	}
	
	

}
