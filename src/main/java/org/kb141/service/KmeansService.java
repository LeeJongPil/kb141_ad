package org.kb141.service;

import java.util.List;

import org.kb141.domain.KmeansVO;

public interface KmeansService {
	
	public void register(KmeansVO vo);
	
	public KmeansVO view(Integer kno);
	
	public void modify(KmeansVO vo);
	
	public void remove(Integer kno);
	
	public List<KmeansVO> getlist();
	
}
