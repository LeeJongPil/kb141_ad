package org.kb141.service;

import java.util.List;

import org.kb141.dao.MessageDAO;
import org.kb141.domain.MessageVO;
import org.kb141.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDAO dao;
	
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public void register(MessageVO vo) {
		try {
			dao.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public MessageVO view(Integer mno) {
		MessageVO vo = null;
		try {
			vo = dao.findOne(mno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void modify(MessageVO vo) {
		try {
			dao.save(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void remove(Integer mno) {
		try {
			dao.delete(mno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MessageVO> getList() {
		List<MessageVO> result = null;
		try {
			result = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer countMsg() {
		Integer num = 0;
		
		try {
			num = messageMapper.countMsg();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<MessageVO> getMsgList(String mto) {
		List<MessageVO> list = null;
		try {
			list = messageMapper.msgList(mto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// @Override
	// public List<MessageVO> getList(Integer pageNum) {
	// List<MessageVO> list = null;
	// try {
	// PageRequest page = new PageRequest(pageNum, 10, new Sort(Direction.DESC,
	// "mno"));
	// Page<MessageVO> result = dao.findAll(page);
	// list = result.getContent();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return list;
	// }
}
