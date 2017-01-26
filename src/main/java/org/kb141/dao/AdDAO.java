package org.kb141.dao;

import java.util.List;

import org.kb141.domain.AdVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdDAO extends JpaRepository<AdVO, Integer>{
		
//	@Select("select * from tbl_ad order by ad_title desc")
//	public List<AdVO> list(AdVO vo) throws Exception;	 
	
	@Query("select ad,da from AdVO ad left join ad.deviceAds da where da.dno=:dno")
	public List<AdVO> listFromDno(@Param("dno") Integer dno) throws Exception;
	
}
