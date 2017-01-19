package org.kb141.web;

import org.kb141.domain.AdVO;
import org.kb141.domain.DeviceVO;
import org.kb141.domain.LogVO;
import org.kb141.service.AdService;
import org.kb141.service.DeviceService;
import org.kb141.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * ad, device, log
 */
@Controller
public class AdController {

	private static final Logger logger = LoggerFactory.getLogger(AdController.class);

	@Autowired
	private AdService adService;

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private LogService logService;

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
	public String modifyAdPOST(AdVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("POST MESSAGE Modify....");
		adService.modify(vo);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/list";
	}
	////////////////////////////////////////////////////////////////////////////////////

	/*
	 * DEVICE CRUD START
	 */

	@GetMapping("/registerDevice")
	public void registerDeviceGET() throws Exception {
		logger.info("GET DEVICE Register....");
	}

	@PostMapping("/registerDevice")
	public String registerDevicePOST(DeviceVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST DEVICE Register....");
		logger.info("POST: " + vo);
		// rttr.addFlashAttribute("msg","success");
		deviceService.register(vo);

		model.addAttribute("result", "success");
		return "redirect:list";
	}

	@GetMapping("/viewDevice")
	public void viewDevice(@RequestParam("dno") Integer dno, Model model) throws Exception {
		logger.info("GET DEVICE View....");
		logger.info("dno: " + dno);

		model.addAttribute(deviceService.view(dno));
		logger.info("result: " + deviceService.view(dno));
	}

	@GetMapping("/listDevice")
	public void listDevice(Model model) throws Exception {
		logger.info("GET DEVICE List....");
		model.addAttribute(deviceService.getList());
		logger.info("result: " + deviceService.getList());
	}

	@PostMapping("/removeDevice")
	public String removeDevice(@RequestParam("dno") Integer dno, RedirectAttributes rttr) throws Exception {
		logger.info("GET DEVICE Remove....");
		logger.info("dno: " + dno);
		deviceService.remove(dno);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:list";
	}

	@GetMapping("/modifyDevice")
	public void modifyDeviceGET(@RequestParam("dno") Integer dno, Model model) throws Exception {
		logger.info("GET DEVICE Modify....");
		model.addAttribute(deviceService.view(dno));
	}

	@PostMapping("/modifyDevice")
	public String modifyDevicePOST(DeviceVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("POST DEVICE Modify....");
		deviceService.modify(vo);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:/list";
	}
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

}
