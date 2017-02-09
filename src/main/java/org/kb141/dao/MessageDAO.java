package org.kb141.dao;


import java.util.List;

import org.kb141.domain.MessageVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageDAO extends PagingAndSortingRepository<MessageVO, Integer> {
		
	public List<MessageVO> findAll();
	
	public Page<MessageVO> findByMcontentContainingOrMtitleContainingOrMfromContaining(String search1, String search2, String search3, Pageable page);
	// 파라미터3개를 각각 다 받아와야한다. 검색 조건에 페이징 까지 결합한것이다. 
	
	
	
//	// 보내는 사람에 대한 리스트 
//	List<MessageVO> findByMfromOrderByMnoDesc(String mfrom);
//	// 번호 에 대한 역 정렬 리스트 
//	Page<MessageVO> findByMno(Pageable page);
	
	
	

	
	
}
