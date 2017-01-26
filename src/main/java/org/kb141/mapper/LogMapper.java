package org.kb141.mapper;

import org.apache.ibatis.annotations.Select;
import org.kb141.util.ChartAttributes;

public interface LogMapper {

	@Select("select count(*) from tbl_log")
	public Integer countLog() throws Exception;
	
//	@Select("select dno, count(*)cnt from tbl_log group by dno order by cnt desc")
//	public List<>
	
	// 전전날과 전날의 로그들을 가져와서 비교한 쿼리
	
	@Select("select round((d1.d1cnt-d2.d2cnt)/d2.d2cnt*100) from "
			+ " (select count(*)d1cnt from tbl_log where date_format(curr_time, '%Y%m%d') = curdate()-1) d1,"
			+ " (select count(*)d2cnt from tbl_log where date_format(curr_time, '%Y%m%d') = curdate()-2) d2")
	public Integer Adviewership() throws Exception;
	
	
	@Select("select	count(if(date_format(curr_time, '%Y%m%d') = curdate() -1, 1, null))day1, count(if(date_format(curr_time, '%Y%m%d') = curdate() -2, 1, null))day2, count(if(date_format(curr_time, '%Y%m%d') = curdate() -3, 1, null))day3, count(if(date_format(curr_time, '%Y%m%d') = curdate() -4, 1, null))day4, count(if(date_format(curr_time, '%Y%m%d') = curdate() -5, 1, null))day5, count(if(date_format(curr_time, '%Y%m%d') = curdate() -6, 1, null))day6, count(if(date_format(curr_time, '%Y%m%d') = curdate() -7, 1, null))day7 from tbl_log")
	public ChartAttributes getDateView() throws Exception;
	
}