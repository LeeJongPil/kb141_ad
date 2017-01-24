package org.kb141.util;

import java.util.Calendar;
import java.util.List;

import org.kb141.domain.LogVO;

public enum AttributeGenerator {
	
	INSTANCE;
	
	public ChartAttributes generator(List<LogVO> data){
		ChartAttributes result = new ChartAttributes();
		Calendar cal = Calendar.getInstance();
		
		for (LogVO logVO : data) {
			cal.setTime(logVO.getCurr_time());
			
			if(logVO.getGender().equals("M")){
				result.countUpMale();
			} else {
				result.countUpFemale();
			}
			result.countUpView_age(logVO.getAge());
			result.countUpView_time(cal.get(Calendar.HOUR_OF_DAY));
		}
		
		return result;
	}

}
