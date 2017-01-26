package org.kb141.dao;

import org.kb141.domain.DeviceAdVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeviceAdDAO extends JpaRepository<DeviceAdVO, Integer>{
  
	@Query("select x from DeviceAdVO x where adno=:adno")
	public DeviceAdVO findFromAdno(@Param("adno") Integer adno) throws Exception;
	
	@Query("select x from DeviceAdVO x where dno=:dno")
	public DeviceAdVO findFromDno(@Param("dno") Integer dno) throws Exception;
	
	
	
	
}
