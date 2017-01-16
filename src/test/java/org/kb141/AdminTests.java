package org.kb141;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.AdminDAO;
import org.kb141.domain.AdminVO;
import org.kb141.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTests {

	@Autowired
	private AdminDAO dao;

	@Autowired
	private AdminService service;

	@Test
	public void createTest() throws Exception {
		AdminVO vo = new AdminVO();
		vo.setAid("ya");
		vo.setApw("ho");
		dao.save(vo);
	}
	
	
	@Test
	public void readTest() throws Exception{
		AdminVO vo = dao.findOne("admin");
		log.info("VO" + vo);
		
	}
	
	
	@Test
	public void updateTest() throws Exception{
		AdminVO vo = new AdminVO();
		vo.setAid("test");
		vo.setApw("test2");
		dao.save(vo);
	}
	
	@Test
	public void deleteTest() throws Exception{
		AdminVO vo = new AdminVO();
		vo.setAid("test");
		dao.delete(vo);
	}
	
	
	@Test
	public void listTest() throws Exception{
		List<AdminVO> list = dao.findAll();
		System.out.println(list);
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	public void insertTest() throws Exception{
		AdminVO vo = new AdminVO();
		vo.setAid("ya");
		vo.setApw("ho");
		service.insert(vo);
	}
	
	@Test
	public void viewTest() throws Exception{
		System.out.println(service.view("ya"));
	}
	
	
	@Test
	public void modifyTest() throws Exception{
		AdminVO vo = new AdminVO();
		vo.setAid("ya");
		vo.setApw("서인효주거라");
		service.modify(vo);
	}

	
	@Test
	public void removeTest() throws Exception{
		service.remove("ya");
	}
	
	@Test
	public void getListTest() throws Exception{
		System.out.println(service.getList());
	}
	
}
