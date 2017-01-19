package org.kb141.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.kb141.domain.KmeansTestVO;
import org.kb141.service.KmeansTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private KmeansTestService service;
	
	@GetMapping("/index")
	public void index(Model model) {
		logger.info("YHJ IS COMING");
	}
	@GetMapping("/login")
	public void login(Model model) {
		logger.info("YHJ IS COMING");
	}
	@GetMapping("/inbox")
	public void inbox(Model model) {
		logger.info("YHJ IS COMING");
	}
	@GetMapping("/message-view")
	public void messageview(Model model) {
		logger.info("YHJ IS COMING");
	}
	@GetMapping("/compose")
	public void compose(Model model) {
		logger.info("YHJ IS COMING");
	}
	@GetMapping("/maps-google")
	public void mapsgoogle(Model model) {
		logger.info("YHJ IS COMING");
	}
	
	
	
	
	
	
	
	@RequestMapping("/test/{gender}")
	public List<KmeansTestVO> genderTest(@PathVariable(name="gender") String gender) {
		logger.info("GENDER IS : " + gender);
		return service.getGenderList(gender);       
	}
	
	@RequestMapping({"/hello"})
	public void getList(Model model) throws Exception{
		logger.info("list .................. ");
		model.addAttribute("name", "Hello world");

	}
}
