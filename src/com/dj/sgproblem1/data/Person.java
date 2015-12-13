package com.dj.sgproblem1.data;



public class Person {

	private Date mBirth;
	private Date mDeath;
	
	public Person(Date birth, Date death){
		mBirth = birth;
		mDeath = death;
	}
	public Date getDeath(){
		return mDeath;
	}
	public Date getBirth(){
		return mBirth;
	}
	@Override
	public String toString(){
		return mBirth.toString() +","+mDeath.toString();
	}
	
}
