package org.kb141.service;

import java.util.List;

import org.kb141.dao.ClientDAO;
import org.kb141.domain.ClientVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientDAO clientDAO;

	@Override
	public void insert(ClientVO vo) {
		try {
			clientDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ClientVO view(String cid) {
		ClientVO result = null;
		try {
			result = clientDAO.findOne(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void modify(ClientVO vo) {
		try {
			clientDAO.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String cid) {
		try {
			clientDAO.delete(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ClientVO> getList() {
		List<ClientVO> result = null;
		try {
			result = clientDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
