package org.kb141.service;

import java.util.List;

import org.kb141.domain.AdVO;

public interface AdService {

	public void register(AdVO vo);
	
	public AdVO view(Integer adno);
	
	public void modify(AdVO vo);
	
	public void remove(Integer adno);
	
	public List<AdVO> getList();
	
}
