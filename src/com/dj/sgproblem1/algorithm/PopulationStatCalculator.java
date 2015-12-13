package com.dj.sgproblem1.algorithm;

import java.util.List;

import com.dj.sgproblem1.data.Person;
import com.dj.sgproblem1.data.StatisticResults;

public class PopulationStatCalculator {
	private List<Person> mDataSet;
	private int mStartYear;
	private int mEndYear;
	private int [] mCounts;
	private StatisticResults mResultData;
	
	

	public PopulationStatCalculator(List<Person> dataSet,int startYear, int endYear){
		mDataSet = dataSet;
		mStartYear = startYear;
		mEndYear = endYear;
		mCounts = new int[mEndYear - mStartYear];
	}
	/**
	 * Resets all data to be analyzed
	 * @param dataSet
	 * @param startYear
	 * @param endYear
	 * @return PopulationStatCalculator to call calculate()
	 */
	public PopulationStatCalculator resetData(List<Person> dataSet,int startYear, int endYear){
		mDataSet = dataSet;
		mStartYear = startYear;
		mEndYear = endYear;
		mCounts = new int[mEndYear - mStartYear];
		return this;
	}
	
	/**
	 * @return results of calculated data
	 */
	public StatisticResults calculate(){
		
		initCounts();
		generateCountData();
		mResultData = analyzeCountData();
		return mResultData;
	}

	/**
	 * finds the min and max populations (since the beginning of starting year)
	 * and the corresponding years.
	 */
	private StatisticResults analyzeCountData() {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int maxPos = 0;
		int minPos = 0;
		for(int i = 0; i < mCounts.length; i++){
			if(mCounts[i] > max){
				maxPos = i;
				max = mCounts[i];
			}
			if(mCounts[i] < min){
				minPos = i;
				min = mCounts[i];
			}
		}
		return new StatisticResults(minPos + mStartYear, maxPos + mStartYear,
				mStartYear, mEndYear,mCounts);
	}

	/**
	 * This assumes mCounts has been initialized correctly
	 * Runs the number of people born each year 
	 * minus the number of people that die each year
	 * 
	 */
	private void generateCountData() {
		for(int i = 0; i < mDataSet.size(); i++){
			Person person = mDataSet.get(i);
			mCounts[person.getBirth().getYear() - mStartYear]++;
			if((person.getDeath().getYear() - mStartYear)< mCounts.length)
				mCounts[person.getDeath().getYear() - mStartYear]--;
		}
	}

	/**
	 * inisalizes all counts to 0;
	 */
	private void initCounts() {
		for(int i = 0; i < mCounts.length; i++){
			mCounts[i]=0;
		}
	}
	
	/**
	 * @return last calculated data, if null, call calculate()
	 */
	public StatisticResults getResultData() {
		return mResultData;
	}

}
