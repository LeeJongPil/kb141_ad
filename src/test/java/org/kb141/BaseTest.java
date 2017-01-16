package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.BaseDAO;
import org.kb141.domain.BaseVO;
import org.kb141.domain.KmeansVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
	
	@Autowired
	private BaseDAO baseDAO;
	
	@Test
	public void contextLoads() throws Exception {
//		System.out.println(ds);
//		Connection con = ds.getConnection();
//		System.out.println(con);
//		con.close();
	}
	
	@Test
	public void createTest() {
		BaseVO vo = new BaseVO();
		vo.setBage(25);
		vo.setBgender("남");
		vo.setBemotion("베이스감정");
		vo.setB_first("첫번째 추천");
		vo.setB_second("두번째 추천");
		vo.setB_third("세번째 추천");
		baseDAO.save(vo);
		
		System.out.println(baseDAO);
	}
	
	@Test
	public void readTest() {
		BaseVO vo = baseDAO.findOne(1);
		System.out.println("===============================================vo :" + vo +"======================================================");
	}
	
	@Test
	public void updateTest() {
		BaseVO vo = new BaseVO();
		vo.setBage(27);
		vo.setBgender("남1");
		vo.setBemotion("감정1");
		vo.setB_first("첫번째 추천1");
		vo.setB_second("두번째 추천1");
		vo.setB_third("세번째 추천1");
		vo.setBno(2);
		baseDAO.save(vo);
		
		System.out.println(baseDAO);
	}
	
	@Test
	public void deleteTest() {
		baseDAO.delete(2);
		System.out.println(baseDAO);
	}
	
	@Test
	public void listTest() {
		List<BaseVO> list = (List<BaseVO>) baseDAO.findAll();
		for(int i = 0 ; i < list.size(); i ++){
			System.out.println(list.get(i));
		}
		System.out.println(list);
	}
}
