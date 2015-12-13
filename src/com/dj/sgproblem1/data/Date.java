package com.dj.sgproblem1.data;
public class Date{
	private int mYear;
	private int mMonth;
	private int mDay;
	
	public Date(int year, int month, int day){
		mYear = year;
		mMonth = month;
		mDay = day;
	}
	public int getYear(){
		return mYear;
	}
	public int getMonth(){
		return mMonth;
	}
	public int getDay(){
		return mDay;
	}
	@Override
	public String toString(){
		return mYear+","+mMonth+","+mDay;
	}
}
