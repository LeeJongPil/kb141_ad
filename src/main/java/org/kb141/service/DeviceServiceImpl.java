package org.kb141.service;

import java.util.List;

import org.kb141.dao.DeviceDAO;
import org.kb141.domain.DeviceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	DeviceDAO deviceDAO;

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

}
