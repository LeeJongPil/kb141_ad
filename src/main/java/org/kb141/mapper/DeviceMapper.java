package org.kb141.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.DeviceListVO;
import org.kb141.domain.DeviceVO;

public interface DeviceMapper {

	@Select("select dev.state, dev.city ,count(*)logcnt from tbl_log log join tbl_device dev on log.dno = dev.dno where log.curr_time >= now() - interval 1 month group by log.dno order by logcnt desc")
	public List<DeviceListVO> devList() throws Exception;
	
	@Select("select dev.state, dev.city ,count(*)logcnt from (select lg.adno, lg.curr_time, lg.dno from ( select * from tbl_ad where cid = #{cid}) an join tbl_log lg on an.adno = lg.adno) log join tbl_device dev on log.dno = dev.dno where log.curr_time >= now() - interval 1 month group by log.dno order by logcnt desc")
	public List<DeviceListVO> clientDevList(String cid) throws Exception;
	
	@Select("select log.dno, device.city, device.state, count(if(log.gender='M', 1, null)) log_area_male,  count(if(log.gender='F', 1, null)) log_area_female from (select gender, dno from tbl_log) log, (select city, state, dno from tbl_device) device where log.dno = device.dno group by city order by dno")
	public List<DeviceListVO> getStateGenderCount() throws Exception;
	
	@Select("select log.dno, device.city, device.state, count(if(log.gender='M', 1, null)) log_area_male, count(if(log.gender='F', 1, null)) log_area_female from (select gender, dno, adno from tbl_log) log, (select city, state, dno from tbl_device) device where log.dno = device.dno and log.adno = #{adno} group by city order by dno")
	public List<DeviceListVO> getStateGenderCountByAdno(Integer adno) throws Exception;
	
	@Select("select * from tbl_device where dno in(select dno from tbl_device_ad where adno in (select adno from tbl_ad where cid = #{cid}))")
	public List<DeviceVO> getClientCount(String cid) throws Exception;

	@Select("select max(dno)+1 from tbl_device")
	public Integer lastDno() throws Exception;

}
