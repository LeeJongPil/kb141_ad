package org.kb141;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.LogDAO;
import org.kb141.domain.LogVO;
import org.kb141.mapper.LogMapper;
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
	private LogService service;
	
	@Autowired
	private LogMapper logMapper;
	
	
	@Test
	public void createTest() {
		
		LogVO vo = new LogVO();
		vo.setDno(10);
		vo.setAge(20);
		vo.setGender("M");
//		vo.setEmotion_before("SAD");
//		vo.setEmotion_after("HAPPY");
//		vo.setEmotion_change("SO HAPPY");
		vo.setAdno(1);
		vo.setWatch_time(3);
		
		dao.save(vo);

	}
	@Test
	public void putDummyData() throws ParseException {
		String from = "2017-02-09 10:10:10";

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date to = transFormat.parse(from);
		Random rand = new Random();
		
		for(int i = 0 ; i < 15 ; i++ ){
			LogVO vo = new LogVO();
			vo.setDno(4);
			vo.setAge(rand.nextInt(70)+ 10);
			vo.setGender(rand.nextBoolean() == true ? "M" : "F");
			vo.setAdno(rand.nextInt(4) + 1);
			vo.setWatch_time(rand.nextInt(20) + 1);
			vo.setCurr_time(to);
			
			vo.setBef_anger(rand.nextDouble());
			vo.setBef_contempt(rand.nextDouble());
			vo.setBef_disgust(rand.nextDouble());
			vo.setBef_fear(rand.nextDouble());
			vo.setBef_happiness(rand.nextDouble());
			vo.setBef_neutral(rand.nextDouble());
			vo.setBef_sadness(rand.nextDouble());
			vo.setBef_surprise(rand.nextDouble());
			
			vo.setAft_anger(rand.nextDouble());
			vo.setAft_contempt(rand.nextDouble());
			vo.setAft_disgust(rand.nextDouble());
			vo.setAft_fear(rand.nextDouble());
			vo.setAft_happiness(rand.nextDouble());
			vo.setAft_neutral(rand.nextDouble());
			vo.setAft_sadness(rand.nextDouble());
			vo.setAft_surprise(rand.nextDouble());
			
			int curr = rand.nextInt(3);
			vo.setRule(curr == 0 ? "BASE" : curr == 1 ? "KMEANS" : "CURR");
			
			dao.save(vo);
		}
	}
	
	@Test
	public void readTest() {
		System.out.println(dao.findOne(1));
		
	}
	
	
	@Test
	public void updateTest() {
		
		LogVO vo = new LogVO();
		vo.setDno(2);
		vo.setAge(3);
		vo.setGender("F");
//		vo.setEmotion_before("SADDDDDDDDD");
//		vo.setEmotion_after("HAPPYYYYYYYYY");
//		vo.setEmotion_change("SO HAPPYYYYYYYYYY");
		vo.setAdno(1);
		vo.setWatch_time(3);
		vo.setLno(1);
		dao.save(vo);
	}
	
	@Test
	public void deleteTest() {
		dao.delete(2);
	}
	
	@Test
	public void listTest() {
		dao.findAll();
	}
	
	@Test
	public void registerTest() {
		LogVO vo = new LogVO();
		vo.setDno(100);
		vo.setAge(30);
		vo.setGender("F");
//		vo.setEmotion_before("SAD");
//		vo.setEmotion_after("HAPPY");
//		vo.setEmotion_change("SO HAPPY");
		vo.setAdno(1);
		vo.setWatch_time(6);
		
		service.register(vo);
	}
	
	@Test
	public void viewTest() {
		System.out.println(service.view(1));
	}
	
	@Test
	public void modifyTest() {
		LogVO vo = new LogVO();
		vo.setDno(2);
		vo.setAge(3);
		vo.setGender("F");
//		vo.setEmotion_before("SADDDDDDDDD");
//		vo.setEmotion_after("HAPPYYYYYYYYY");
//		vo.setEmotion_change("SO HAPPYYYYYYYYYY");
		vo.setAdno(1);
		vo.setWatch_time(3);
		vo.setLno(4);
		service.modify(vo);
	}
	
	@Test
	public void removeTest() {
		service.remove(4);
	}
	
	@Test
	public void getListTest() {
		System.out.println(service.getList());
	}

	@Test
	public void getCountLog(){
		System.out.println(service.countLog());
	}
	
	@Test
	public void getAdviewershipTest(){
		System.out.println(service.getAdviewership());
	}
	
	@Test
	public void getListByAdnoTest() {
		System.out.println(dao.findByAdno(4));
	}
	
//------------------------------Mapper Test------------------------------

	@Test
	public void CountLogTest() throws Exception {
		System.out.println(logMapper.countLog());
	}
	
	@Test
	public void AdviewershipTest() throws Exception{
		System.out.println(logMapper.Adviewership());
	}
	
	@Test
	public void getDateViewTest() throws Exception {
		System.out.println(logMapper.getDateView());
	}
	
	@Test
	public void timeCalcTest() throws Exception {
		Calendar cal = Calendar.getInstance();
		
		Date date = service.view(25).getCurr_time();
		
		cal.setTime(date);

		System.out.println(cal.get(Calendar.HOUR));
		
	}
	
	@Test
	public void getClientListTest() throws Exception{
		System.out.println(service.getClientList("lsy").size());
	}
}