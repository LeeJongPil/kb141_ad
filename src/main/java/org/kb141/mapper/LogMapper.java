package org.kb141.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.DeviceVO;

public interface LogMapper {

	@Select("select count(*) from tbl_log")
	public Integer countLog() throws Exception;
	
//	@Select("select dno, count(*)cnt from tbl_log group by dno order by cnt desc")
//	public List<>
	
	@Select("select round((d1.d1cnt-d2.d2cnt)/(d1.d1cnt+d2.d2cnt)*100) from "
			+ "(select count(*)d1cnt from tbl_log where date_format(curr_time, '%Y%m%d') = curdate()-1) d1,"
			+ "(select count(*)d2cnt from tbl_log where date_format(curr_time, '%Y%m%d') = curdate()-2) d2")
	public Integer Adviewership() throws Exception;
	
}
