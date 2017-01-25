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
			boolean[] changeEmotion = new boolean[]{
					logVO.getCha_anger() > 0,
					logVO.getCha_contempt() > 0,
					logVO.getCha_disgust() > 0,
					logVO.getCha_fear() > 0,
					logVO.getCha_happiness() > 0,
					logVO.getCha_neutral() > 0,
					logVO.getCha_sadness() > 0,
					logVO.getCha_surprise() > 0
			};
			
			char gender = 0;
			
			if(logVO.getGender().equals("M")){
				gender = 'M';
				result.countUpMale();
				result.countUpView_Watchtime_male(logVO.getWatch_time());
			} else {
				gender = 'F';
				result.countUpFemale();
				result.countUpView_Watchtime_female(logVO.getWatch_time());
			}
			result.countUpView_age(logVO.getAge());
			result.countUpView_time(cal.get(Calendar.HOUR_OF_DAY));
			
			// anger contempt disgust fear happiness neutral sadness surprise
			for (int i = 0 ; i < changeEmotion.length ; i++){
				result.countUpEmotion_PosNeg_gender(i, changeEmotion[i], gender);
			}
				
		}
		
		return result;
	}

}
