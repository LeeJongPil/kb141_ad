package org.kb141;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.DeviceAdDAO;
import org.kb141.domain.DeviceAdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceAdTests {

	@Autowired
	private DeviceAdDAO dao;
	
	@Test
	public void createTest() throws Exception{
		DeviceAdVO vo = new DeviceAdVO();
		vo.setDno(3);
		vo.setAdno(6);
		dao.save(vo);
	} 
	
	
}
