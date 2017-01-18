package org.kb141;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.LogDAO;
import org.kb141.domain.LogVO;
import org.kb141.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogTest {
	
	@Autowired
	private LogDAO dao;
	
	@Autowired
	private LogService logService;
	
	@Test
	public void createTest() {
		
		LogVO vo = new LogVO();
		vo.setDno(10000);
		vo.setAge(100000);
		vo.setGender("M");
		vo.setEmotion_before("SAD");
		vo.setEmotion_after("HAPPY");
		vo.setEmotion_change("SO HAPPY");
		vo.setAdno(1);
		vo.setWatch_time(3);
		
		dao.save(vo);

	}

	
//	---------------------------- TEST SERVICE ----------------------------
	
	@Test
	public void registerTest() {
		LogVO vo = new LogVO() ;
		
		
	}
	
}
