package org.kb141;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.DeviceAdDAO;
import org.kb141.domain.DeviceAdVO;
import org.kb141.service.DeviceAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceAdTests {

	@Autowired
	private DeviceAdDAO dao;
	
	@Autowired
	private DeviceAdService service;

	@Test
	public void registerTest() throws Exception {
		DeviceAdVO vo = new DeviceAdVO();
		vo.setDno(1);
		vo.setAdno(4);
		service.register(vo);
	}

	@Test
	public void viewFromAdnoTest() throws Exception {
		System.out.println(service.viewFromAdno(6));
	}
	
	@Test
	public void viewFromDnoTest() throws Exception {
		System.out.println(service.viewFromDno(4));
	}
	
	@Test
	public void modifyTest() throws Exception{
		DeviceAdVO vo = new DeviceAdVO();
		vo.setDano(2);
		vo.setAdno(2);
		vo.setDno(4);
		service.modify(vo);
	}
	
	@Test
	public void removeTest() throws Exception{
		service.remove(2);
	}
	
	@Test
	public void listTest() throws Exception{
		System.out.println(service.getList());
	}

	@Test
	public void test() throws Exception{
		System.out.println(dao.findFromAdno(4));
	}

}
