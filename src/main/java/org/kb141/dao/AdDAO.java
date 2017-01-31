package org.kb141.dao;

import java.util.List;

import org.kb141.domain.AdVO;
import org.kb141.domain.DeviceAdVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdDAO extends JpaRepository<AdVO, Integer>{
		
}
