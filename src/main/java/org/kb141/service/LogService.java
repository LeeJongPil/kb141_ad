package org.kb141.service;

import java.util.List;

import org.kb141.domain.LogVO;
import org.kb141.util.ChartAttributes;

public interface LogService {

	public void register(LogVO vo);
	
	public LogVO view(Integer lno);
	
	public void modify(LogVO vo);
	
	public void remove(Integer lno);
	
	public List<LogVO> getList();
	
	public Integer countLog();
	
	public Integer getAdviewership();
	
	public ChartAttributes getDateView();
	
	public List<LogVO> getListByAdno(Integer adno);
	
	public List<LogVO> getClientList(String cid) throws Exception;
}
