package org.kb141.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kb141.domain.DeviceListVO;

public class ChartAttributes {

	private int male, female;
	private int[] view_age = new int[] { 0, 0, 0, 0, 0, 0, 0 };
	private int[] view_date = new int[7];
	private int[] view_time = new int[24];
	private int[] view_watchtime_male = new int[20];
	private int[] view_watchtime_female = new int[20];
	
	private int[] emotion_positive_male = new int[8];
	private int[] emotion_positive_female = new int[8];
	private int[] emotion_negative_male = new int[8];
	private int[] emotion_negative_female = new int[8];
	
	private List<DeviceListVO> stategender = new ArrayList<>();

	// anger contempt disgust fear happiness neutral sadness surprise

	public ChartAttributes() {
		for (int i = 0; i < view_time.length; i++) {
			this.view_time[i] = 0;
		}
		for (int i = 0; i < view_watchtime_male.length; i++) {
			this.view_watchtime_male[i] = 0;
			this.view_watchtime_female[i] = 0;
		}
		for (int i = 0; i < emotion_positive_male.length; i++) {
			this.emotion_positive_male[i] = 0;
			this.emotion_positive_female[i] = 0;
			this.emotion_negative_male[i] = 0;
			this.emotion_negative_female[i] = 0;
		}
	}
	
	public List<DeviceListVO> getStategender() {
		return stategender;
	}

	public void setStategender(List<DeviceListVO> stategender) {
		this.stategender.addAll(stategender);
	}

	public int getMale() {
		return male;
	}

	public void countUpMale() {
		this.male += 1;
	}

	public int getFemale() {
		return female;
	}

	public void countUpFemale() {
		this.female += 1;
	}

	public int[] getView_age() {
		return view_age;
	}

	public void countUpView_age(int age) {
		this.view_age[age / 10 - 1] += 1;
	}

	public void countUpView_date(int date) {
		this.view_date[date] += 1;
	}

	public int[] getView_date() {
		return view_date;
	}

	public void setDay1(int day1) {
		this.view_date[0] = day1;
	}

	public void setDay2(int day2) {
		this.view_date[1] = day2;
	}

	public void setDay3(int day3) {
		this.view_date[2] = day3;
	}

	public void setDay4(int day4) {
		this.view_date[3] = day4;
	}

	public void setDay5(int day5) {
		this.view_date[4] = day5;
	}

	public void setDay6(int day6) {
		this.view_date[5] = day6;
	}

	public void setDay7(int day7) {
		this.view_date[6] = day7;
	}

	public void setView_date(int[] view_date) {
		this.view_date = view_date;
	}

	public void countUpView_time(int hour_time) {
		this.view_time[hour_time] += 1;
	}

	public void countUpView_Watchtime_male(int watch_seconds) {
		this.view_watchtime_male[watch_seconds - 1] += 1;
	}

	public void countUpView_Watchtime_female(int watch_seconds) {
		this.view_watchtime_female[watch_seconds - 1] += 1;
	}

	public int[] getView_time() {
		return view_time;
	}

	public int[] getView_watchtime_male() {
		return view_watchtime_male;
	}

	public int[] getView_watchtime_female() {
		return view_watchtime_female;
	}

	public void countUpEmotion_PosNeg_gender(int emotionNum, boolean pos_neg, char gender) {
		if(gender == 'M'){
			if(pos_neg) 
				this.emotion_positive_male[emotionNum] += 1;
			else
				this.emotion_negative_male[emotionNum] += 1; 
		} else {
			if(pos_neg) 
				this.emotion_positive_female[emotionNum] += 1;
			else
				this.emotion_negative_female[emotionNum] += 1; 
		}
	}

	public int[] getEmotion_positive_male() {
		return emotion_positive_male;
	}

	public int[] getEmotion_negative_male() {
		return emotion_negative_male;
	}

	public int[] getEmotion_positive_female() {
		return emotion_positive_female;
	}

	public int[] getEmotion_negative_female() {
		return emotion_negative_female;
	}
	
	public int[] getEmotion_positive(){
		int[] result = new int[8];
		for(int i = 0 ; i < result.length ; i++){
			result[i] = this.emotion_positive_male[i] + this.emotion_positive_female[i];
		}
		return result;
	}
	public int[] getEmotion_negative(){
		int[] result = new int[8];
		for(int i = 0 ; i < result.length ; i++){
			result[i] = this.emotion_negative_male[i] + this.emotion_negative_female[i];
		}
		return result;
	}

	@Override
	public String toString() {
		return "ChartAttributes [male=" + male + ", female=" + female + ", view_age=" + Arrays.toString(view_age)
				+ ", view_date=" + Arrays.toString(view_date) + ", view_time=" + Arrays.toString(view_time)
				+ ", view_watchtime_male=" + Arrays.toString(view_watchtime_male) + ", view_watchtime_female="
				+ Arrays.toString(view_watchtime_female) + ", emotion_positive_male="
				+ Arrays.toString(emotion_positive_male) + ", emotion_positive_female="
				+ Arrays.toString(emotion_positive_female) + ", emotion_negative_male="
				+ Arrays.toString(emotion_negative_male) + ", emotion_negative_female="
				+ Arrays.toString(emotion_negative_female) + "]" + this.stategender;
	}

}
