package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.ClientDAO;
import org.kb141.domain.ClientVO;
import org.kb141.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTests {

	@Autowired
	private ClientDAO dao;

	@Autowired
	private ClientService service;

	@Test
	public void createTest() throws Exception {
		ClientVO vo = new ClientVO();
		vo.setCid("client2");
		vo.setCpw("client2");
		vo.setCompany("client2");
		dao.save(vo);
	}

	@Test
	public void readTest() throws Exception {
		ClientVO vo = dao.findOne("client");
		System.out.println(vo);

	}

	@Test
	public void updateTest() throws Exception {
		ClientVO vo = new ClientVO();
		vo.setCid("client2");
		vo.setCpw("client2");
		vo.setCompany("updateTest");
		dao.save(vo);
	}

	@Test
	public void deleteTest() throws Exception {
		ClientVO vo = new ClientVO();
		vo.setCid("client2");
		dao.delete(vo);
	}

	@Test
	public void listTest() throws Exception {
		List<ClientVO> list = dao.findAll();
		System.out.println(list);
	}

	///////////////////////////////////////////////////////////////////////////////////

	@Test
	public void insertTest() throws Exception {
		ClientVO vo = new ClientVO();
		vo.setCid("Client2");
		vo.setCpw("Client2");
		vo.setCompany("Client2");
		service.register(vo);
	}

	@Test
	public void viewTest() throws Exception {
		System.out.println(service.view("Client2"));
	}

	@Test
	public void modifyTest() throws Exception {
		ClientVO vo = new ClientVO();
		vo.setCid("Client2");
		vo.setCpw("Client2");
		vo.setCompany("TEST!!!!!!!");
		service.modify(vo);
	}

	@Test
	public void removeTest() throws Exception {
		service.remove("Client2");
	}

	@Test
	public void getListTest() throws Exception {
		System.out.println(service.getList());
	}

}
