package org.kb141.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.kb141.domain.LogVO;

public class LogCSVWrite {

	public String logCSV(String text){
		
		String log = "";
		
		String array[] = text.split("\n");
		
//		for(int i = 0; i < array.length; i++){
//			System.out.println("array"+i  + ":" + array[i]);
//		}
		
		// , 로 구분지어서 엑셀로 써줘야지 컬럼별로 들어가진다.   for문으로 돌린다. 
		// 그럼 먼저 길이를 알아야 한다. 
		// split로 구분지어서 길이를 알아내면 끝 ~ 
		
		FileWriter fw;
		try {
			fw = new FileWriter("C://zzz//loglog.csv");
			// csv 파일로 쓰고 " 를 다 공백으로 처리 해서 다시 저장한다음 디비에 넣을 것이다.
			
			for(int i = 0; i < array.length; i++){
				fw.write(array[i]+"\r\n");	// csv 파일에 한줄 넘기면서 한줄씩 저장한다.
				log += array[i].replaceAll("\"", "") + "  ";
			}
			fw.close();
			System.out.println("log CSV write success.....................");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("log CSV write fail.....................");
		}
		return log;
	}
	
	
	
	public LogVO logDB(String erd[]){
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String csa[] = erd;
		LogVO vo = new LogVO() ;
		
			try {
						vo.setDno(Integer.parseInt(csa[0]));
						System.out.println("vogetDno : " + vo.getDno());
						vo.setAge(Integer.parseInt(csa[1]));
						vo.setGender(csa[2]);
						vo.setAdno(Integer.parseInt(csa[3]));
						vo.setWatch_time(Integer.parseInt(csa[4]));
						vo.setCurr_time(dateformat.parse((csa[5])));
						vo.setBef_happiness(Double.parseDouble(csa[6]));
						vo.setBef_anger(Double.parseDouble(csa[7]));
						vo.setBef_sadness(Double.parseDouble(csa[8]));
						vo.setBef_neutral(Double.parseDouble(csa[9]));
						vo.setBef_surprise(Double.parseDouble(csa[10]));
						vo.setBef_fear(Double.parseDouble(csa[11]));
						vo.setBef_contempt(Double.parseDouble(csa[12]));
						vo.setBef_disgust(Double.parseDouble(csa[13]));
						vo.setAft_happiness(Double.parseDouble(csa[14]));
						vo.setAft_anger(Double.parseDouble(csa[15]));
						vo.setAft_sadness(Double.parseDouble(csa[16]));
						vo.setAft_neutral(Double.parseDouble(csa[17]));
						vo.setAft_surprise(Double.parseDouble(csa[18]));
						vo.setAft_fear(Double.parseDouble(csa[19]));
						vo.setAft_contempt(Double.parseDouble(csa[20]));
						vo.setAft_disgust(Double.parseDouble(csa[21]));
						vo.setRule(csa[22]);
						System.out.println("VO 반환 성공");
			}catch (ParseException e) {
				e.printStackTrace();
			}
			return vo;
		}
		
	}
	
