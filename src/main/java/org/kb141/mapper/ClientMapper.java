package org.kb141.mapper;

import org.apache.ibatis.annotations.Select;

public interface ClientMapper {

	@Select("select count(cid) as cnt from tbl_client where cid=#{cid}")
	public Integer checkId(String cid) throws Exception;
}
