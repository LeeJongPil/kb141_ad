package org.kb141;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import javax.websocket.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.LogDAO;
import org.kb141.domain.LogVO;
import org.kb141.process.CsvReaderWriter;
import org.kb141.process.ScheduledTasks;
import org.kb141.service.LogService;
import org.kb141.util.Centroid;
import org.kb141.util.KMeansMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableScheduling
public class UtilTest {
	
	@Autowired
	private LogDAO dao;
	
	@Autowired
	private LogService logService;
	
	@Test
	public void algorithm() {
		
//		System.out.println(dao.findByGenderEquals("M"));
		List<LogVO> arr = dao.findByGenderEquals("M");
		
		KMeansMachine machine = new KMeansMachine(3, arr);
		
		List<Centroid> result = machine.run();
		
		System.out.println(result);
		
		
	}
	
	@Autowired
	private ScheduledTasks tasks;
	
	
//	@Test
//	public void scheduleTest() {
//		tasks.reportCurrentTime();
//	}
	
	@Autowired
	private CsvReaderWriter crw;
	
	@Test
	public void csvReader1() {
		crw.logReader();
	}
	
	@Test
	public void csvReader2() {
		crw.baseWriter();
	}
	
	@Test
	public void csvWriter() {
		crw.kmeansWriter();
	}
	
	@Test
	public void csvWriter2() {
		List<LogVO> maleArr = logService.getListByGender("M");
		List<LogVO> femaleArr = logService.getListByGender("F");
		KMeansMachine machine1 = new KMeansMachine(3, maleArr);
		List<Centroid> result = machine1.run();
		
//		System.out.println(femaleArr);
		KMeansMachine machine2 = new KMeansMachine(3, femaleArr);
		result.addAll(machine2.run());
		
//		// 자동으로 뭘 말 하는 건가. 
		System.out.println(result);	
	}

}
