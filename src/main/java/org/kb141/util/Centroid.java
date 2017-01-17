package org.kb141.util;

public class Centroid {
	private double mX = 0.0;
	private double mY = 0.0;

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
	
	public double[] getCentroids() {
		return new double[] {this.mX , this.mY };
	}

	@Override
	public String toString() {
		return "Centroid [mX=" + mX + ", mY=" + mY + "]";
	}

}
