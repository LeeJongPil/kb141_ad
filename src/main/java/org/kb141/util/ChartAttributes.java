package org.kb141.util;

import java.util.Arrays;

public class ChartAttributes {
	
	private int male, female;
	private int[] view_age = new int[]{0,0,0,0,0,0,0};
		
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

	@Override
	public String toString() {
		return "ChartAttributes [male=" + male + ", female=" + female + ", view_age=" + Arrays.toString(view_age) + "]";
	}
	
}
