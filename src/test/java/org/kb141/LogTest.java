package org.kb141;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.LogDAO;
import org.kb141.domain.LogVO;
import org.kb141.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {
	
	@Autowired
	private LogDAO dao;
	
	@Autowired
	private LogService service;
	
	@Test
	public void createTest() {
		
		LogVO vo = new LogVO();
		vo.setDno(10);
		vo.setAge(20);
		vo.setGender("M");
//		vo.setEmotion_before("SAD");
//		vo.setEmotion_after("HAPPY");
//		vo.setEmotion_change("SO HAPPY");
		vo.setAdno(1);
		vo.setWatch_time(3);
		
		dao.save(vo);

	}
	
	@Test
	public void readTest() {
		System.out.println(dao.findOne(1));
		
	}
	
	@Test
	public void updateTest() {
		
		LogVO vo = new LogVO();
		vo.setDno(2);
		vo.setAge(3);
		vo.setGender("F");
//		vo.setEmotion_before("SADDDDDDDDD");
//		vo.setEmotion_after("HAPPYYYYYYYYY");
//		vo.setEmotion_change("SO HAPPYYYYYYYYYY");
		vo.setAdno(1);
		vo.setWatch_time(3);
		vo.setLno(1);
		dao.save(vo);
	}
	
	@Test
	public void deleteTest() {
		dao.delete(2);
	}
	
	@Test
	public void listTest() {
		dao.findAll();
	}
	
	@Test
	public void registerTest() {
		LogVO vo = new LogVO();
		vo.setDno(100);
		vo.setAge(30);
		vo.setGender("F");
//		vo.setEmotion_before("SAD");
//		vo.setEmotion_after("HAPPY");
//		vo.setEmotion_change("SO HAPPY");
		vo.setAdno(1);
		vo.setWatch_time(6);
		
		service.register(vo);
	}
	
	@Test
	public void viewTest() {
		System.out.println(service.view(1));
	}
	
	@Test
	public void modifyTest() {
		LogVO vo = new LogVO();
		vo.setDno(2);
		vo.setAge(3);
		vo.setGender("F");
//		vo.setEmotion_before("SADDDDDDDDD");
//		vo.setEmotion_after("HAPPYYYYYYYYY");
//		vo.setEmotion_change("SO HAPPYYYYYYYYYY");
		vo.setAdno(1);
		vo.setWatch_time(3);
		vo.setLno(4);
		service.modify(vo);
	}
	
	@Test
	public void removeTest() {
		service.remove(4);
	}
	
	@Test
	public void getListTest() {
		System.out.println(service.getList());
	}



}
