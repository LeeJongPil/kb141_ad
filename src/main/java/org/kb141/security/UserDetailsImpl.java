package org.kb141.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kb141.domain.SecurityVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetailsImpl extends User {

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public UserDetailsImpl(SecurityVO securityVO) {
		super(securityVO.getUserid(), securityVO.getUserpw(), authorities(securityVO));
		this.company = securityVO.getCompany(); 
	}

	private static Collection<? extends GrantedAuthority> authorities(SecurityVO securityVO) {
		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority(securityVO.getRole()));
		return authorities;
	}

}
