package org.kb141.util;

import org.kb141.domain.KmeansTestVO;

public class Data {
	private KmeansTestVO vo;
	private double mX = 0;
	private double mY = 0;
	private int mCluster = 0; // ������ Cluster Group

	public Data(KmeansTestVO vo) {
		this.vo = vo;
		this.mX = vo.getAge();
		this.mY = vo.getEmotion_after() - vo.getEmotion_before();
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

	public KmeansTestVO getVO() {
		return vo;
	}

	
}