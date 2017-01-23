package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.MessageDAO;
import org.kb141.domain.MessageVO;
import org.kb141.mapper.MessageMapper;
import org.kb141.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTests {
	
	@Autowired
	private MessageDAO dao;
	
	@Autowired
	private MessageService service;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Test
	public void createTest(){
		for(int i = 0 ; i < 100 ; i++){
			MessageVO vo = new MessageVO();
			vo.setMfrom("admin");
			vo.setMto("client" + i);
			vo.setMtitle("createTest title" + i);
			vo.setMcontent("create Test content" + i);
			vo.setChecked(false);
			dao.save(vo);
			
		}
	}
	
	@Test
	public void readTest(){
		System.out.println(dao.findOne(3));
	}
	
	@Test
	public void updateTest(){
		MessageVO vo = new MessageVO();
		vo.setMno(3);
		vo.setMfrom("admin");
		vo.setMto("client12345");
		vo.setMtitle("createTest title12345");
		vo.setMcontent("create Test content12345");
		vo.setChecked(true);
		dao.save(vo);
	}
	
	@Test
	public void deleteTest(){
		dao.delete(3);
	}
	
	@Test
	public void mnoListTest(){
		
		PageRequest page = new PageRequest(2, 10, new Sort(Direction.DESC, "mno"));
		
		Page<MessageVO> result = dao.findAll(page);
		
		List<MessageVO> list = result.getContent();
		
		System.out.println(list);

	}
	
	// ---------------- service ----------------------
	
	@Test
	public void registerTest(){
		MessageVO vo = new MessageVO();
		vo.setMfrom("regTest admin");
		vo.setMto("regTest client");
		vo.setMtitle("regTest title");
		vo.setMcontent("regTest content");
		vo.setChecked(false);
		service.register(vo);
	}
	
	@Test
	public void viewTest(){
		System.out.println(service.view(101));
	}
	
	@Test
	public void modifyTest(){
		MessageVO vo = new MessageVO();
		vo.setMno(101);
		vo.setMfrom("modifyTest admin");
		vo.setMto("modifyTest client");
		vo.setMtitle("modifyTest title");
		vo.setMcontent("modifyTest content");
		vo.setChecked(true);
		service.modify(vo);
	}
	
	@Test
	public void removeTest(){
		service.remove(101);
	}
	
	@Test
	public void getListTest(){
		System.out.println(service.getList());
	}
	
	@Test
	public void getCountMsg() {
		System.out.println(service.countMsg());
	}
	
	@Test
	public void getMsgLIstTest() {
		List<MessageVO> list = service.getMsgList("client0");
		for(int i = 0 ; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	// ---------------- Mapper Test ----------------------
	
	@Test
	public void countMsgTest() throws Exception {
		System.out.println(messageMapper.countMsg());
	}
	
	@Test
	public void MsgList() throws Exception{
		List<MessageVO> list = messageMapper.msgList("client0");
		for(int i = 0 ; i <list.size(); i++){
			System.out.println(list.get(i));
		}
		
		
	}

}
