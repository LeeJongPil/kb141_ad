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
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping(value={"/client/message", "/admin/message"})
@RequestMapping("/message")
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageService service;

	
	Criteria cri = new Criteria();
	
//	String str = "<tr class= result[i].checked == 0 ? 'unread' : 'read'>"	;
	
	
	@GetMapping("/inbox")
	public void inboxMain(@RequestParam(value="keyword", defaultValue="") String keyword,
			Model model, @CookieValue("username") String username, @CookieValue("urlname") String urlName){
		logger.info("Message Inbox Comming");
		logger.info("user name : " + username);
		logger.info("keyword 1차: " + keyword);
		logger.info("view inbox main call...");
		logger.info("url Name : " + urlName);
		
		cri.setpage(0);	// F5를 했을경우 다시 첫페이지로 가기 위해서 해놔야 한다. 리얼 트루
		cri.setMto(username);
		
//		cri.setSearch((keyword != "") ? keyword : null);
		cri.setSearch((keyword.equals("")) ? null : keyword);
		logger.info("keyword 2차 : " + cri.getSearch());
//		System.out.println(cri.getSearch());
		
		List<MessageVO>msgList = service.pagingList(cri);
//		cri.setTotal(msgList.size());

		System.out.println("cri.getTotal : " + cri.getTotal());
		for(int i = 0 ; i < msgList.size(); i++){
			System.out.println(msgList.get(i));
		}
		
		model.addAttribute("list" , msgList);
		model.addAttribute("total", cri.getTotal());
		model.addAttribute("urlname", urlName);
//		return "/message/inbox";
	}
	
	
	@GetMapping("paging")
	@ResponseBody
	public List<MessageVO> paging(@RequestParam(value="keyword", defaultValue="") String keyword,
			Model model, @CookieValue("username") String username, int page){
		System.out.println("paging Start .....");
		System.out.println("page : " +page);
		cri.setpage(page);
		cri.setSearch((keyword != "") ? keyword : null);
		logger.info(username);
		cri.setMto(username);
//		List<MessageVO> list = service.nextPagingList(cri);
		List<MessageVO> list = service.pagingList(cri);
		System.out.println(list);
		return list;
	}
	
//	@GetMapping("/paging")
//	@ResponseBody
//	public List<MessageVO> paging(int page){
//		System.out.println("paging Start .....");
//		System.out.println(page);
////		cri.setpage(page);
////		logger.info(username);
////		cri.setMto(username);
////		List<MessageVO> list = service.nextPagingList(cri);
//		List<MessageVO> list = service.pagingList(cri);
//		System.out.println(list);
//		return list;
//	}
	
	
	
	
	@GetMapping("/view")
	public void msgView(Integer mno , Model model){
		logger.info("view called....");
		logger.info("mno : " + mno);
		MessageVO vo = new MessageVO();
		vo = service.view(mno);
		
		if(vo.getFilename() != null){
			String[] filename = vo.getFilename().split(",");
			System.out.println("filename : " +filename);
			for(int i = 0 ; i < filename.length; i++){
				System.out.println("filename"+i + " : " + filename[i]);
			}
			model.addAttribute("filename", filename);	// filename을 "," 로 나누어서 배열에 담았다.
			System.out.println(filename[0]);
		}
		System.out.println("view 거치니 ?");
		model.addAttribute("view", vo);
		// view.jsp 에서 배열로 받아서 뿌리면 된다. 
	}
	
	@GetMapping("/send")
	public void registerMsg( Model model){
		logger.info("sendmsg page called.....");
//		logger.info(mfrom);
//		model.addAttribute("to" , mfrom);
	}
	
	@PostMapping(value = "/send")
	public String sendMsg(MessageVO vo , Model model , String filenames[]){
		logger.info("filenames : " + filenames);
		logger.info("send msg Post ...");
		logger.info("vo : " + vo); 
		String filesname = "";
		for(int i = 0 ; i < filenames.length ; i ++){
			String files = filenames[i]  +  ",";
			filesname += files;
		}		
		logger.info(filesname);
		vo.setFilename(filesname); 
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
