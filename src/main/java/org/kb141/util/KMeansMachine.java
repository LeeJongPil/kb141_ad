package org.kb141.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kb141.domain.LogVO;

public class KMeansMachine {

	public int num_cluster; // Total clusters.
	public int total_data; // Total data points.
	public List<LogVO> datalist;

	private ArrayList<Data> dataSet = new ArrayList<Data>();
	private ArrayList<Centroid> centroids = new ArrayList<Centroid>();

	private int[][] cluster_adCount;

	public KMeansMachine(int num_clusters, List<LogVO> datalist) {
		num_cluster = num_clusters;
		this.datalist = datalist;
		total_data = datalist.size();

		cluster_adCount = new int[3][];
		cluster_adCount[0] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		cluster_adCount[1] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		cluster_adCount[2] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	}

	public List<LogVO> getClusterList(int mCluster) {
		List<LogVO> result = new ArrayList<LogVO>();
		for (Data data : dataSet) {
			if (data.getmCluster() == mCluster) {
				result.add(data.getVO());
			}
		}
		return result;
	}

	private static double dist(Data d, Centroid c) {
		return Math.sqrt(Math.pow((c.getmY() - d.getmY()), 2) + Math.pow((c.getmX() - d.getmX()), 2));
	}

	private void initialize(int k) {
		System.out.println("Centroids initialized at:");

		centroids.add(new Centroid(1.0, 0)); // lowest set.
		centroids.add(new Centroid(40.0, 0)); // lowest set.
		centroids.add(new Centroid(70.0, 0)); // lowest set.

		// for (int i = 0 ; i < k ; i++)
		// System.out.println(centroids.get(i).getmX() + "\t" +
		// centroids.get(i).getmY());

		System.out.println();
	}

	private void kMeanCluster() {

		final double bigNumber = Math.pow(10, 10); // some big number that's
													// sure to be larger than
													// our data range.
		double minimum = bigNumber; // The minimum value to beat.
		double distance = 0.0; // The current minimum value.
		int sampleNumber = 0;
		int cluster = 0;
		boolean isStillMoving = true;
		Data newData = null;

		// Add in new data, one at a time, recalculating centroids with each new
		// one.
		while (dataSet.size() < total_data) {

			LogVO current = datalist.get(sampleNumber);

			newData = new Data(current);
			dataSet.add(newData);
			minimum = bigNumber;
			for (int i = 0; i < num_cluster; i++) {
				distance = dist(newData, centroids.get(i));
				if (distance < minimum) {
					minimum = distance;
					cluster = i;
				}
			}
			newData.setmCluster(cluster);

			// calculate new centroids.
			for (int i = 0; i < num_cluster; i++) {
				double totalX = 0; // ��� �� ����� �ٲ�, �Ʒ���
				double totalY = 0;
				double totalInCluster = 0;
				for (int j = 0; j < dataSet.size(); j++) {
					if (dataSet.get(j).getmCluster() == i) {
						totalX += dataSet.get(j).getmX();
						totalY += dataSet.get(j).getmY();
						totalInCluster++;
					}
				}
				if (totalInCluster > 0) {
					centroids.get(i).setmX(totalX / totalInCluster);
					centroids.get(i).setmY(totalY / totalInCluster);
				}
			}
			sampleNumber++;
		}

		// Now, keep shifting centroids until equilibrium occurs.
		while (isStillMoving) {
			// calculate new centroids.
			for (int i = 0; i < num_cluster; i++) {
				double totalX = 0;
				double totalY = 0;
				double totalInCluster = 0;
				for (int j = 0; j < dataSet.size(); j++) {
					if (dataSet.get(j).getmCluster() == i) {
						totalX += dataSet.get(j).getmX();
						totalY += dataSet.get(j).getmY();
						totalInCluster++;
					}
				}
				if (totalInCluster > 0) {
					centroids.get(i).setmX(totalX / totalInCluster);
					centroids.get(i).setmY(totalY / totalInCluster);
				}
			}

			// Assign all data to the new centroids
			isStillMoving = false;

			for (int i = 0; i < dataSet.size(); i++) {
				Data tempData = dataSet.get(i);
				minimum = bigNumber;
				for (int j = 0; j < num_cluster; j++) {
					distance = dist(tempData, centroids.get(j));
					if (distance < minimum) {
						minimum = distance;
						cluster = j;
					}
				}
				tempData.setmCluster(cluster);
				if (tempData.getmCluster() != cluster) {
					tempData.setmCluster(cluster);
					isStillMoving = true;
				}
			}
		}
	}

	public List<Centroid> run() {

		initialize(num_cluster);
		kMeanCluster();

		// Print out clustering results.
		for (int i = 0; i < num_cluster; i++) {
			System.out.println("Cluster " + i + " includes:");
			for (int j = 0; j < total_data; j++) {

				if (dataSet.get(j).getmCluster() == i) {
					System.out.println(dataSet.get(j).getmX() + "\t" + dataSet.get(j).getmY() + "\t"
							+ dataSet.get(j).getVO().getAdno() + "\t" + dataSet.get(j).getVO().getGender());
					// 여기 입맛대로 고쳐야 한다.
					// cluster_adCount[0]
					cluster_adCount[i][dataSet.get(j).getVO().getAdno()]++;
				}
			}
			System.out.println();
		}
		

		// Print out centroid results.
		System.out.println("Centroids finalized at:");

		// double[][] result = new double[num_cluster][];
		List<Centroid> result = new ArrayList<Centroid>();

		for (int i = 0; i < num_cluster; i++) {
			System.out.println(centroids.get(i).getmX() + "\t " + centroids.get(i).getmY());
			// result[i] = centroids.get(i).getCentroids();
			result.add(centroids.get(i));
		}
		System.out.print("\n");

		for (int i = 0; i < 3; i++) {
			int maxAdno = 0;
			int count = 0;
			for (int j = 0; j < 10; j++) {
				// System.out.print(cluster_adCount[i][j] + ", ");
				if (count < cluster_adCount[i][j]) {
					count = cluster_adCount[i][j];
					maxAdno = j;
				}
			}
			// System.out.println();
			centroids.get(i).setAdno(maxAdno);
		}

		return result;

	}

}
