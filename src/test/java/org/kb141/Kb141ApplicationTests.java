package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.BoardDAO;
import org.kb141.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Kb141ApplicationTests {
	
	@Autowired
	private BoardDAO boardDAO;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void listTest() {
		List<BoardVO> list = (List<BoardVO>) boardDAO.findAll();
		for(int i = 0 ; i < list.size(); i ++){
			System.out.println(list.get(i));
		}
		System.out.println(list);
		
	}

}
