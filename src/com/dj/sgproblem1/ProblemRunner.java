package com.dj.sgproblem1;
import java.util.List;

import com.dj.sgproblem1.algorithm.PopulationStatCalculator;
import com.dj.sgproblem1.data.DatasetGenerator;
import com.dj.sgproblem1.data.Person;
import com.dj.sgproblem1.data.StatisticResults;


public class ProblemRunner {
	
	/**
	 * Problem 1:
	 * Description
     *    Given a list of people with their birth and end years (all between 1900 and 2000), 
     *    find the year with the most number of people alive.
     * Code
     *    Solve using a language of your choice and dataset of your own creation.
     * Submission
     *    Please upload your code, dataset, and example of the program’s output to Bit Bucket or Github. 
     *    Please include any graphs or charts created by your program.
	 **/

	
	private static final int START_YEAR = 1900;
	private static final int END_YEAR = 2000;
	
	public static void main(String[] args) {
//		System.out.println("Start moching data");
//		List<Person> people = DatasetGenerator.getPeopleDataset(START_YEAR,END_YEAR,1000,100000); 
//		System.out.println("End moching data");
//		System.out.println("Saving list to file");
//		DatasetGenerator.printDataSetToFile("GeneratedListOfPeople.txt", people);
//		System.out.println("List saved");
		System.out.println("Retreaving list from file");
		List<Person> peopleNew = DatasetGenerator.getDataSetFromFile("GeneratedListOfPeople.txt");
		System.out.println("List retreaved");
//		System.out.println("Calculating origioinal");
//		PopulationStatCalculator calculator = new PopulationStatCalculator(people,START_YEAR,END_YEAR);
//		StatisticResults results = calculator.calculate();
//		System.out.println(results);
		System.out.println("Calculating from file");
		PopulationStatCalculator calculatorNew = new PopulationStatCalculator(peopleNew,START_YEAR,END_YEAR);
		StatisticResults resultsNew = calculatorNew.calculate();
		System.out.println(resultsNew);
	}

}
