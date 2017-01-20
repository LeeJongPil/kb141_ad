package org.kb141.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.kb141.domain.AdVO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdDAO extends JpaRepository<AdVO, Integer>{

	
	
}
