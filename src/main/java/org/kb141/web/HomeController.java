package org.kb141.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.kb141.domain.KmeansTestVO;
import org.kb141.service.KmeansTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private KmeansTestService service;
	
	@RequestMapping("/")
	public String index() {
		logger.info("YHJ IS COMING");
		return "hello YHJ!";
	}
	
	@RequestMapping("/test/{gender}")
	public List<KmeansTestVO> genderTest(@PathVariable(name="gender") String gender) {
		logger.info("GENDER IS : " + gender);
		return service.getGenderList(gender);
	}
}
