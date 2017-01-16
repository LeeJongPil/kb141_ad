package org.kb141.service;

import java.util.List;

import org.kb141.dao.AdDAO;
import org.kb141.domain.AdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService {

	@Autowired
	private AdDAO adDAO;

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

}