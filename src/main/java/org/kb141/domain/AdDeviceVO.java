package org.kb141.domain;

import java.util.Date;

public class AdDeviceVO {
  
	private Integer dno, adno;
	private boolean permission; 
	private String ad_title, ad_content, category, cid, target_area;
	private String ad_image, ad_video;
	private Double lng, lat;
	private Date start_duration, end_duration;
	public Integer getDno() {
		return dno;
	}
	public void setDno(Integer dno) {
		this.dno = dno;
	}
	public Integer getAdno() {
		return adno;
	}
	public void setAdno(Integer adno) {
		this.adno = adno;
	}
	public boolean isPermission() {
		return permission;
	}
	public void setPermission(boolean permission) {
		this.permission = permission;
	}
	public String getAd_title() {
		return ad_title;
	}
	public void setAd_title(String ad_title) {
		this.ad_title = ad_title;
	}
	public String getAd_content() {
		return ad_content;
	}
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getTarget_area() {
		return target_area;
	}
	public void setTarget_area(String target_area) {
		this.target_area = target_area;
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
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
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
	@Override
	public String toString() {
		return "AdDeviceVO [dno=" + dno + ", adno=" + adno + ", permission=" + permission + ", ad_title=" + ad_title
				+ ", ad_content=" + ad_content + ", category=" + category + ", cid=" + cid + ", target_area="
				+ target_area + ", ad_image=" + ad_image + ", ad_video=" + ad_video + ", lng=" + lng + ", lat=" + lat
				+ ", start_duration=" + start_duration + ", end_duration=" + end_duration + "]";
	}
}
