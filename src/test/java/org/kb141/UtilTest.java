package org.kb141;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.LogDAO;
import org.kb141.domain.LogVO;
import org.kb141.process.CsvReaderWriter;
import org.kb141.process.ScheduledTasks;
import org.kb141.service.LogService;
import org.kb141.util.Centroid;
import org.kb141.util.KMeansMachine;
import org.kb141.web.PersonController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	
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
	public void csvWriter3() {
		crw.listWriter();
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
	
	
	@Test
	public void File()throws Exception{
		File file = new File("C:/zzz/ad/list.csv");
		
		if(file.exists()){
			
			FileInputStream fis = new FileInputStream(file);
			int i ; 
			
				while((i = fis.read()) != -1){
					System.out.println((char) i);
				}
			
			fis.close();
		}
		else{
			System.out.println("해당 파일이 없습니다.");
		}
		
	}
	
	@Test
	public void mimeType(){
		
		File file = new File("C:/zzz/upload/images5");
		System.out.println(new MimetypesFileTypeMap().getContentType(file));
	}
	
	@Test
	public void fileToString()throws Exception{
	
		FileInputStream fis = new FileInputStream("C:/zzz/ad/list.csv");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String line = "";
		
		try{
			while((line = br.readLine()) != null){
				String[] splitData = line.split(",");
				
			}
			
			
		}catch(Exception e){
			
		}
			
		
	}
	
	
	

}
