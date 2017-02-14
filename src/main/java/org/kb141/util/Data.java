package org.kb141.util;

import org.kb141.domain.LogVO;

public class Data {
	private LogVO vo;
	private double mX = 0;
	private double mY = 0;
	private int mCluster = 0; // ������ Cluster Group

	public Data(LogVO vo) {
		this.vo = vo;
		this.mX = vo.getAge();
		this.mY = vo.getBeforeEmotion();
	}

	public double getmX() {
		return mX;
	}

	public double getmY() {
		return mY;
	}

	public int getmCluster() {
		return mCluster;
	}

	public void setmCluster(int mCluster) {
		this.mCluster = mCluster;
	}

	public LogVO getVO() {
		return vo;
	}

	
}