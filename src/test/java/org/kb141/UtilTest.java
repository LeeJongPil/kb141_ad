package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.LogDAO;
import org.kb141.domain.LogVO;
import org.kb141.process.CsvReaderWriter;
import org.kb141.process.ScheduledTasks;
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
	
	
	@Test
	public void scheduleTest() {
		tasks.reportCurrentTime();
	}
	
	@Test
	public void csvReader1() {
		
		CsvReaderWriter.INSTANCE.logReader();		
		
	}
	
	@Test
	public void csvReader2() {
		CsvReaderWriter.INSTANCE.kmeansWriter();
	}

}
