package org.kb141.service;

import java.util.List;

import org.kb141.domain.MessageVO;


public interface MessageService {
	
	public void register(MessageVO vo);
	
	public MessageVO view(Integer mno);
	
	public void modify(MessageVO vo);
	
	public void remove(Integer mno);
	
	public List<MessageVO> getList(Integer pageNum);
	

}