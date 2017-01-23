package org.kb141.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.MessageVO;

public interface MessageMapper {

	@Select("select count(*) from tbl_message")
	public Integer countMsg() throws Exception;
	
	@Select("select * from tbl_message where mto = #{mto}")
	public List<MessageVO> msgList(String mto) throws Exception;
	
}
