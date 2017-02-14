package org.kb141.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;

import org.kb141.domain.LogVO;

public enum CsvReaderWriter {

	INSTANCE;

	public void logReader() {
		FileReader fr;
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd HH:mm");

		String result = "";

		try {
			fr = new FileReader("C://zzz//ad/adlog2.csv");
			BufferedReader br = new BufferedReader(fr);
			fr.read();// 리턴값으로 읽어온 char 수를 리턴한다. -1 은 다읽은 거다.

			while (true) {
				if (br.ready() == false) {
					break;
				}
				result += br.readLine() + "/";
				// System.out.println("result -------");
				// System.out.println(result);
			}

			System.out.println(result);

			String[] lines = result.split("/");
			for (int i = 1; i < lines.length; i++) {
				String[] elements = lines[i].split(",");

				LogVO vo = new LogVO();

				vo.setDno(Integer.parseInt(elements[1]));
				// System.out.println("vogetDno : " + vo.getDno());
				vo.setAge(Integer.parseInt(elements[2]));
				vo.setGender(elements[3]);
				vo.setAdno(Integer.parseInt(elements[4]));
				vo.setWatch_time(Integer.parseInt(elements[5]));
				vo.setCurr_time(dateformat.parse((elements[6])));
				
				vo.setBef_happiness(Double.parseDouble(elements[7]));
				vo.setBef_anger(Double.parseDouble(elements[8]));
				vo.setBef_sadness(Double.parseDouble(elements[9]));
				vo.setBef_neutral(Double.parseDouble(elements[10]));
				vo.setBef_surprise(Double.parseDouble(elements[11]));
				vo.setBef_fear(Double.parseDouble(elements[12]));
				vo.setBef_contempt(Double.parseDouble(elements[13]));
				vo.setBef_disgust(Double.parseDouble(elements[14]));
				vo.setAft_happiness(Double.parseDouble(elements[15]));
				vo.setAft_anger(Double.parseDouble(elements[16]));
				vo.setAft_sadness(Double.parseDouble(elements[17]));
				vo.setAft_neutral(Double.parseDouble(elements[18]));
				vo.setAft_surprise(Double.parseDouble(elements[19]));
				vo.setAft_fear(Double.parseDouble(elements[20]));
				vo.setAft_contempt(Double.parseDouble(elements[21]));
				vo.setAft_disgust(Double.parseDouble(elements[22]));
				vo.setRule(elements[23]);
				
				System.out.println(vo);
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void kmeansWriter() {
		
		
		
		
	}
	
	
}
