package org.kb141.web;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;


@CrossOrigin
@RestController
public class HomeController {
	@RequestMapping("/")
	public String index() {
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
		
		return obj;
	}
	
}
