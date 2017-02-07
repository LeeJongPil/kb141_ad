package org.kb141.web;


import java.util.List;

import org.kb141.domain.Criteria;
import org.kb141.domain.MessageVO;
import org.kb141.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageService service;

	
	Criteria cri = new Criteria();
	
//	String str = "<tr class= result[i].checked == 0 ? 'unread' : 'read'>"	;
	
	
	@GetMapping("/inbox")
	public void inboxMain(Model model){
		logger.info("view inbox main call...");
		cri.setpage(0);
		List<MessageVO>msgList = service.pagingList(cri);
		model.addAttribute("list" , msgList);
		model.addAttribute("total", cri.getTotal());
	}
	
	@PostMapping("paging")
	@ResponseBody
	public List<MessageVO> paging(int page){
		System.out.println(page);
		cri.setpage(page);
		List<MessageVO> list = service.nextPagingList(cri);
		System.out.println(list);
		return list;
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
	public String sendMsg(MessageVO vo , Model model){
		logger.info("send msg...");
		logger.info("vo : " + vo); 
		service.register(vo);
		return "redirect:inbox";
	}
	
	 // trach clean
	@PostMapping("/delete")
	public String deleteMsg(String mno){
		logger.info("del called.....");
		logger.info("mno :" + mno);
		String[] arr = mno.split(",");
		for(int i = 0 ; i < arr.length; i ++){
				service.remove(Integer.parseInt(arr[i]));
		}
		return "redirect:inbox";
	}
	
	 // change trach  or read
	@PostMapping("/state")
	public String updateState(MessageVO vo){
		logger.info("state change called...");
		logger.info("vo : " + vo);
		if(vo.getChecked() == 1){
			service.updateState(vo);
		}
		else if(vo.getChecked() ==2){
			service.updateState(vo);
			return "redirect:message/inbox";
		}
		return null;
	}

}
