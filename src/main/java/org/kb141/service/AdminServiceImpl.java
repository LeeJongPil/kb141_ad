package org.kb141.service;

import java.util.List;

import org.kb141.dao.AdminDAO;
import org.kb141.domain.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDAO;

	@Override
	public void register(AdminVO vo) {
		try {
			adminDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AdminVO view(String aid) {
		AdminVO result = null;
		try {
			result = adminDAO.findOne(aid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void modify(AdminVO vo) {
		try {
			adminDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String aid) {
		try {
			adminDAO.delete(aid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<AdminVO> getList() {
		List<AdminVO> result = null;
		try {
			result = adminDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
