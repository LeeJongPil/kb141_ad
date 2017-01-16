package org.kb141;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.AdDAO;
import org.kb141.domain.AdVO;
import org.kb141.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdTests {

	@Autowired
	private AdDAO adDAO;

	@Autowired
	private AdService adService;
	
	@Test
	public void createTest() {

		AdVO vo = new AdVO();
		vo.setAd_title("test1");
		vo.setCid("test1");
		vo.setCategory("test1");
		vo.setStart_duration(new Date());
		vo.setEnd_duration(new Date());
		vo.setAd_image("test1");
		vo.setAd_video("test1");

		adDAO.save(vo);
	}

	@Test
	public void readTest() {
		System.out.println(adDAO.findOne(1));
	}

	@Test
	public void updateTeset() {
		AdVO vo = new AdVO();
		vo.setAdno(2);
		vo.setAd_title("test");
		vo.setCid("test");
		vo.setCategory("test2");
		vo.setStart_duration(new Date());
		vo.setEnd_duration(new Date());
		vo.setAd_image("test");
		vo.setAd_video("test");
		adDAO.save(vo);
	}

	@Test
	public void deleteTest() {
		adDAO.delete(1);
	}

	@Test
	public void listTest() {
		System.out.println(adDAO.findAll());
	}
	
// ------------------------------------------------------------ Service Test ------------------------------------------------------------ 	

	@Test
	public void registerTest(){
		AdVO vo = new AdVO();
		vo.setAd_title("test1");
		vo.setCid("test1");
		vo.setCategory("test1");
		vo.setStart_duration(new Date());
		vo.setEnd_duration(new Date());
		vo.setAd_image("test1");
		vo.setAd_video("test1");
		
		adService.register(vo);
	}
	
	@Test
	public void viewTest(){
		System.out.println(adService.view(1));
	}

	@Test
	public void modifyTest(){
		AdVO vo = new AdVO();
		vo.setAdno(1);
		vo.setAd_title("test");
		vo.setCid("test");
		vo.setCategory("test2");
		vo.setStart_duration(new Date());
		vo.setEnd_duration(new Date());
		vo.setAd_image("test");
		vo.setAd_video("test");
		adService.modify(vo);
	}
	
	@Test
	public void removeTest(){
		adService.remove(2);
	}
	
	@Test
	public void getFindAllTest(){
		System.out.println(adService.getList());
	}
}

