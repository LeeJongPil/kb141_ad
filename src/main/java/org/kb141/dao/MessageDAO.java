package org.kb141.dao;


import java.util.List;

import org.kb141.domain.MessageVO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageDAO extends PagingAndSortingRepository<MessageVO, Integer> {
		
	List<MessageVO> findAll();
	
	
	
//	
//	// 보내는 사람에 대한 리스트 
//	List<MessageVO> findByMfromOrderByMnoDesc(String mfrom);
//	// 번호 에 대한 역 정렬 리스트 
//	Page<MessageVO> findByMno(Pageable page);
	
	
	

	
	
}
