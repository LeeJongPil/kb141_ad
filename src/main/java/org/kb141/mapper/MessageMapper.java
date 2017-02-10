package org.kb141.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.kb141.domain.MessageVO;

public interface MessageMapper {
	
	@Select("select * from tbl_message where mto = #{mto} order by mno desc")
	public List<MessageVO> msgList(String mto) throws Exception;

	@Select("select round((lm.lm - tlm.tlm) / tlm.tlm * 100) from"
			+ "(select count(*)tlm from tbl_message where regdate >= now() - interval 2 month and regdate < now() - interval 1 month) tlm,"
			+ "(select count(*)lm from tbl_message where regdate >= (now() - interval 1 month) and month(regdate) < month(now())) lm")
	public Integer countMsg() throws Exception;
	

	@Update("update tbl_message set checked = #{checked}  where mno = #{mno}")
	public void updateState(MessageVO vo)throws Exception;
	
	@Select("select count(*) from tbl_message")
	public Integer count() throws Exception;

}


