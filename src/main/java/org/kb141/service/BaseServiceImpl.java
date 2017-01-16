package org.kb141.service;

import java.util.List;

import org.kb141.dao.BaseDAO;
import org.kb141.domain.BaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {
	
	
	
	@Autowired
	private BaseDAO baseDAO;
	
	@Override
	public void register(BaseVO vo) {

		try{
			baseDAO.save(vo);
		} catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public BaseVO view(Integer kno) {
		
		BaseVO vo = null;
		try{
			vo = baseDAO.findOne(kno);
		}catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void modify(BaseVO vo) {
		try{
			baseDAO.save(vo);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void remove(Integer kno) {
		try{
			baseDAO.delete(kno);
		} catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public List<BaseVO> getlist() {
		List<BaseVO> vo = null;
		try{
			vo = baseDAO.findAll();
		} catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

}
