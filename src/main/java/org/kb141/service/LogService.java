package org.kb141.service;

import java.util.List;

import org.kb141.domain.LogVO;

public interface LogService {
	
	public void register(LogVO vo);
	
	public LogVO view(Integer lno);
	
	public void modify(LogVO vo);
	
	public void remove(Integer lno);
	
	public List<LogVO> getList();

}
