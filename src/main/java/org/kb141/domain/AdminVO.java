package org.kb141.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_admin")
@Getter
@Setter
public class AdminVO {

	
	@Id
	private String aid;
	
	@Column(nullable=false)
	private String apw;

	@Override
	public String toString() {
		return "AdminVO [aid=" + aid + ", apw=" + apw + "]";
	}
	
	
	
}
