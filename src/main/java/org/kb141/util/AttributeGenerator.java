package org.kb141.util;

import java.util.List;

import org.kb141.domain.LogVO;

public enum AttributeGenerator {
	
	INSTANCE;
	
	public ChartAttributes generator(List<LogVO> data){
		ChartAttributes result = new ChartAttributes();
		
		for (LogVO logVO : data) {
			if(logVO.getGender().equals("M")){
				result.countUpMale();
			} else {
				result.countUpFemale();
			}
			result.countUpView_age(logVO.getAge());
			
		}
		
		return result;
	}

}
