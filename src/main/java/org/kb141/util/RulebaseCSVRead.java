package org.kb141.util;

import java.io.BufferedReader;
import java.io.FileReader;

import net.sf.json.JSONObject;

public class RulebaseCSVRead {

	private JSONObject obj = new JSONObject();
	
	public JSONObject rulebaseCSV(){
		
		try {
			FileReader fr = new FileReader("C://zzz//Rulebase.csv");
			BufferedReader br = new BufferedReader(fr);
			fr.read();// 리턴값으로 읽어온 char 수를 리턴한다. -1 은 다읽은 거다.
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	
	
}
