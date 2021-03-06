package org.kb141;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.KmeansDAO;
import org.kb141.domain.KmeansVO;
import org.kb141.service.KmeansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KmeansTest {
	
	@Autowired
	private KmeansDAO kmeansDAO;
	
	@Autowired
	private KmeansService kmeansService;
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void contextLoads() throws Exception {
//		System.out.println(ds);
//		Connection con = ds.getConnection();
//		System.out.println(con);
//		con.close();
	}
	
	@Test
	public void createTest() {
		KmeansVO vo = new KmeansVO();
		
		vo.setAge(32.59090909);
		vo.setGender("male");
		vo.setEmotion(0.189363185);
		vo.setAd("neutral_japan.mp4");
		
		kmeansDAO.save(vo);
	}
	
	@Test
	public void readTest() {
		KmeansVO vo = kmeansDAO.findOne(1);
		System.out.println("===============================================vo :" + vo +"======================================================");
	}
	
	@Test
	public void updateTest() {
		KmeansVO vo = new KmeansVO();
		vo.setKno(2);
		kmeansDAO.save(vo);
		
		System.out.println(kmeansDAO);
	}
	
	@Test
	public void deleteTest() {
		kmeansDAO.delete(1);
		System.out.println(kmeansDAO);
	}
	
	@Test
	public void listTest() {
		List<KmeansVO> list = (List<KmeansVO>) kmeansDAO.findAll();
		for(int i = 0 ; i < list.size(); i ++){
			System.out.println(list.get(i));
		}
		System.out.println(list);
	}
	
	//============================================================================== Service ==========================================================
	
	@Test
	public void RegisterTest() {
		KmeansVO vo = new KmeansVO();
		
		vo.setAge(60.46428571);
		vo.setGender("male");
		vo.setEmotion(0.235714286);
		vo.setAd("happy_outback.mp4");
		
		kmeansService.register(vo);
	}
	
	@Test
	public void viewTest() {
		KmeansVO vo = kmeansService.view(3);
		System.out.println("===============================================vo :" + vo +"======================================================");
	}
	@Test
	public void modifyTest() {
		KmeansVO vo = new KmeansVO();
//		vo.setKage(27);
//		vo.setKgender("남1");
//		vo.setKemotion("서비스감정1");
//		vo.setK_first("첫번째 추천1");
//		vo.setK_second("두번째 추천1");
//		vo.setK_third("세번째 추천1");
		vo.setKno(2);
		kmeansService.modify(vo);
		
		System.out.println(kmeansService);
	}
	
	@Test
	public void removeTest() {
		kmeansService.remove(3);
		System.out.println(kmeansDAO);
	}
	
	@Test
	public void getlistTest() {
		List<KmeansVO> list = (List<KmeansVO>) kmeansService.getList();
		for(int i = 0 ; i < list.size(); i ++){
			System.out.println(list.get(i));
		}
		System.out.println(list);
	}
	
}
