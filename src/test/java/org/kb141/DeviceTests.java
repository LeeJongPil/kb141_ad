package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.DeviceDAO;
import org.kb141.domain.DeviceVO;
import org.kb141.domain.DeviceVO;
import org.kb141.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceTests {

	@Autowired
	private DeviceDAO dao;

	@Autowired
	private DeviceService service;

	@Test
	public void createTest() throws Exception {
		DeviceVO vo = new DeviceVO();
		vo.setState("경기도");
		vo.setCity("안양시");
		dao.save(vo);
	}

	@Test
	public void readTest() throws Exception {
		DeviceVO vo = dao.findOne(1);
		System.out.println(vo);

	}

	@Test
	public void updateTest() throws Exception {
		DeviceVO vo = new DeviceVO();
		vo.setDno(2);
		vo.setState("경기도");
		vo.setCity("김포시");
		dao.save(vo);
	}

	@Test
	public void deleteTest() throws Exception {
		DeviceVO vo = new DeviceVO();
		vo.setDno(2);
		dao.delete(vo);
	}

	@Test
	public void listTest() throws Exception {
		List<DeviceVO> list = dao.findAll();
		System.out.println(list);
	}

	///////////////////////////////////////////////////////////////////////////////////

	@Test
	public void insertTest() throws Exception {
		DeviceVO vo = new DeviceVO();
		vo.setState("경기도");
		vo.setCity("김포시");
		service.register(vo);
	}

	@Test
	public void viewTest() throws Exception {
		System.out.println(service.view(3));
	}

	@Test
	public void modifyTest() throws Exception {
		DeviceVO vo = new DeviceVO();
		vo.setDno(3);
		vo.setState("경기도");
		vo.setCity("부천시");
		service.modify(vo);
	}

	@Test
	public void removeTest() throws Exception {
		service.remove(3);
	}

	@Test
	public void getListTest() throws Exception {
		System.out.println(service.getList());
	}

}
