package org.kb141.web;

import org.kb141.domain.BaseVO;
import org.kb141.service.BaseService;
import org.kb141.service.KmeansService;
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

	@Autowired
	private KmeansService kmeansService;

	@GetMapping("/registerBase")
	public void registerBaseGET() throws Exception {
		logger.info("GET BASE Register......");
	}

	@PostMapping("/registerBase")
	public String registerBasePOST(BaseVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST BASE Register....");
		logger.info("POST : " + vo);

		baseService.register(vo);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:admin/rules/baseList";
	}

	@GetMapping("/viewBase")
	public void viewBaseGET(Integer bno) throws Exception {
		logger.info("GET BASE View......");
		baseService.view(bno);
		logger.info("view :" + baseService.view(bno));
	}

	@GetMapping("/modifyBase")
	public void modifyBaseGET() throws Exception {
		logger.info("GET BASE Modify......");
	}

	@PostMapping("/modifyBase")
	public String modifyBasePOST(BaseVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST BASE modify....");
		logger.info("POST : " + vo);
		logger.info("Model" + model);

		baseService.modify(vo);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:admin/rules/baseList";
	}

	@PostMapping("/removeBase")
	public String removeBasePOST(String bnoChecks, RedirectAttributes rttr) throws Exception {
		logger.info("POST BASE remove....");
		logger.info("POST : " + bnoChecks);
		String[] bnos = bnoChecks.split(",");
		for (String bno : bnos) {
			baseService.remove(Integer.parseInt(bno));
		}
		rttr.addFlashAttribute("msg", "success");
		return "redirect:admin/rules/baseList";
	}

	@GetMapping("admin/rules/baseList")
	public void getListBaseGET(Model model) throws Exception {
		logger.info("GET BASE getList....");
		model.addAttribute("list", baseService.getList());
		logger.info("List : " + baseService.getList());
	}

	@GetMapping("admin/rules/kmeansList")
	public void getListKmeansGET(Model model) throws Exception {
		logger.info("GET Kmeans getList....");
		model.addAttribute("list", kmeansService.getList());
		logger.info("List : " + baseService.getList());
	}

	@GetMapping("/rules/test")
	public void getTest(Model model) throws Exception {
		logger.info("GET Kmeans getList....");
	}

}
