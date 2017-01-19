package org.kb141.web;

import org.kb141.domain.AdVO;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * ad, device, log
 */
@Controller
public class AdController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private AdService adService;
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private LogService logService;
	
	
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
	
	
	
}
