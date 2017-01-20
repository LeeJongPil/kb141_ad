package org.kb141.web;

import java.util.List;

import org.kb141.domain.MessageVO;
import org.kb141.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageService service;
	
	
	@GetMapping("/inbox")
	public void inboxMain(Model model){
		logger.info("view inbox main call...");
		List<MessageVO>msgList = service.getList();
		model.addAttribute("list" , msgList);
		
	}
	
	@GetMapping("/view")
	public void msgView(Integer mno , Model model){
		logger.info("view called....");
		logger.info("mno" + mno);
		model.addAttribute("view", service.view(mno));
		
	}
	
	@GetMapping("/send")
	public void registerMsg(String mfrom , Model model){
		logger.info("sendmsg page called.....");
		logger.info(mfrom);
		model.addAttribute("to" , mfrom);
		
	}
	
	@PostMapping(value = "/send")
	public void sendMsg(MessageVO vo , Model model){
		logger.info("send msg...");
		logger.info("vo : " + vo); 
		
		
	}
	 // trach clean
	@PostMapping("/delete")
	public void deleteMsg(Integer mno){
		logger.info("del called.....");
		logger.info("mno :" + mno);
		service.remove(mno);
		
	}
	 // change trach  or read
	@PostMapping("/state")
	public String updateState(MessageVO vo){
		logger.info("state change called...");
		logger.info("vo : " + vo);
		if(vo.getChecked() == 1){
			service.modify(vo);
		}
		else if(vo.getChecked() ==2){
			service.modify(vo);
			return "redirect:message/inbox";
		}
		return null;
	}

}
