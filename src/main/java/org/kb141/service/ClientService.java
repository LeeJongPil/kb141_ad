package org.kb141.service;

import java.util.List;

import org.kb141.domain.ClientVO;

public interface ClientService {
	public void register(ClientVO vo);

	public ClientVO view(String cid);

	public void modify(ClientVO vo);

	public void remove(String cid);

	public List<ClientVO> getList();
}
