package org.kb141.service;

import java.util.List;

import org.kb141.domain.DeviceAdVO;

public interface DeviceAdService {

	public void register(DeviceAdVO vo);

	public DeviceAdVO viewFromDno(Integer dno);
	
	public DeviceAdVO viewFromAdno(Integer adno);

	public void modify(DeviceAdVO vo);

	public void remove(Integer dano);

	public List<DeviceAdVO> getList();
}
