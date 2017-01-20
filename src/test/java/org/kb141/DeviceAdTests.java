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
	private DeviceAdService service;

	@Test
	public void registerTest() throws Exception {
		DeviceAdVO vo = new DeviceAdVO();
		vo.setDno(4);
		vo.setAdno(2);
		service.register(vo);
	}

	@Test
	public void readTest() throws Exception {

	}

}
