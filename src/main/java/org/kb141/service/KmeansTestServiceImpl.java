package org.kb141.service;

import java.util.List;

import org.kb141.dao.KmeansTestDAO;
import org.kb141.domain.KmeansTestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KmeansTestServiceImpl implements KmeansTestService {

	@Autowired
	private KmeansTestDAO kmeansDAO;
	
	@Override
	public void register(KmeansTestVO vo) {
		
		try{
			kmeansDAO.save(vo);
		} catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public KmeansTestVO view(Integer kno) {
		KmeansTestVO vo = null;
		try{
			vo = kmeansDAO.findOne(kno);
		}catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void modify(KmeansTestVO vo) {
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
	public List<KmeansTestVO> getList() {
		List<KmeansTestVO> vo = null;
		try{
			vo = kmeansDAO.findAll();
		} catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<KmeansTestVO> getGenderList(String gender) {
		List<KmeansTestVO> vo = null;
		try{
			vo = kmeansDAO.findByGenderEquals(gender);
		} catch(Exception e){
			e.printStackTrace();
		}
		return vo;
	}

}
