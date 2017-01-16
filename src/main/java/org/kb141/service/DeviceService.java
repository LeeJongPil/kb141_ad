package org.kb141.service;

import java.util.List;

import org.kb141.domain.DeviceVO;

public interface DeviceService {

	public void insert(DeviceVO vo);

	public DeviceVO view(Integer dno);

	public void modify(DeviceVO vo);

	public void remove(Integer dno);

	public List<DeviceVO> getList();
	
	
}