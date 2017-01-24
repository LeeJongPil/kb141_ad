package org.kb141.util;

import java.util.Arrays;

public class ChartAttributes {
	
	private int male, female;
	private int[] view_age = new int[]{0,0,0,0,0,0,0};
	private int[] view_date = new int[]{0,0,0,0,0,0,0};
	private int[] view_time = new int[24];
	
	public ChartAttributes() {
		for (int i = 0; i < view_time.length; i++) {
			this.view_time[i] = 0;
		}
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
		this.view_age[age/10 - 1] += 1;
	}

	public void countUpView_date(int date){
		this.view_date[date] += 1;
	}
	
	public int[] getView_date() {
		return view_date;
	}
	
	public void setDay1(int day1){
		this.view_date[0] = day1;
	}
	
	public void setDay2(int day2){
		this.view_date[1] = day2;
	}
	
	public void setDay3(int day3){
		this.view_date[2] = day3;
	}
	
	public void setDay4(int day4){
		this.view_date[3] = day4;
	}
	
	public void setDay5(int day5){
		this.view_date[4] = day5;
	}
	
	public void setDay6(int day6){
		this.view_date[5] = day6;
	}
	
	public void setDay7(int day7){
		this.view_date[6] = day7;
	}
	
	public void setView_date(int[] view_date) {
		this.view_date = view_date;
	}
	
	public void countUpView_time(int hour_time){
		this.view_time[hour_time] += 1;
	}
	
	public int[] getView_time() {
		return view_time;
	}

	@Override
	public String toString() {
		return "ChartAttributes [male=" + male + ", female=" + female + ", view_age=" + Arrays.toString(view_age)
				+ ", view_date=" + Arrays.toString(view_date) + ", view_time=" + Arrays.toString(view_time) + "]";
	}

}
