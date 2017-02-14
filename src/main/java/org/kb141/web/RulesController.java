package org.kb141.web;

import org.kb141.domain.BaseVO;
import org.kb141.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * kmeans, base
 */
@Controller
public class RulesController {
	
	private static final Logger logger = LoggerFactory.getLogger(RulesController.class);
	
	@Autowired
	private BaseService baseService;
	
	@GetMapping("/registerBase")
	public void registerBaseGET() throws Exception{
		logger.info("GET BASE Register......");
	}
	
	@PostMapping("/registerBase")
	public String registerBasePOST(BaseVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST BASE Register....");
		logger.info("POST : " + vo);
		
		baseService.register(vo);
		model.addAttribute("result", "success");
		return "redirect:list";
	}
	
	@GetMapping("/viewBase")
	public void viewBaseGET(Integer bno) throws Exception{
		logger.info("GET BASE View......");
		baseService.view(bno);
		logger.info("view :"+baseService.view(bno));
	}
	
	@GetMapping("/modifyBase")
	public void modifyBaseGET() throws Exception{
		logger.info("GET BASE Modify......");
	}
	
	@PostMapping("/modifyBase")
	public String modifyBasePOST(BaseVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST BASE modify....");
		logger.info("POST : " + vo);
		
		baseService.modify(vo);
		model.addAttribute("result", "success");
		return "redirect:list";
	}
	
	@PostMapping("/removeBase")
	public String removeBasePOST(Integer bno, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST BASE remove....");
		logger.info("POST : " + bno);
		
		
		baseService.remove(bno);
		model.addAttribute("result", "success");
		return "redirect:list";
	}
	
	
	
	@GetMapping("/rules/baseList")
	public void getListBaseGET() throws Exception{
		logger.info("GET BASE getList....");
		baseService.getList();
		logger.info("List : " + baseService.getList());
	}
	
	@GetMapping("/rules/kmeansList")
	public void getListKmeansGET() throws Exception{
		logger.info("GET BASE getList....");
		baseService.getList();
		logger.info("List : " + baseService.getList());
	}
	
	
}
