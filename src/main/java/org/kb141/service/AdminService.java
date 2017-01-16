package org.kb141.service;

import java.util.List;

import org.kb141.domain.AdminVO;

public interface AdminService {
	
	public void insert(AdminVO vo);
	
	public AdminVO view(String aid);
	
	public void modify(AdminVO vo);
	
	public void remove(String aid);
	
	public List<AdminVO> getList();
	
	
}
