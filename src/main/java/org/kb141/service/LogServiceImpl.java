package org.kb141.service;

import java.util.List;

import org.kb141.dao.LogDAO;
import org.kb141.domain.LogVO;
import org.kb141.mapper.LogMapper;
import org.kb141.util.ChartAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDAO logDAO;

	@Autowired
	private LogMapper logMapper;
	
	
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
		List<LogVO> vo = null;
		try{
			vo = logDAO.findAll();
		} catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public Integer countLog() {
		int num = 0;
		
		try {
			num = logMapper.countLog();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Integer getAdviewership() {
		int num = 0;
		try {
			num = logMapper.Adviewership();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public ChartAttributes getDateView() {
		ChartAttributes result = null;
		try {
			result = logMapper.getDateView();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<LogVO> getListByAdno(Integer adno) {
		List<LogVO> vo = null;
		try{
			vo = logDAO.findByAdno(adno);
		} catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<LogVO> getClientList(String cid) {
		List<LogVO> list = null;
		try{
			list = logMapper.getClientList(cid);
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<LogVO> getListByGender(String gender) {
		List<LogVO> list = null;
		try{
			list = logDAO.findByGenderEquals(gender);
		} catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ChartAttributes getDateViewByAdno(Integer adno) {
		ChartAttributes result = null;
		try {
			result = logMapper.getDateViewByAdno(adno);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
