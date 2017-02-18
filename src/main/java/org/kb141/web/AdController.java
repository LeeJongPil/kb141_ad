package org.kb141.web;

import java.util.List;

import org.kb141.domain.AdDeviceVO;
import org.kb141.domain.AdVO;
import org.kb141.domain.DeviceVO;
import org.kb141.domain.LogVO;
import org.kb141.service.AdService;
import org.kb141.service.DeviceService;
import org.kb141.service.KmeansService;
import org.kb141.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//github.com/LeeJongPil/kb141_ad.git
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * ad, device, log
 */

@Controller
@CrossOrigin
public class AdController {

	private static final Logger logger = LoggerFactory.getLogger(AdController.class);

	@Autowired
	private AdService adService;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private LogService logService;

	@Autowired
	private KmeansService kmeansService;

	/*
	 * AD CRUD START
	 */

	@GetMapping("/registerAd")
	public void registerAdGET() throws Exception {
		logger.info("GET AD Register....");
	}

	@PostMapping("/registerAd")
	public String registerAdPOST(AdVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST AD Register....");
		logger.info("POST : " + vo);

		adService.register(vo);
		model.addAttribute("result", "success");
		return "redirect:list";
	}

	@GetMapping("/viewAd")
	public void viewAd(@RequestParam("adno") Integer adno, Model model) throws Exception {
		logger.info("GET AD View....");
		logger.info("adno: " + adno);

		model.addAttribute(adService.view(adno));
		logger.info("result: " + adService.view(adno));
	}

	@GetMapping("/listAd")
	public void listAdmin(Model model) throws Exception {
		logger.info("GET AD List....");
		model.addAttribute(adService.getList());
		logger.info("result: " + adService.getList());
	}

	@PostMapping("/removeAd")
	public String removeAd(@RequestParam("adno") Integer adno, RedirectAttributes rttr) throws Exception {
		logger.info("GET MESSAGE Remove....");
		logger.info("mno: " + adno);
		adService.remove(adno);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:list";
	}

	@GetMapping("/modifyAd")
	public void modifyAdGET(@RequestParam("adno") Integer adno, Model model) throws Exception {
		logger.info("GET MESSAGE Modify....");
		model.addAttribute(adService.view(adno));
	}

	@PostMapping("/modifyAd")
	public String modifyAdPOST(AdVO vo, @RequestParam(value="value") String value,RedirectAttributes rttr) throws Exception {
		logger.info("POST MESSAGE Modify....");
		logger.info(value);
		adService.modify(vo);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/list";
	}
	////////////////////////////////////////////////////////////////////////////////////

	/*
	 * DEVICE CRUD START
	 */

	@GetMapping("admin/device/register")
	public void registerDeviceGET(Model model) throws Exception {
		logger.info("GET DEVICE Register....");
		model.addAttribute("lastDno", deviceService.getLastDno());
	}

	@PostMapping("admin/device/register")
	public String registerDevicePOST(DeviceVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST DEVICE Register....");
		logger.info("POST: " + vo);
		rttr.addFlashAttribute("msg", "success");
		deviceService.register(vo);

		return "redirect:map";
	}

	@GetMapping("admin/device/view")
	public void viewDevice(@RequestParam("dno") Integer dno, Model model) throws Exception {
		logger.info("GET DEVICE View....");
		logger.info("dno: " + dno);

		model.addAttribute(deviceService.view(dno));
		logger.info("result: " + deviceService.view(dno));
	}

	@GetMapping("admin/device/map")
	public void listDevice(Model model) throws Exception {
		logger.info("GET DEVICE List....");
		model.addAttribute("device", deviceService.getList());
		logger.info("result: " + deviceService.getList());
	}

	@ResponseBody
	@GetMapping("admin/device/adFromDevice/{dno}")
	public ResponseEntity<List<AdDeviceVO>> adFromDevice(@PathVariable("dno") Integer dno) {
		logger.info("GET ADLIST");
		ResponseEntity<List<AdDeviceVO>> entity = null;
		try {
			entity = new ResponseEntity<>(adService.deviceListFromDno(dno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@ResponseBody
	@GetMapping("admin/device/info/{dno}")
	public ResponseEntity<DeviceVO> infoDevice(@PathVariable("dno") Integer dno) {
		logger.info("GET ADLIST");
		ResponseEntity<DeviceVO> entity = null;
		try {
			entity = new ResponseEntity<>(deviceService.view(dno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@PostMapping("admin/device/remove")
	public String removeDevice(@RequestParam("dno") Integer dno, RedirectAttributes rttr) throws Exception {
		logger.info("GET DEVICE Remove....");
		logger.info("dno: " + dno);
		deviceService.remove(dno);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:map";
	}

	// @GetMapping("/modifyDevice")
	// public void modifyDeviceGET(@RequestParam("dno") Integer dno, Model
	// model) throws Exception {
	// logger.info("GET DEVICE Modify....");
	// model.addAttribute(deviceService.view(dno));
	// }
	//
	// @PostMapping("/modifyDevice")
	// public String modifyDevicePOST(DeviceVO vo, RedirectAttributes rttr)
	// throws Exception {
	// logger.info("POST DEVICE Modify....");
	// deviceService.modify(vo);
	//
	// rttr.addFlashAttribute("msg", "success");
	// return "redirect:/list";
	// }
	////////////////////////////////////////////////////////////////////////////////////

	/*
	 * LOG CRL START
	 */

	@GetMapping("/registerLog")
	public void registerLogGET() throws Exception {
		logger.info("GET LOG Register....");
	}

	@PostMapping("/registerLog")
	public String registerLogPOST(LogVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST LOG Register....");
		logger.info("POST: " + vo);
		// rttr.addFlashAttribute("msg","success");
		logService.register(vo);

		model.addAttribute("result", "success");
		return "redirect:list";
	}

	@GetMapping("/viewLog")
	public void viewLog(@RequestParam("lno") Integer lno, Model model) throws Exception {
		logger.info("GET LOG View....");
		logger.info("lno: " + lno);

		model.addAttribute(logService.view(lno));
		logger.info("result: " + logService.view(lno));
	}

	@GetMapping("/listLog")
	public void listLog(Model model) throws Exception {
		logger.info("GET LOG List....");
		model.addAttribute(logService.getList());
		logger.info("result: " + logService.getList());
	}

	////////////////////////////////////////////////////////////////////////////////////

	/*
	 * LOG UTIL
	 */

//		
//		/*	// CSV 파일 저장되어있는것을 읽어와서 JSONObject 에 담아서 리턴해준다.
//		// JS 에서 JSON으로 받는다.
//		@RequestMapping(value = "/kmeans", produces = "application/json")
//		public JSONObject rulebase() throws Exception {
//			System.out.println("rulebase start");
//			KmeansCSVRead kmeans = new KmeansCSVRead();
//			return kmeans.kmeansCSV();
//		}*/
//		
//		@RequestMapping(value="/rulebase" , produces="application/json")
//		public JSONObject rulebaseList() throws Exception  {
//			System.out.println("RuleBase Start");
//			RulebaseCSVRead rulebase = new RulebaseCSVRead();
//			return rulebase.rulebaseCSV();
//		}
//		
//		
//
//	// CSV 파일 저장되어있는것을 읽어와서 DB에 넣는 코드
//	// Kmeans 돌려서 나오는 걸 DB에 넣고 CSV 를 만든다.
//	@RequestMapping(value = "/base", produces = "application/json")
//	public void base() throws Exception {
//		System.out.println("base start");
//
//		FileReader fr = new FileReader("C://zzz//Kmeans.csv");
//		BufferedReader br = new BufferedReader(fr);
//
//		fr.read(); // 리턴값으로 읽어온 char 수를 리턴한다. -1 은 다읽은 거다.
//		String result = "";
//
//		while (true) {
//			if (br.ready() == false) {
//				break;
//			}
//			result += br.readLine().replaceAll("\"", "") + " ";
//		}
//		System.out.println("result : " + result);
//
//		String arr[] = result.split(" "); // 첫줄은 헤더니까 1부터 시작해서 파싱 시작해줘야한다.
//											// 모든것을 읽어서 띄어쓰기로 나눠서 배열로 넣어두었다.
//
//		String aee[] = {};
//		System.out.println("arr 길이 : " + arr.length);
//
//		for (int i = 1; i < arr.length; i++) {
//			System.out.println(arr[i]);
//			aee = arr[i].split(",");
//			KmeansVO vo = new KmeansVO();
//			vo.setKage(Integer.parseInt(aee[1]));
//			vo.setKgender(aee[2]);
//			vo.setKemotion(aee[3]);
//			vo.setK_first(aee[4]);
//			vo.setK_second(aee[5]);
//			vo.setK_third(aee[6]);
//			vo.setKarea(aee[7]);
//			kmeansService.register(vo);
//		}
//
//	}
//	
//
//	// JS에 광고 리스트를 보내줘야 하는 기능 구현 해야 한다.
//	@RequestMapping(value = "/adlist", produces = "application/json")
//	public void ADList() throws Exception {
//
//	}
	
	
	
	// // JS 에서 오는 LOG파일을 CSV를 만들고 DB에 넣는다.
	@RequestMapping(value = "/log", method = RequestMethod.POST)
	public void filepush(MultipartFile file) throws Exception {
		logger.info("log Start....................................");
		logger.info("file" + file);
		// LogCSVWrite logwrite = new LogCSVWrite();
		//
		// String log = logwrite.logCSV(text);
		// // 로그 들을 String 한줄로 다 붙여버린다.
		//
		// String res[] = log.split(" ");
		// String csa[] = {};
		//
		// for (int i = 1; i < res.length; i++) {
		// csa = res[i].split(",");
		// logService.register(logwrite.logDB(csa));
		// System.out.println("log go to DB ..................");
		// }
	}
	//
	//// // CSV 파일 저장되어있는것을 읽어와서 JSONObject 에 담아서 리턴해준다.
	//// // JS 에서 JSON으로 받는다.
	//// @RequestMapping(value = "/kmeans", produces = "application/json")
	//// public JSONObject rulebase() throws Exception {
	//// System.out.println("rulebase start");
	//// KmeansCSVRead kmeans = new KmeansCSVRead();
	//// return kmeans.kmeansCSV();
	//// }
	//
	// // CSV 파일 저장되어있는것을 읽어와서 DB에 넣는 코드
	// // Kmeans 돌려서 나오는 걸 DB에 넣고 CSV 를 만든다.
	// @RequestMapping(value = "/base", produces = "application/json")
	// public void base() throws Exception {
	// System.out.println("base start");
	//
	// FileReader fr = new FileReader("C://zzz//Kmeans.csv");
	// BufferedReader br = new BufferedReader(fr);
	//
	// fr.read(); // 리턴값으로 읽어온 char 수를 리턴한다. -1 은 다읽은 거다.
	// String result = "";
	//
	// while (true) {
	// if (br.ready() == false) {
	// break;
	// }
	// result += br.readLine().replaceAll("\"", "") + " ";
	// }
	// System.out.println("result : " + result);
	//
	// String arr[] = result.split(" "); // 첫줄은 헤더니까 1부터 시작해서 파싱 시작해줘야한다.
	// // 모든것을 읽어서 띄어쓰기로 나눠서 배열로 넣어두었다.
	//
	// String aee[] = {};
	// System.out.println("arr 길이 : " + arr.length);
	//
	// for (int i = 1; i < arr.length; i++) {
	// System.out.println(arr[i]);
	// aee = arr[i].split(",");
	// KmeansVO vo = new KmeansVO();
	// vo.setKage(Integer.parseInt(aee[1]));
	// vo.setKgender(aee[2]);
	// vo.setKemotion(aee[3]);
	// vo.setK_first(aee[4]);
	// vo.setK_second(aee[5]);
	// vo.setK_third(aee[6]);
	// vo.setKarea(aee[7]);
	// kmeansService.register(vo);
	// }
	//
	// }
	//
	//
	// // JS에 광고 리스트를 보내줘야 하는 기능 구현 해야 한다.
	// @RequestMapping(value = "/adlist", produces = "application/json")
	// public void ADList() throws Exception {
	//
	// }

}
