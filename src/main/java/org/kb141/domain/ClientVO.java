package org.kb141.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_client")
@Getter
@Setter
public class ClientVO {

	@Id
	private String cid;
	
	@Column(nullable = false)
	private String cpw;
	
	@Column(nullable = false)
	private String company;

	@Override
	public String toString() {
		return "ClientVO [cid=" + cid + ", cpw=" + cpw + ", company=" + company + "]";
	}
	
	
	
	
}
