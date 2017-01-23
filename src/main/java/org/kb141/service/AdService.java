
package org.kb141.service;

import java.util.List;

import org.kb141.domain.AdVO;
import org.kb141.domain.DeviceVO;

public interface AdService {

	public void register(AdVO vo);
	
	public AdVO view(Integer adno);
	
	public void modify(AdVO vo);
	
	public void remove(Integer adno);
	
	public List<AdVO> getList();
	
	public Integer getCount();
	
	public List<DeviceVO> getMapChecking(Integer adno);
}
