package org.kb141;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.AdDAO;
import org.kb141.domain.AdVO;
import org.kb141.domain.DeviceAdVO;
import org.kb141.mapper.AdMapper;
import org.kb141.service.AdService;
import org.kb141.util.AdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdTests {

	@Autowired
	private AdDAO adDAO;

	@Autowired
	private AdService adService;
	
	@Autowired
	private AdMapper adMapper;
	
	private AdUtil adUtil = new AdUtil();
	
	@Test
	public void createTest() throws Exception {

		AdVO vo = new AdVO();
		String start = "2017-02-01";
		String end = "2017-02-31";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date newStart = format.parse(start);
		Date newEnd = format.parse(end);
		
		vo.setAd_title("인효키보드");
		vo.setAd_content("인효의 청축 키보드");
		vo.setCid("sih");
		vo.setCategory("B");
		vo.setStart_duration(newStart);
		vo.setEnd_duration(newEnd);
		vo.setAd_image("keyboard");
		vo.setAd_video("keyboard");
		vo.setTarget_area("김포");
		vo.setTarget_emotions("happiness");

		adDAO.save(vo);
	}

	@Test
	public void readTest() {
		System.out.println(adDAO.findOne(3));
	}

	@Test
	public void updateTeset() {
		AdVO vo = new AdVO();
		vo.setAdno(2);
		vo.setAd_title("test");
		vo.setCid("test");
		vo.setCategory("test2");
		vo.setStart_duration(new Date());
		vo.setEnd_duration(new Date());
		vo.setAd_image("test");
		vo.setAd_video("test");
		adDAO.save(vo);
	}

	@Test
	public void deleteTest() {
		adDAO.delete(1);
	}

	@Test
	public void listTest() {
		System.out.println(adDAO.findAll());
	}
	
//	@Test
//	public void listTest2() throws Exception{
//		AdVO vo = new AdVO();
//		
//		List<AdVO> list = adDAO.findAll(vo);
//		
//		for(int i = 0 ; i < list.size(); i++){
//			System.out.println(list.get(i));
//		}
//		
//	}
	
	
// ------------------------------------------------------------ Service Test ------------------------------------------------------------ 	

	@Test
	public void registerTest(){
		AdVO vo = new AdVO();
		vo.setAd_title("test1");
		vo.setCid("test1");
		vo.setCategory("test1");
		vo.setStart_duration(new Date());
		vo.setEnd_duration(new Date());
		vo.setAd_image("test1");
		vo.setAd_video("test1");
		
		adService.register(vo);
	}
	
	@Test
	public void viewTest(){
		System.out.println(adService.view(1));
	}

	@Test
	public void modifyTest(){
		AdVO vo = new AdVO();
		vo.setAdno(1);
		vo.setAd_title("test");
		vo.setCid("test");
		vo.setCategory("test2");
		vo.setStart_duration(new Date());
		vo.setEnd_duration(new Date());
		vo.setAd_image("test");
		vo.setAd_video("test");
		adService.modify(vo);
	}
	
	@Test
	public void removeTest(){
		adService.remove(2);
	}
	
	@Test
	public void getFindAllTest(){
		System.out.println(adService.getList());
	}
	
	@Test
	public void getCountTest() {
		System.out.println(adService.getCount());
	}
	
	@Test
	public  void getAdListCSVTest() {
		List<AdVO> list = adService.getAdListCSV();
		for(int i = 0 ; i < list.size() ; i ++){
			System.out.println(list.get(i));
		}
	}
	
// ------------------------------------------------------------ Mapper Test ------------------------------------------------------------ 	

	@Test
	public void CountADTest() throws Exception{
		System.out.println(adMapper.countAd());
	}
	@Test
	public void mapChecking() throws Exception{
		
		List<DeviceAdVO> list = adMapper. mapChecking(6);
		for(int i = 0 ; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public void ADList() throws Exception{
		List<AdVO> list = adMapper.adListCSV();
		for( int i = 0 ; i < list.size() ; i ++){
			System.out.println(list.get(i));
		}
	}
	
// ------------------------------------------------------------ AD.Util Test ------------------------------------------------------------ 	
	
	@Test
	public void adUtilTest() throws Exception{
//		List<AdVO> list = adUtil.adListWrite(adService.getAdListCSV());
		List<AdVO> list = adUtil.adListWrite();
		
		for(int i = 0 ; i < list.size() ; i ++){
			System.out.println(list.get(i));
		}
		
	}
	
	public void listFromDnoDAOTest() throws Exception{
		System.out.println(adMapper.deviceListFromDno(4));
	}
	
	@Test
	public void listFromDnoServiceTest() throws Exception{
		System.out.println(adService.deviceListFromDno(4));
	}
}

