package com.dj.sgproblem1.data;

public class StatisticResults {
	private int mLeastYear;
	private int mMostYear;
	private int mStartYear;
	private int mEndYear;
	private int[] mData;

	public StatisticResults(int leastYear, int mostYear, int startYear,
			int endYear, int[] data) {
		mLeastYear = leastYear;
		mMostYear = mostYear;
		mStartYear = startYear;
		mEndYear = endYear;
		mData = data;
	}

	@Override
	public String toString() {
		String printOut = "";
		printOut += "The Given data has shown that between the years "
				+ mStartYear + " and " + mEndYear + "\n";
		printOut += "The Year with the greatest increase since " + mStartYear
				+ " was " + mMostYear + " with "
				+ mData[mMostYear - mStartYear] + "\n";
		printOut += "The Year with the least increase since " + mStartYear
				+ " was " + mLeastYear + " with "
				+ mData[mLeastYear - mStartYear] + "\n";
		return printOut;
	}
}
