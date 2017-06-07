package com.algorithms.tasks.maxmoney;

public class MaxMoney {

	public int calculateMaxMoney(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}

		int[] impacts = new int[array.length];
		calculateImpacts(0, array.length, array, impacts);
		double[] impactAvoidance = new double[array.length];
		calculateImpactAvoidance(0, array.length, impacts, impactAvoidance);
		return calculateMaxMoney(0, array.length, array, impacts, impactAvoidance);
	}

	private int calculateMaxMoney(int startIdx, int endIdx, int[] array, int[] impacts, double[] impactAvoidance) {
		// Out of range
		if (startIdx >= endIdx) {
			return 0;
		}
		// Only one element to inspect
		if (startIdx == endIdx - 1) {
			return array[startIdx];
		}
		int maxImpactAvoidanceIdx = findMaxIndex(impactAvoidance, startIdx, endIdx);
		int tempSum = array[maxImpactAvoidanceIdx];

		calculateImpacts(startIdx, maxImpactAvoidanceIdx - 1, array, impacts);
		calculateImpactAvoidance(startIdx, maxImpactAvoidanceIdx - 1, impacts, impactAvoidance);
		calculateImpacts(maxImpactAvoidanceIdx + 2, endIdx, array, impacts);
		calculateImpactAvoidance(maxImpactAvoidanceIdx + 2, endIdx, impacts, impactAvoidance);

		int leftSum = calculateMaxMoney(startIdx, maxImpactAvoidanceIdx - 1, array, impacts, impactAvoidance);
		int rightSum = calculateMaxMoney(maxImpactAvoidanceIdx + 2, endIdx, array, impacts, impactAvoidance);

		return tempSum + leftSum + rightSum;
	}

	private void calculateImpacts(int startIdx, int endIdx, int[] array, int[] impacts) {
		if (startIdx >= endIdx - 1) {
			return;
		}
		for (int i = startIdx; i < endIdx; i++) {
			if (i == startIdx) {
				impacts[i] = array[i + 1];
			} else if (i == endIdx - 1) {
				impacts[i] = array[i - 1];
			} else {
				impacts[i] = array[i - 1] + array[i + 1];
			}
		}
	}

	private void calculateImpactAvoidance(int startIdx, int endIdx, int[] impacts,
			double[] impactAvoidance) {
		if (startIdx >= endIdx - 1) {
			return;
		}
		for (int i = startIdx; i < endIdx; i++) {
			if (i == startIdx) {
				impactAvoidance[i] = impacts[i + 1];
			} else if (i == endIdx - 1) {
				impactAvoidance[i] = impacts[i - 1];
			} else {
				impactAvoidance[i] = (double) (impacts[i - 1] + impacts[i + 1]) - impacts[i];
			}
		}
	}

	private int findMaxIndex(double[] array, int startIdx, int endIdx) {
		int maxIdx = startIdx;
		double maxVal = array[startIdx];
		for (int i = startIdx; i < endIdx; i++) {
			if (array[i] > maxVal) {
				maxIdx = i;
				maxVal = array[i];
			}
		}
		return maxIdx;
	}

}
