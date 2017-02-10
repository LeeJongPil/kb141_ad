
package org.kb141.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.kb141.domain.AdVO;
import org.kb141.service.AdService;
import org.kb141.service.ClientService;
import org.kb141.service.DeviceService;
import org.kb141.service.KmeansService;
import org.kb141.service.LogService;
import org.kb141.service.MessageService;
import org.kb141.util.AttributeGenerator;
import org.kb141.util.ChartAttributes;
import org.kb141.util.FileMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/client")
public class ClientController {
	Logger logger = Logger.getLogger(this.getClass());
	
	String testId = "lsy";
	
	
	@Autowired
	private KmeansService kmeansService;
	
	@Autowired
	private LogService logService;
	
	@Autowired
	private AdService adService;

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("")
	public String indexing(Model model, @CookieValue("username") String username) throws Exception{
		logger.info("client index");
//		Cookie[] cookies = request.getCookies();
//		logger.info(cookies.get);
		logger.info(username);
		
		ChartAttributes result = AttributeGenerator.
				INSTANCE.generator(logService.getClientList(username));
		
		ChartAttributes result2 = logService.getDateView();
		result.setView_date(result2.getView_date());
		
		System.out.println(result);
		model.addAttribute("data", result);
		model.addAttribute("adCount",adService.getTermDuration(username));
		model.addAttribute("adList", adService.getAdlist(username));
		model.addAttribute("logCount",logService.getClientList(username).size());
		model.addAttribute("msgCount",messageService.countMsg());
		model.addAttribute("devList",deviceService.getClientDevList(username));
		model.addAttribute("msgList",messageService.getMsgList(username));		// 로그인 되면 로그인 된 아이디 값을 넘겨줘야 한다.  로그인 처리 되면 ↑ 껄로 바꿔줘야한다. 
		model.addAttribute("Adviewership",logService.getAdviewership());
		model.addAttribute("deviceList",deviceService.getClientCount(username));
		model.addAttribute("emotion", adService.getTarget_emotion(username));
		return "client/index";
	}

//	@GetMapping("/login")
//	public void login(Model model) {
//		logger.info("YHJ IS COMING");
//	}
	
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
	
	
	@GetMapping("/charts-chartjs")
	public void chartschartjs(/*String cid,*/ Model model) throws Exception{
		ChartAttributes result = AttributeGenerator.
				INSTANCE.generator(logService.getClientList(testId));

		ChartAttributes result2 = logService.getDateView();
		result.setView_date(result2.getView_date());
		
		System.out.println(result);
		model.addAttribute("data", result);
		model.addAttribute("stategender", deviceService.getStateGenderCount());
	}
	
	@GetMapping("/charts-chartjs2")
	public void chartschartjs2(Integer adno,Model model) throws Exception{
		

		logger.info("join");
		ChartAttributes result = AttributeGenerator.
				INSTANCE.generator(logService.getListByAdno(adno));

		ChartAttributes result2 = logService.getDateView();
		result.setView_date(result2.getView_date());
		System.out.println("adno : "+adno);
		System.out.println("result : " +result);
		model.addAttribute("data", result);
		model.addAttribute("stategender", deviceService.getStateGenderCount());
		model.addAttribute("adVO", adService.getAdlist(testId));
		
	}
	
	@GetMapping("/Chart")
	@ResponseBody
	public ChartAttributes Chart(Integer adno,Model model) throws Exception{
		
		logger.info("join");
		ChartAttributes result = AttributeGenerator.
				INSTANCE.generator(logService.getListByAdno(adno));

		ChartAttributes result2 = logService.getDateView();
		result.setView_date(result2.getView_date());
		System.out.println("adno : "+adno);
		System.out.println("result : " + result);
/*		model.addAttribute("data", result);
		model.addAttribute("stategender", deviceService.getStateGenderCount());
		model.addAttribute("adVO", adService.getAdlist(testId));*/
		return result;
	}
	
	@GetMapping("/profile")
	public void profile(/*String cid,*/ Model model,@CookieValue("username") String username) throws Exception{
		logger.info("Profile is Comming");
		logger.info(username);
		model.addAttribute("adVO", adService.getAdlist(username));
	}
	
	@GetMapping("profile2")
	public void profile2(@RequestParam("adno") Integer adno, Model model) throws IOException{

		logger.info("YHJ IS COMING");
		logger.info("adno : " + adno);
		model.addAttribute("adVO", adService.view(adno));
		model.addAttribute("deviceVO", adService.getMapChecking(adno));

		ChartAttributes result = AttributeGenerator.
				INSTANCE.generator(logService.getListByAdno(adno));
		model.addAttribute("data", result);
	}
	@GetMapping("profile2Register")
	public void profile2registerGET(){
		logger.info("profile2registerGET.......");
	}
	
	@GetMapping("viewfile")
	public @ResponseBody byte[] viewFile(String fileName) throws IOException{
		
		FileMaker filemaker = new FileMaker();
		
		return filemaker.pushFile(fileName);

		
	}
	
	
	@PostMapping("profile2Register")
	public String profile2registerPOST(@RequestParam(value="ad_image")MultipartFile imgfile,@RequestParam(value="ad_video")MultipartFile vdfile,
									   @RequestParam(value="ad_title")String ad_title,@RequestParam(value="category")String category,
									   @RequestParam(value="cid")String cid, @RequestParam(value="ad_content")String ad_content,
									   @RequestParam(value="start_duration")Date start_duration,@RequestParam(value="end_duration")Date end_duration,
									   @RequestParam(value="target_area")String target_area,@RequestParam(value="target_emotions")String target_emotions,
									   @RequestParam(value="permission")Boolean permission,
									   RedirectAttributes rttr){
		
		AdVO adVO = new AdVO();
		FileMaker fileMaker = new FileMaker();
		
		fileMaker.sendFile(imgfile);
		fileMaker.sendFile(vdfile);

		String ad_image= imgfile.getOriginalFilename();
		String ad_video = vdfile.getOriginalFilename();

				adVO.setAd_content(ad_content);
				adVO.setAd_image(ad_image);
				adVO.setAd_title(ad_title);
				adVO.setAd_video(ad_video);
				adVO.setCategory(category);
				adVO.setCid(cid);
				adVO.setPermission(permission);
				adVO.setStart_duration(start_duration);
				adVO.setEnd_duration(end_duration);
				adVO.setTarget_area(target_area);
				adVO.setTarget_emotions(target_emotions);
		    
			adService.register(adVO);
		
		return "redirect:profile";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}


	
	
	@GetMapping("profile2Modify")
	public void profile2modifyGET(@RequestParam("adno") Integer adno,Model model){
		logger.info("AdVO ModifyGET..............");
		model.addAttribute("adVO", adService.view(adno));
	}
	
	@PostMapping("profile2Modify")
	public String profile2ModifyPOST(@RequestParam(value="ad_image")MultipartFile imgfile,@RequestParam(value="ad_video")MultipartFile vdfile,
		 						    @RequestParam(value="ad_title")String ad_title,@RequestParam(value="category")String category,
								    @RequestParam(value="cid")String cid, @RequestParam(value="ad_content")String ad_content,
								    @RequestParam(value="start_duration")Date start_duration,@RequestParam(value="end_duration")Date end_duration,
								    @RequestParam(value="target_area")String target_area,@RequestParam(value="target_emotions")String target_emotions,
								    @RequestParam(value="permission")Boolean permission,RedirectAttributes rttr){

		AdVO adVO = new AdVO();
		FileMaker fileMaker = new FileMaker();
		
		fileMaker.sendFile(imgfile);
		fileMaker.sendFile(vdfile);
		
		String ad_image= imgfile.getOriginalFilename();
		String ad_video = vdfile.getOriginalFilename();
		
		adVO.setAd_content(ad_content);
		adVO.setAd_image(ad_image);
		adVO.setAd_title(ad_title);
		adVO.setAd_video(ad_video);
		adVO.setCategory(category);
		adVO.setCid(cid);
		adVO.setPermission(permission);
		adVO.setStart_duration(start_duration);
		adVO.setEnd_duration(end_duration);
		adVO.setTarget_area(target_area);
		adVO.setTarget_emotions(target_emotions);
		
		adService.modify(adVO);
		
		return "redirect:profile";
		
	}
	
	@PostMapping("profile2Remove")
	public String profile2remove(Integer adno,RedirectAttributes rttr){
		logger.info("adService Remove..............");
		logger.info("adService adno : " + adno);
		adService.remove(adno);
		rttr.addFlashAttribute("result", "success");
		return "redirect:profile";
	}
}
