package org.kb141.service;

import java.util.List;

import org.kb141.domain.BaseVO;

public interface BaseService {

	public void register(BaseVO vo);
	
	public BaseVO view(Integer bno);
	
	public void modify(BaseVO vo);
	
	public void remove(Integer bno);
	
	public List<BaseVO> getList();
}
