package org.kb141.service;

import java.util.List;

import org.kb141.dao.DeviceDAO;
import org.kb141.domain.DeviceListVO;
import org.kb141.domain.DeviceVO;
import org.kb141.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDAO deviceDAO;
	
	@Autowired
	private DeviceMapper deviceMapper;
	

	@Override
	public void register(DeviceVO vo) {
		try {
			deviceDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public DeviceVO view(Integer dno) {
		DeviceVO result = null;
		try {
			result = deviceDAO.findOne(dno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void modify(DeviceVO vo) {
		try {
			deviceDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer dno) {
		try {
			deviceDAO.delete(dno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DeviceVO> getList() {
		List<DeviceVO> result = null;
		try {
			result = deviceDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<DeviceListVO> getDevList() {
		List<DeviceListVO> result = null;
		try {
			int total = 0;
			result = deviceMapper.devList();
//			최고 8개 만 따질것이다.
			for(int i = 0 ; i < 8 ; i ++){	// 총 logcnt 더한값  total 저장
				total += result.get(i).getLogcnt();
			}
			
			for(int i = 0 ; i < 8 ; i ++){
				double logcnt = result.get(i).getLogcnt(); // double형으로 받는다.
				double rlogcnt = logcnt / total;
				int res = (int) Math.round(rlogcnt * 100);
				result.get(i).setLogPercent(res);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<DeviceListVO> getStateGenderCount() {
		List<DeviceListVO> result = null;
		try {
			result = deviceMapper.getStateGenderCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
