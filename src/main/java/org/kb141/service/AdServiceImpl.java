package org.kb141.service;

import java.util.List;

import org.kb141.dao.AdDAO;
import org.kb141.domain.AdDeviceVO;
import org.kb141.domain.AdVO;
import org.kb141.domain.DeviceAdVO;
import org.kb141.mapper.AdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService {

	@Autowired
	private AdDAO adDAO;

	@Autowired
	private AdMapper adMapper;

	@Override
	public void register(AdVO vo) {
		try {
			adDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public AdVO view(Integer adno) {
		AdVO vo = null;
		try {
			vo = adDAO.findOne(adno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void modify(AdVO vo) {
		try {
			adDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer adno) {
		try {
			adDAO.delete(adno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AdVO> getList() {
		List<AdVO> list = null;

		try {
			list = adDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Integer getCount() {
		int num = 0;
		
		try {
			num = adMapper.countAd();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<DeviceAdVO> getMapChecking(Integer adno) {
		List<DeviceAdVO> list = null;
		
		try {
			list = adMapper.mapChecking(adno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AdVO> getAdlist(String cid) throws Exception {
		List<AdVO> list = null;
		
		try {
			list = adMapper.getAdlist(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AdVO> getTermDuration(String cid) throws Exception {
		List<AdVO> vo = null;
		try {
			vo = adMapper.getTermDuration(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override	
	public List<AdVO> getAdListCSV() {
		List<AdVO> list = null;
		try {
			list = adMapper.adListCSV();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<AdDeviceVO> deviceListFromDno(Integer dno) {
		List<AdDeviceVO> result = null;
		try {
			result = adMapper.deviceListFromDno(dno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public AdVO getTarget_emotion(String cid) throws Exception {
		AdVO vo = null;
		try {
			vo = adMapper.getTarget_emotion(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
}

