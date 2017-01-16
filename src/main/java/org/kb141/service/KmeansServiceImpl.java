package org.kb141.service;

import java.util.List;

import org.kb141.dao.KmeansDAO;
import org.kb141.domain.KmeansVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KmeansServiceImpl implements KmeansService {
	
	@Autowired
	private KmeansDAO kmeansDAO;
	
	@Override
	public void register(KmeansVO vo) {
		
		try{
			kmeansDAO.save(vo);
		} catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public KmeansVO view(Integer kno) {
		KmeansVO vo = null;
		try{
			vo = kmeansDAO.findOne(kno);
		}catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void modify(KmeansVO vo) {
		try{
			kmeansDAO.save(vo);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void remove(Integer kno) {
		try{
			kmeansDAO.delete(kno);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<KmeansVO> getList() {
		List<KmeansVO> vo = null;
		try{
			vo = kmeansDAO.findAll();
		} catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}
}


