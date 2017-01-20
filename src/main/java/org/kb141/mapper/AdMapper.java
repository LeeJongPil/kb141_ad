package org.kb141.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.AdVO;

public interface AdMapper {
	
	@Select("select * from tbl_ad order by ad_title desc")
	public List<AdVO> getlist()throws Exception;
}
