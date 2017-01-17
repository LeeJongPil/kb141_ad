package org.kb141.service;

import java.util.List;

import org.kb141.domain.KmeansTestVO;

public interface KmeansTestService {
	
	public void register(KmeansTestVO vo);
	
	public KmeansTestVO view(Integer kno);
	
	public void modify(KmeansTestVO vo);
	
	public void remove(Integer kno);
	
	public List<KmeansTestVO> getList();
	
	public List<KmeansTestVO> getGenderList(String gender);
}
