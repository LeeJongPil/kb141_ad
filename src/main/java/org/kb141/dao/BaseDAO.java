package org.kb141.dao;

import org.kb141.domain.BaseVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDAO extends JpaRepository<BaseVO, Integer>{
	
}
