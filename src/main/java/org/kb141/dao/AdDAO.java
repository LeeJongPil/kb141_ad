package org.kb141.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.AdVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdDAO extends JpaRepository<AdVO, Integer>{
		
//	@Select("select * from tbl_ad order by ad_title desc")
//	public List<AdVO> list(AdVO vo) throws Exception;	 
}
