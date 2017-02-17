package org.kb141.util;

public class Centroid {
	private double mX = 0.0;
	private double mY = 0.0;
	private int adno;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Centroid(double newX, double newY) {
		this.mX = newX;
		this.mY = newY;
	}

	public double getmX() {
		return mX;
	}

	public void setmX(double mX) {
		this.mX = mX;
	}

	public double getmY() {
		return mY;
	}

	public void setmY(double mY) {
		this.mY = mY;
	}

	public int getAdno() {
		return adno;
	}

	public void setAdno(int adno) {
		this.adno = adno;
	}

	public double[] getCentroids() {
		return new double[] { this.mX, this.mY };
	}

	@Override
	public String toString() {
		return "Centroid [mX=" + mX + ", mY=" + mY + ", adno=" + adno + ", gender=" + gender + "]";
	}

}
