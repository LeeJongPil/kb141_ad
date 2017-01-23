package org.kb141.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.AdVO;
import org.kb141.domain.DeviceAdVO;

public interface AdMapper {
	
	@Select("select * from tbl_ad order by ad_title desc")
	public List<AdVO> getlist()throws Exception;
	
	@Select("select dano,lat,lng from tbl_device_ad da join tbl_device d where da.dno=d.dno and adno = #{adno}")
	public List<DeviceAdVO> mapChecking(Integer adno) throws Exception;
	
	@Select("select count(*) from tbl_ad")
	public Integer countAd() throws Exception;
}



