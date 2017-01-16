package org.kb141;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.KmeansDAO;
import org.kb141.domain.KmeansVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KmeansTest {
	
	@Autowired
	private KmeansDAO kmeansDAO;
	
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
		vo.setKage(25);
		vo.setKgender("남");
		vo.setKemotion("감정");
		vo.setK_first("첫번째 추천");
		vo.setK_second("두번째 추천");
		vo.setK_third("세번째 추천");
		kmeansDAO.save(vo);
		
		System.out.println(kmeansDAO);
	}
	
	@Test
	public void readTest() {
		KmeansVO vo = kmeansDAO.findOne(1);
		System.out.println("===============================================vo :" + vo +"======================================================");
	}
	
	@Test
	public void updateTest() {
		KmeansVO vo = new KmeansVO();
		vo.setKage(27);
		vo.setKgender("남1");
		vo.setKemotion("감정1");
		vo.setK_first("첫번째 추천1");
		vo.setK_second("두번째 추천1");
		vo.setK_third("세번째 추천1");
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
}
