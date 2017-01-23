package org.kb141.mapper;

import org.apache.ibatis.annotations.Select;

public interface AdMapper {
	
	@Select("select count(*) from tbl_ad")
	public Integer countAd() throws Exception;
	
}
