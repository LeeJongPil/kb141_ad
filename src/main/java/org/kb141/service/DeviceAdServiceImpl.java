package org.kb141.service;

import java.util.List;

import org.kb141.dao.DeviceAdDAO;
import org.kb141.domain.DeviceAdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceAdServiceImpl implements DeviceAdService {

	@Autowired
	private DeviceAdDAO dao;

	@Override
	public void register(DeviceAdVO vo) {
		try {
			dao.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(DeviceAdVO vo) {
		try {
			dao.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer dano) {
		try {
			dao.delete(dano);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DeviceAdVO> getList() {
		List<DeviceAdVO> result = null;
		try {
			result = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public DeviceAdVO viewFromDno(Integer dno) {
		DeviceAdVO result = null;
		try {
			result = dao.findFromDno(dno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public DeviceAdVO viewFromAdno(Integer adno) {
		DeviceAdVO result = null;
		try {
			result = dao.findFromAdno(adno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
