package org.kb141.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_client")
public class ClientVO {

	@Id
	private String cid;

	@Column(nullable = false)
	private String cpw;

	@Column(nullable = false)
	private String company;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCpw() {
		return cpw;
	}

	public void setCpw(String cpw) {
		this.cpw = cpw;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "ClientVO [cid=" + cid + ", cpw=" + cpw + ", company=" + company + "]";
	}

}
