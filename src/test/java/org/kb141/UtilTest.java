package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.KmeansTestDAO;
import org.kb141.domain.KmeansTestVO;
import org.kb141.util.Centroid;
import org.kb141.util.KMeansMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilTest {
	
	@Autowired
	private KmeansTestDAO dao;
	
	@Test
	public void algorithm() {
		
//		System.out.println(dao.findByGenderEquals("M"));
		List<KmeansTestVO> arr = dao.findByGenderEquals("M");
		
		KMeansMachine machine = new KMeansMachine(3, arr);
		
		List<Centroid> result = machine.run();
		
		System.out.println(result);
		
		
	}

}
