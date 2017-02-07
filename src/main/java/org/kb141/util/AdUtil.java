package org.kb141.util;

import java.util.List;

import org.kb141.domain.AdVO;
import org.kb141.mapper.AdMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AdUtil {
	
	@Autowired
	private AdMapper adMapper;
	
//	public List<AdVO> adListWrite(List<AdVO>adService) {
//		List<AdVO> list = null;
//		try {
//			list = adService;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
	
	List<AdVO> list;
	public List<AdVO> adListWrite() {
		try {
			list = adMapper.adListCSV();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
