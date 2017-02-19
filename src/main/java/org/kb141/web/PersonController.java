package org.kb141.web;
/*
 * client, admin, message
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.servlet.http.HttpServletRequest;

import org.kb141.domain.AdminVO;
import org.kb141.domain.ClientVO;
import org.kb141.domain.MessageVO;
import org.kb141.service.AdminService;
import org.kb141.service.ClientService;
import org.kb141.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/*")
//@CrossOrigin
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private AdminService adminService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private MessageService messageService;

	
	/*
	 * SECURITY
	 */

	
	
	
	
//	@PostMapping("/jpa")
//	public File jpaToken(MultipartFile file){
//		logger.info("JPA ~~~~~~~~~~!!!!!!!!!   ");
//		logger.info("들어온다...........................");	
//		logger.info("file : " + file);
//		
//		File convFile = new File("C:/zzz/ad/" + file.getOriginalFilename());
//		
//		logger.info("originalFileName : " + file.getOriginalFilename());
//		
//		try {
//			file.transferTo(convFile);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		logger.info("convFile : " + convFile);
//		
//		return convFile; 
//	}
	
	
	// node.js 에서 이걸 호출 하면 로그인을 한후 ? 토큰값을 반환해주면된다. ? 
	// 파라미터로 id , pw 를 받아서 토큰값만 리턴 해줘야 한다. 
	
	//일딴 여기서는 id, pw 만 보내서 토큰만 나오는지 확인 해 보자 
	@GetMapping("/token")
	public void token(CsrfToken token, HttpServletRequest request){
		logger.info("Get token 갑니다...........................................");
	}
	
	@PostMapping("/token")
	public File tokenPost(MultipartFile file){
		logger.info("Post token start ............");
		logger.info("token post : " + file);
		File convFile = new File("C:/zzz/ad/" + file.getOriginalFilename());
		
		logger.info("originalFileName : " + file.getOriginalFilename());
		
		try {
			file.transferTo(convFile);
		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("convFile : " + convFile);
		
		return convFile; 
	}
	
	@RequestMapping("/download")
	public MultipartFile fileDown(){
	logger.info("file download start.........");
		String filePath = "C:/zzz/ad/list.csv";
		
		FileReader fr = null;
		BufferedReader br = null;
		
//		fr = new FileReader();
		
			
	
		
		
		return null;
	}
	
//	@PostMapping("/login")
//	public String loginPost(String id, String pw, Model model){
//		
//		logger.info("Post 방식으로 login 페이지 거쳐서 토큰값 추출.........................");
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		
//		return "redirect:login";
//	}
	
	
	@GetMapping("/login")
	public void login() {
	} // login 페이지로 간다.

	@GetMapping("/register")
	public void register() {
		logger.info("REGISTER GET....");
	}

	@PostMapping("/register")
	public String register(ClientVO vo, RedirectAttributes rttr) throws Exception {
		rttr.addFlashAttribute("msg", "success");
		clientService.register(vo);
		return "redirect:login";
	}
  
	@ResponseBody
	@GetMapping("/register/checkId/{cid}")
	public ResponseEntity<Integer> checkId(@PathVariable("cid") String cid) {
		logger.info("GET ADLIST");
		ResponseEntity<Integer> entity = null;
		try {
			entity = new ResponseEntity<>(clientService.checkId(cid), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/*
	 * ADMIN CRUD START
	 */
	@GetMapping("/registerAdmin")
	public void registerAdminGET() throws Exception {
		logger.info("GET ADMIN Register....");
	}

	@PostMapping("/registerAdmin")
	public String registerAdminPOST(AdminVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST ADMIN Register....");
		logger.info("POST: " + vo);
		// rttr.addFlashAttribute("msg","success");
		adminService.register(vo);

		model.addAttribute("result", "success");
		return "redirect:list";
	}

	@GetMapping("/viewAdmin")
	public void viewAdmin(@RequestParam("aid") String aid, Model model) throws Exception {
		logger.info("GET ADMIN View....");
		logger.info("aid: " + aid);

		model.addAttribute(adminService.view(aid));
		logger.info("result: " + adminService.view(aid));
	}

	@GetMapping("/listAdmin")
	public void listAdmin(Model model) throws Exception {
		logger.info("GET ADMIN List....");
		model.addAttribute(adminService.getList());
		logger.info("result: " + adminService.getList());
	}

	@PostMapping("/removeAdmin")
	public String removeAdmin(@RequestParam("aid") String aid, RedirectAttributes rttr) throws Exception {
		logger.info("GET ADMIN Remove....");
		logger.info("aid: " + aid);
		adminService.remove(aid);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:list";
	}

	@GetMapping("/modifyAdmin")
	public void modifyAdminGet(@RequestParam("aid") String aid, Model model) throws Exception {
		logger.info("GET ADMIN Modify....");
		model.addAttribute(adminService.view(aid));
	}

	@PostMapping("/modifyAdmin")
	public String modifyAdmingPOST(AdminVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("POST ADMIN Modify....");
		adminService.modify(vo);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/list";
	}
	////////////////////////////////////////////////////////////////////////////////////

	/*
	 * CLIENT CRUD START
	 */

	@GetMapping("/registerClient")
	public void registerClientGET() throws Exception {
		logger.info("GET CLIENT Register....");
	}

	@PostMapping("/registerClient")
	public String registerClientPOST(ClientVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST CLIENT Register....");
		logger.info("POST: " + vo);
		// rttr.addFlashAttribute("msg","success");
		clientService.register(vo);

		model.addAttribute("result", "success");
		return "redirect:list";
	}

	@GetMapping("/viewClient")
	public void viewClient(@RequestParam("cid") String cid, Model model) throws Exception {
		logger.info("GET CLIENT View....");
		logger.info("cid: " + cid);

		model.addAttribute(clientService.view(cid));
		logger.info("result: " + clientService.view(cid));

	}

	@GetMapping("/listClient")
	public void listClient(Model model) throws Exception {
		logger.info("GET CLIENT List....");
		model.addAttribute(clientService.getList());
		logger.info("result: " + clientService.getList());
	}

	@PostMapping("/removeClient")
	public String removeClient(@RequestParam("cid") String cid, RedirectAttributes rttr) throws Exception {
		logger.info("GET CLIENT Remove....");
		logger.info("cid: " + cid);
		clientService.remove(cid);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:list";
	}

	@GetMapping("/modifyClient")
	public void modifyClientGET(@RequestParam("cid") String cid, Model model) throws Exception {
		logger.info("GET CLIENT Modify....");
		model.addAttribute(clientService.view(cid));
	}

	@PostMapping("/modifyClient")
	public String modifyClientPOST(ClientVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("POST CLIENT Modify....");
		clientService.modify(vo);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/list";
	}
	////////////////////////////////////////////////////////////////////////////////////

	/*
	 * MESSAGE CRUD START
	 */

	@GetMapping("/registerMessage")
	public void registerMessageGET() throws Exception {
		logger.info("GET MESSAGE Register....");
	}

	@PostMapping("/registerMessage")
	public String registerMessagePOST(MessageVO vo, Model model, RedirectAttributes rttr) throws Exception {
		logger.info("POST MESSAGE Register....");
		logger.info("POST: " + vo);
		// rttr.addFlashAttribute("msg","success");
		messageService.register(vo);

		model.addAttribute("result", "success");
		return "redirect:list";
	}

	@GetMapping("/viewMessage")
	public void viewMessage(@RequestParam("mno") Integer mno, Model model) throws Exception {
		logger.info("GET MESSAGE View....");
		logger.info("mno: " + mno);

		model.addAttribute(messageService.view(mno));
		logger.info("result: " + messageService.view(mno));
	}

	@GetMapping("/listMessage")
	public void listMessage(Model model) throws Exception {
		logger.info("GET MESSAGE List....");
		model.addAttribute(messageService.getList());
		logger.info("result: " + messageService.getList());
	}

	@PostMapping("/removeMessage")
	public String removeMessage(@RequestParam("mno") Integer mno, RedirectAttributes rttr) throws Exception {
		logger.info("GET MESSAGE Remove....");
		logger.info("mno: " + mno);
		messageService.remove(mno);

		rttr.addFlashAttribute("msg", "success");
		return "redirect:list";
	}

	@GetMapping("/modifyMessage")
	public void modifyMessageGET(@RequestParam("mno") Integer mno, Model model) throws Exception {
		logger.info("GET MESSAGE Modify....");
		model.addAttribute(messageService.view(mno));
	}

	@PostMapping("/modifyMessage")
	public String modifyMessagePOST(MessageVO vo, RedirectAttributes rttr) throws Exception {
		logger.info("POST MESSAGE Modify....");
		messageService.modify(vo);

		rttr.addFlashAttribute("msg", "success");

		return "redirect:/list";
	}

}
