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

@Entity
@Table(name = "tbl_message")
public class MessageVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mno;
	
	@Column(nullable = false)
	private String mfrom;
	
	@Column(nullable = false)
	private String mto;
	
	@Column(nullable = false)
	private String mtitle;
	
	@Column(nullable = false)
	private String mcontent;
	
	@Column(nullable = false)
	private Integer checked;
	
	private Date regdate;
	private Date updatedate;
	
	@PrePersist
	protected void onCreate(){
		regdate = new Date();
		updatedate = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		updatedate = new Date();
	}

	public Integer getMno() {
		return mno;
	}

	public void setMno(Integer mno) {
		this.mno = mno;
	}

	public String getMfrom() {
		return mfrom;
	}

	public void setMfrom(String mfrom) {
		this.mfrom = mfrom;
	}

	public String getMto() {
		return mto;
	}

	public void setMto(String mto) {
		this.mto = mto;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "MessageVO [mno=" + mno + ", mfrom=" + mfrom + ", mto=" + mto + ", mtitle=" + mtitle + ", mcontent="
				+ mcontent + ", checked=" + checked + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}
	
	
	
}
