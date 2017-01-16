package org.kb141.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_admin")
public class AdminVO {

	@Id
	private String aid;

	@Column(nullable = false)
	private String apw;

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getApw() {
		return apw;
	}

	public void setApw(String apw) {
		this.apw = apw;
	}

	@Override
	public String toString() {
		return "AdminVO [aid=" + aid + ", apw=" + apw + "]";
	}

}
