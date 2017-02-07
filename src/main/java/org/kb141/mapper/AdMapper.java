package org.kb141.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kb141.domain.AdDeviceVO;
import org.kb141.domain.AdVO;
import org.kb141.domain.DeviceAdVO;

public interface AdMapper {
	
	@Select("select * from tbl_ad order by adno desc")
	public List<AdVO> getlist()throws Exception;
	
	@Select("select dano,lat,lng from tbl_device_ad da join tbl_device d where da.dno=d.dno and adno = #{adno}")
	public List<DeviceAdVO> mapChecking(Integer adno) throws Exception;
	
	@Select("select count(*) from tbl_ad")
	public Integer countAd() throws Exception;
	
	@Select("select adno, ad_image, ad_video from tbl_ad")
	public List<AdVO> adListCSV() throws Exception;
	
	@Select("select da.dno, ad.adno, ad.ad_title, ad.ad_content, ad.category, ad.cid, d.lng, d.lat,ad.start_duration, ad.end_duration, ad.permission,ad.target_area, ad.ad_image, ad.ad_video from tbl_device_ad da ,tbl_ad ad, tbl_device d where ad.adno = da.adno and da.dno=d.dno and da.dno=#{dno}")
	public List<AdDeviceVO> deviceListFromDno(Integer dno) throws Exception;
	
	@Select("select * from tbl_ad where cid=#{cid}")
	public List<AdVO> getAdlist(String cid) throws Exception;

	@Select("select start_duration,end_duration from tbl_ad where cid = #{cid}")
	public List<AdVO> getTermDuration(String cid) throws Exception;
	
	@Select("select target_emotions from tbl_ad where cid=#{cid} group by target_emotions desc limit 1")
	public AdVO getTarget_emotion(String cid) throws Exception;
}



