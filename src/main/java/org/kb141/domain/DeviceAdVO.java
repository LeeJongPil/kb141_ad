package org.kb141.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_device_ad")
public class DeviceAdVO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dano;

	@Column(nullable = false)
	private Integer dno;

	@Column(nullable = false)
	private Integer adno;

	public Integer getDano() {
		return dano;
	}

	public void setDano(Integer dano) {
		this.dano = dano;
	}

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

	@Override
	public String toString() {
		return "DeviceAdVO [dano=" + dano + ", dno=" + dno + ", adno=" + adno + "]";
	}
	
}
