package org.kb141.service;

import java.util.List;

import org.kb141.dao.MessageDAO;
import org.kb141.domain.Criteria;
import org.kb141.domain.MessageVO;
import org.kb141.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public void updateState(MessageVO vo) {
		try {
			messageMapper.updateState(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@Override
	public List<MessageVO> pagingList(Criteria cri) {
		List<MessageVO> list = null;
		try{
			cri.setTotal(messageMapper.count());
			System.out.println("service total : " + cri.getTotal());
			System.out.println("service page : " + cri.getpage());
			System.out.println("service pageNum : " + cri.getPerPageNum());
			
		//																			  몇 페이지 ,  몇개 읽어 올건지  ,         정렬            "정렬기준할거"
						PageRequest page = new PageRequest(cri.getpage(), cri.getPerPageNum(), new Sort(Direction.DESC, "mno"));
						
						Page<MessageVO> result = dao.findAll(page);
						
						 list = result.getContent();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MessageVO> nextPagingList(Criteria cri) {
		List<MessageVO> list = null;
		try{
		//																		   몇 페이지 ,  몇개 읽어 올건지  ,         정렬            "정렬기준할거"
			PageRequest page = new PageRequest(cri.getpage(), cri.getPerPageNum(), new Sort(Direction.DESC, "mno"));
			
			Page<MessageVO> result = dao.findAll(page);
			
			 list = result.getContent();
		}catch(Exception e){
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
