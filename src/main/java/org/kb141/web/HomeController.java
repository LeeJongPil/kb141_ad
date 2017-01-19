package org.kb141.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.apache.log4j.Logger;
import org.kb141.domain.KmeansTestVO;
import org.kb141.domain.KmeansVO;
import org.kb141.service.KmeansService;
import org.kb141.service.KmeansTestService;
import org.kb141.service.LogService;
import org.kb141.util.KmeansCSVRead;
import org.kb141.util.LogCSVWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;


@CrossOrigin
@RestController
public class HomeController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private KmeansTestService service;
	
	@Autowired
	private KmeansService kmeansService;
	
	@Autowired
	private LogService logService;
	
	@RequestMapping("/")
	public String index() {
		logger.info("YHJ IS COMING");
		return "hello YHJ!";
	}
	
	
	// CSV 파일 저장되어있는것을 읽어와서 JSONObject 에 담아서 리턴해준다. 
	// JS 에서 JSON으로 받는다. 
	@RequestMapping(value="/kmeans" , produces="application/json")
	public JSONObject rulebase() throws Exception  {
		System.out.println("rulebase start");
		
		KmeansCSVRead kmeans = new KmeansCSVRead();
		
		return kmeans.kmeansCSV();
	}
	
	
	
	@RequestMapping("/test/{gender}")
	public List<KmeansTestVO> genderTest(@PathVariable(name="gender") String gender) {
		logger.info("GENDER IS : " + gender);
		return service.getGenderList(gender);
	}
	
	
	
	// CSV 파일 저장되어있는것을 읽어와서 DB에 넣는 코드 
	@RequestMapping(value="/base" , produces="application/json")
	public void base() throws Exception  {
		System.out.println("base start");
		
		FileReader fr = new FileReader("C://zzz//Kmeans.csv");
		BufferedReader br = new BufferedReader(fr);
		
		fr.read();	// 리턴값으로 읽어온 char 수를 리턴한다. -1 은 다읽은 거다.
		String result = "";
		
		while(true){
			if(br.ready() == false){
				break;
			}
			result += br.readLine().replaceAll("\"", "") + " ";
		}
		System.out.println("result : " +result);
		
		String arr[] = result.split(" ");	// 첫줄은 헤더니까 1부터 시작해서 파싱 시작해줘야한다. 
															// 모든것을 읽어서 띄어쓰기로 나눠서 배열로 넣어두었다.
		
		String aee[]={};
		System.out.println("arr 길이 : " + arr.length);
		
		for(int i = 1; i < arr.length; i ++){
			System.out.println(arr[i]);
			aee = arr[i].split(",");
			KmeansVO vo = new KmeansVO();
			vo.setKage(Integer.parseInt(aee[1]));
			vo.setKgender(aee[2]);
			vo.setKemotion(aee[3]);
			vo.setK_first(aee[4]);
			vo.setK_second(aee[5]);
			vo.setK_third(aee[6]);
			vo.setKarea(aee[7]);
			kmeansService.register(vo);
		}

	}
	
	
	
	// JS 에서 오는 LOG파일을 CSV를 만들고 DB에 넣는다. 
	@RequestMapping(value="/log", method=RequestMethod.POST)
	public void filepush(String text) throws Exception {

//		logger.info("text : " + text);
	
//		String array[] = text.split("\n");
//		
//		for(int i = 0; i < array.length; i++){
//			logger.info("array"+i  + ":" + array[i]);
//		}
//		
//		// , 로 구분지어서 엑셀로 써줘야지 컬럼별로 들어가진다.   for문으로 돌린다. 
//		// 그럼 먼저 길이를 알아야 한다. 
//		// split로 구분지어서 길이를 알아내면 끝 ~ 
//		
//		// JS에서 받은 log 들을 DB로 넣기
//		
//		FileWriter fw = new FileWriter("C://zzz//loglog.csv");
//		
//		String log = "";
//		
//		// csv 파일로 쓰고 " 를 다 공백으로 처리 해서 다시 저장한다음 디비에 넣을 것이다.
//		
//		for(int i = 0; i < array.length; i++){
//			fw.write(array[i]+"\r\n");	// csv 파일에 한줄 넘기면서 한줄씩 저장한다.
//				log += array[i].replaceAll("\"", "") + "  ";
//			}
//		
//		fw.close();
//		
//		// 쓰는거 끝 
//		
//		logger.info(log);
//		
//		String res[] = log.split("  ");
//		
//		for(int i = 0; i < res.length; i ++){
//			logger.info("res " + i +" : " + res[i] );
//		}
//		
//		
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//		String csa[] = {};
//		
//		for(int i = 1; i < res.length; i ++){
//			csa = res[i].split(",");
//			LogVO vo = new LogVO();
//			vo.setDno(Integer.parseInt(csa[0]));
//			vo.setAge(Integer.parseInt(csa[1]));
//			vo.setGender(csa[2]);
//			vo.setAdno(Integer.parseInt(csa[3]));
//			vo.setWatch_time(Integer.parseInt(csa[4]));
//			vo.setCurr_time(dateformat.parse((csa[5])));
//			vo.setBef_happiness(Double.parseDouble(csa[6]));
//			vo.setBef_anger(Double.parseDouble(csa[7]));
//			vo.setBef_sadness(Double.parseDouble(csa[8]));
//			vo.setBef_neutral(Double.parseDouble(csa[9]));
//			vo.setBef_surprise(Double.parseDouble(csa[10]));
//			vo.setBef_fear(Double.parseDouble(csa[11]));
//			vo.setBef_contempt(Double.parseDouble(csa[12]));
//			vo.setBef_disgust(Double.parseDouble(csa[13]));
//			vo.setAft_happiness(Double.parseDouble(csa[14]));
//			vo.setAft_anger(Double.parseDouble(csa[15]));
//			vo.setAft_sadness(Double.parseDouble(csa[16]));
//			vo.setAft_neutral(Double.parseDouble(csa[17]));
//			vo.setAft_surprise(Double.parseDouble(csa[18]));
//			vo.setAft_fear(Double.parseDouble(csa[19]));
//			vo.setAft_contempt(Double.parseDouble(csa[20]));
//			vo.setAft_disgust(Double.parseDouble(csa[21]));
//			vo.setRule(csa[22]);
//			
//			logService.register(vo);
//		}
		
		LogCSVWrite logwrite = new LogCSVWrite();
		
		String log = logwrite.logCSV(text);
		// 로그 들을 String 한줄로 다 붙여버린다. 
	
		String res[] = log.split("  ");
		String csa[] = {};
		
		for(int i = 1; i < res.length; i ++){
			csa = res[i].split(",");
			logService.register(logwrite.logDB(csa));
			System.out.println("log go to DB ..................");
		}
		
	}
	
	
}
