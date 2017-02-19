package org.kb141.process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.kb141.domain.AdVO;
import org.kb141.domain.BaseVO;
import org.kb141.domain.KmeansVO;
import org.kb141.domain.LogVO;
import org.kb141.service.AdService;
import org.kb141.service.BaseService;
import org.kb141.service.KmeansService;
import org.kb141.service.LogService;
import org.kb141.util.Centroid;
import org.kb141.util.KMeansMachine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CsvReaderWriter {

	@Autowired
	private LogService logService;

	@Autowired
	private BaseService baseService;

	@Autowired
	private KmeansService kmeansService;

	@Autowired
	private AdService adService;
	
	@Autowired

	public void logReader() {
		try {
			FileReader fr;
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd HH:mm");

			String result = "";

			fr = new FileReader("C://zzz//ad/adlog2.csv");
			BufferedReader br = new BufferedReader(fr);
			fr.read();// 리턴값으로 읽어온 char 수를 리턴한다. -1 은 다읽은 거다.

			while (true) {
				if (br.ready() == false) {
					break;
				}
				result += br.readLine() + "/";
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

				logService.register(vo);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void baseWriter() {
		try {
			List<BaseVO> list = baseService.getList();

			FileWriter fw;
			fw = new FileWriter("C://zzz//ad//rule_example7.csv");

			fw.write("number,age,gender,emotion,area,ad,date\r\n");
			for (BaseVO baseVO : list) {
				fw.write(baseVO.getCsvString());
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void kmeansWriter() {
		try {
			List<LogVO> arr = logService.getList();
			List<LogVO> maleArr = new ArrayList();
			List<LogVO> femaleArr = new ArrayList();

			for (LogVO logVO : arr) {
				if (logVO.getGender().equals("M")) {
					maleArr.add(logVO);
				} else {
					femaleArr.add(logVO);
				}
			}

			KMeansMachine machine1 = new KMeansMachine(3, maleArr);
			List<Centroid> result = machine1.run();

			KMeansMachine machine2 = new KMeansMachine(3, femaleArr);
			result.addAll(machine2.run());

			// // 자동으로 뭘 말 하는 건가.
			System.out.println(result);

			List<AdVO> adList = adService.getList();

			FileWriter fw;
			fw = new FileWriter("C://zzz//ad//kmeans_example7.csv");
			fw.write("number,age,gender,emotion,area,ad,date\r\n");

			for (int i = 0; i < result.size(); i++) {
				KmeansVO kmeansVO = new KmeansVO();
				Centroid current = result.get(i);
				String currentAd = "";
				for (AdVO adVO : adList) {
					if (current.getAdno() == adVO.getAdno()) {
						currentAd = adVO.getAd_video();
						break;
					}
				}
				fw.write("" + (i + 1) + "," + current.getmX() + "," + (i < 3 ? "male" : "female") + ","
						+ current.getmY() + "," + "" + "," + currentAd + "," + "\r\n");
				
				kmeansVO.setKno(i+1);
				kmeansVO.setAd(currentAd);
				kmeansVO.setAge(current.getmX());
				kmeansVO.setEmotion(current.getmY());
				kmeansVO.setGender((i < 3 ? "male" : "female"));
				kmeansService.modify(kmeansVO);
			}

			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listWriter() {
		try {
			List<AdVO> list = adService.getList();

			FileWriter fw;
			fw = new FileWriter("C://zzz//ad//list7.csv");

			fw.write("adno,image,video\r\n");
			for (AdVO adVO : list) {
				fw.write(adVO.getCsvString());
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
