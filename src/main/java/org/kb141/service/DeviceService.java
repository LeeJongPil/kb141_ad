package org.kb141.service;

import java.util.List;

import org.kb141.domain.DeviceListVO;
import org.kb141.domain.DeviceVO;

public interface DeviceService {

	public void register(DeviceVO vo);

	public DeviceVO view(Integer dno);

	public void modify(DeviceVO vo);

	public void remove(Integer dno);

	public List<DeviceVO> getList();
	
	public List<DeviceListVO> getDevList();
	
	public List<DeviceListVO> getClientDevList();
	
	public List<DeviceListVO> getStateGenderCount();
	
	public List<DeviceVO> getClientCount(String cid);

	public Integer getLastDno();
}
