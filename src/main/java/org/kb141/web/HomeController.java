package org.kb141.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.apache.log4j.Logger;
import org.kb141.domain.KmeansTestVO;
import org.kb141.domain.KmeansVO;
import org.kb141.service.KmeansService;
import org.kb141.service.KmeansTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/")
	public String index() {
		logger.info("YHJ IS COMING");
		return "hello YHJ!";
	}
	
	@RequestMapping(value="/rulebase" , produces="application/json")
	public JSONObject rulebase() throws Exception  {
		System.out.println("rulebase start");
		
		JSONObject obj = new JSONObject();
		FileReader fr = new FileReader("C://zzz//test.csv");
		BufferedReader br = new BufferedReader(fr);
		
		fr.read();	// 리턴값으로 읽어온 char 수를 리턴한다. -1 은 다읽은 거다.
		
		String result = "";
		
		while(true){
			if(br.ready() == false){
				break;
			}
			result += br.readLine() + " ";
			System.out.println("result -------");
			System.out.println(result);
		}
		
		obj.put("json", '"'+ result);
		
		System.out.println(result);
		System.out.println(obj);
		System.out.println("json : " + obj.toString() );
		System.out.println(obj.get("json"));
		String[] ree = obj.toString().split(" ");
		System.out.println(ree[1]);
//		KmeansVO vo = new KmeansVO();
//		kmeansService.register(vo);
		return obj;
	}
	
	@RequestMapping("/test/{gender}")
	public List<KmeansTestVO> genderTest(@PathVariable(name="gender") String gender) {
		logger.info("GENDER IS : " + gender);
		return service.getGenderList(gender);
	}
	
	@RequestMapping(value="/base" , produces="application/json")
	public void base() throws Exception  {
		System.out.println("base start");
		
		KmeansVO vo = new KmeansVO();
		FileReader fr = new FileReader("C://zzz//test.csv");
		BufferedReader br = new BufferedReader(fr);
		
		fr.read();	// 리턴값으로 읽어온 char 수를 리턴한다. -1 은 다읽은 거다.
		System.out.println("br " + br);
		String result = "";
		
		while(true){
			if(br.ready() == false){
				break;
			}
			result += br.readLine().replaceAll("\"", "") + " ";
//			System.out.println("result -------");
//			System.out.println(result);
		}
		String arr[] = result.split(" ");
		System.out.println("result : " +result);
		System.out.println(arr[1]);

		String aee[] = arr[1].split(",");
		
		System.out.println(aee[1]);
//		System.out.println(Integer.parseInt(aee[1].replaceAll("\"","")));
//		
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
