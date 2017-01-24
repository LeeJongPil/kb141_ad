package org.kb141.mapper;

import org.apache.ibatis.annotations.Update;
import org.kb141.domain.MessageVO;

public interface MessageMapper {
	
	@Update("update tbl_message set checked = #{checked}  where mno = #{mno}")
	public void updateState(MessageVO vo)throws Exception;
	
	

}
