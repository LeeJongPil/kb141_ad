package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.DeviceDAO;
import org.kb141.domain.DeviceListVO;
import org.kb141.domain.DeviceVO;
import org.kb141.mapper.DeviceMapper;
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

	@Autowired
	private DeviceMapper deviceMapper;
	
	@Test
	public void createTest() throws Exception {
		DeviceVO vo = new DeviceVO();
		vo.setDno(1);
		vo.setState("서울");
		vo.setCity("서초");
		vo.setLat(37.4945732);
		vo.setLng(127.0272646);
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

	//----------------------------------------- service Test -----------------------------------------------

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
	
	@Test
	public void getDevListTEst() throws Exception{
		List<DeviceListVO> list = service.getDevList();
		
		for(int i = 0 ; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
/*	@Test
	public void getClientDevListTest() throws Exception{
		service.getClientDevList();
		
	}*/
	
	
//	---------------------------------------- Mapper Test --------------------------------------------------
	
	@Test
	public void getDevList() throws Exception{
		List<DeviceListVO> list = deviceMapper.devList();
		for(int i = 0 ; i < list.size(); i ++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void getLastDno() throws Exception{
		System.out.println(deviceMapper.lastDno());
	}
	
	@Test
	public void getLastDno2() throws Exception{
		System.out.println(service.getLastDno());
	}

	@Test
	public void getClientTest() throws Exception{
		List<DeviceVO> list = deviceMapper.getClientCount("lsy");
		for(int i = 0 ; i < list.size(); i ++){
			System.out.println(list.get(i));
		}
	}
	
/*	@Test
	public void clientDevListTest() throws Exception{
		List<DeviceListVO> list = deviceMapper.clientDevList();
		for(int i = 0 ; i < list.size(); i ++){
			System.out.println(list.get(i));
		}
	}*/
}
