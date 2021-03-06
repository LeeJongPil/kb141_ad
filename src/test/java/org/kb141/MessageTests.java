package org.kb141;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.dao.MessageDAO;
import org.kb141.domain.Criteria;
import org.kb141.domain.MessageVO;
import org.kb141.mapper.MessageMapper;
import org.kb141.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageTests {
	
	@Autowired
	private MessageDAO dao;
	
	@Autowired
	private MessageService service;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Test
	public void createTest(){
		for(int i = 0 ; i < 100 ; i++){
			MessageVO vo = new MessageVO();
			vo.setMfrom("admin");
			vo.setMto("client" + i);
			vo.setMtitle("createTest title" + i);
			vo.setMcontent("create Test content" + i);
			vo.setChecked(0);
			dao.save(vo);
			
		}
	}
	
	@Test
	public void readTest(){
		System.out.println(dao.findOne(3));
	}
	
	@Test
	public void updateTest(){
		MessageVO vo = new MessageVO();
		vo.setMno(3);
		vo.setMfrom("admin");
		vo.setMto("client12345");
		vo.setMtitle("createTest title12345");
		vo.setMcontent("create Test content12345");
		vo.setChecked(0);
		dao.save(vo);
	}
	
	@Test
	public void deleteTest(){
		int i = 1 ;
		for (; i < 200; i++) {
		if(null != dao.findOne(i)){
			dao.delete(i);
		};
		}
	}
	
	@Test
	public void mnoListTest(){
		// 0부터 1페이지  순으로 내림차순 정렬이고 기준은 mno 를 기준으로 한다. 
		PageRequest page = new PageRequest(0, 10, new Sort(Direction.DESC, "mno"));
		
		Page<MessageVO> result = dao.findAll(page); 
		
		List<MessageVO> list = result.getContent();
		
		for(int i = 0 ; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void searchCountTest() throws Exception{
//		System.out.println(dao.findByMcontentContainingOrMtitleContainingOrMfromContainingAndMtoEquals("lsy", "lsy", "lsy", "admin").size());
	}
	
	@Test
	public void searchPageTest() throws Exception{
		PageRequest page = new PageRequest(0, 10, new Sort(Direction.DESC, "mno"));
//		Page<MessageVO> list = dao.findByMcontentContainingOrMtitleContainingOrMfromContainingAndMtoEquals("test", "test","test", "lsy", page);
		Page<MessageVO> list = dao.findByMtoEqualsAndMfromContainingOrMtoEqualsAndMcontentContainingOrMtoEqualsAndMtitleContaining("lsy", "왜","lsy","왜","lsy", "왜", page);
		List<MessageVO> listed = list.getContent();
		for(int i = 0; i < listed.size(); i++){
			System.out.println(listed.get(i));
		}
	}
	
	@Test
	public void firstPageTest() throws Exception{
		PageRequest page = new PageRequest(0, 10, new Sort(Direction.DESC, "mno"));
		Page<MessageVO> paging = dao.findByMtoEquals("lsy", page);
		List<MessageVO> list = paging.getContent();
		for(int i = 0 ; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		
		
	}
	
	
	
	// ---------------- service --------------------------------------------------------------------------------------------------
	
	@Test
	public void pagingTest() throws Exception {
		Criteria cri = new Criteria();
		cri.setMto("admin");
		cri.setSearch("lsy");
		List<MessageVO> list = service.pagingList(cri);
		
		System.out.println(cri);
		
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
//	@Test
//	public void NextPagingTest(){
//		Criteria cri = new Criteria();
//		service.pagingList(cri);
//		
//		cri.setpage(100);
//		System.out.println(cri);
//		List<MessageVO> list = service.nextPagingList(cri);
//		for(int i = 0 ; i < list.size(); i++){
//			System.out.println(list.get(i));
//		}
//	}
	
	
	
	@Test
	public void registerTest(){
		MessageVO vo = new MessageVO();
		vo.setMfrom("regTest admin");
		vo.setMto("regTest client");
		vo.setMtitle("regTest title");
		vo.setMcontent("regTest content");
		vo.setChecked(0);
		service.register(vo);
	}
	
	@Test
	public void viewTest(){
//		System.out.println(service.view(212));
		MessageVO vo = new MessageVO();
		
		vo = service.view(212);
		System.out.println(vo.getFilename());
		String[] filename = vo.getFilename().split(",");
		String filenames = null;
		for(int i = 0 ; i <filename.length; i++){
			filenames += filename[i];
			System.out.println(filename[i]);
		}
		System.out.println(filenames);
	}
	
	@Test
	public void modifyTest(){
		MessageVO vo = new MessageVO();
		vo.setMno(101);
		vo.setMfrom("modifyTest admin");
		vo.setMto("modifyTest client");
		vo.setMtitle("modifyTest title");
		vo.setMcontent("modifyTest content");
		vo.setChecked(0);
		service.modify(vo);
	}
	
	@Test
	public void removeTest(){
		service.remove(101);
	}
	
	@Test
	public void getListTest(){
		System.out.println(service.getList());
	}
	
	@Test
	public void getCountMsg() {
		System.out.println(service.countMsg());
	}
	
	@Test
	public void getMsgLIstTest() {
		List<MessageVO> list = service.getMsgList("lsy");
		for(int i = 0 ; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void getSearchListTest(){
		Criteria cri = new Criteria();
		cri.setSearch("admin");
		List<MessageVO> list = service.pagingList(cri);
		for(int i = 0 ; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
//	@Test
//	public void getSearchDAOListTest(){
//		Criteria cri = new Criteria();
//		cri.setSearch("t_s");
//		List<MessageVO> list = dao.findByMcontentContainingOrMtitleContainingOrMfromContaining(cri);
//		for(int i = 0 ; i < list.size(); i ++){
//			System.out.println(list.get(i));
//		}
//	}
	
	
	// ---------------- Mapper Test ----------------------
	
	@Test
	public void countMsgTest() throws Exception {
		System.out.println(messageMapper.countMsg());
	}
	
	@Test
	public void MsgList() throws Exception{
		List<MessageVO> list = messageMapper.msgList("test");
		for(int i = 0 ; i <list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void countTest() throws Exception{
		System.out.println(messageMapper.count("admin"));
	}


	
}
