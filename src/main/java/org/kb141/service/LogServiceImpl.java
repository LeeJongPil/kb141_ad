package org.kb141.service;

import java.util.List;

import org.kb141.dao.LogDAO;
import org.kb141.domain.LogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	LogDAO logDAO;
	
	@Override
	public void register(LogVO vo) {
		try {
			logDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public LogVO view(Integer lno) {
		LogVO result = null;
		try {
			result = logDAO.findOne(lno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void modify(LogVO vo) {
		try {
			logDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Integer lno) {
		try {
			logDAO.delete(lno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<LogVO> getList() {
		List<LogVO> result = null;
		try {
			result = logDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
