package org.kb141.mapper;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.SecurityVO;

public interface SecurityMapper {
	
	@Select("select * from (select a.aid userid, a.apw userpw, '' company, 'ROLE_ADMIN' role from tbl_admin a union select c.cid userid, c.cpw userpw, c.company, 'ROLE_CLIENT' role from tbl_client c) c where userid = #{userid}")
	public SecurityVO findByUserid(String userid) throws Exception;
	
	
}



