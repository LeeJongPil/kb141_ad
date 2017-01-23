package org.kb141.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.DeviceListVO;

public interface DeviceMapper {

	@Select("select dev.state, dev.city ,count(*)logcnt from tbl_log log join tbl_device dev on log.dno = dev.dno where log.curr_time >= now() - interval 1 month group by log.dno order by logcnt desc")
	public List<DeviceListVO> devList() throws Exception;
	
}
