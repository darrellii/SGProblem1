package com.dj.sgproblem1.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.dj.sgproblem1.data.Date;

public class DatasetGenerator {
	/**
	 * Generates a semi-random list of people who where born between the given
	 * dates
	 * 
	 * @param startYear
	 * @param endYear
	 * @param startBirthRate
	 * @param endBirthRate
	 * @return generated list of people
	 */
	public static List<Person> getPeopleDataset(int startYear, int endYear,
			int startBirthRate, int endBirthRate) {
		// for sake of ease, this algorithm assumes a linear population growth.
		int popGrowthRatio = (endBirthRate - startBirthRate)
				/ (endYear - startYear);
		int population = startBirthRate;

		Random random = new Random(System.currentTimeMillis());

		List<Person> people = new ArrayList<Person>();

		for (int i = startYear; i < endYear; i++) {
			for (int j = 0; j < population; j++) {
				Date birth = new Date(i, random.nextInt(12), random.nextInt(28));
				// death = retirement age +/- 7 years
				Date death = new Date(i + 55 + (random.nextInt(14) - 7),
						random.nextInt(12), random.nextInt(28));

				Person person = new Person(birth, death);
				people.add(person);
			}
			// popGrowthRatio * between %80-%120
			double randomPopulationGrowth = ((double) (random.nextInt(40) + 80)) / 100.0;
			population += popGrowthRatio * randomPopulationGrowth;
		}

		return people;
	}

	/**
	 * writes the given list of people to the given file
	 * 
	 * @param fileName
	 * @param people
	 * @return true if the file was printed 
	 */
	public static boolean printDataSetToFile(String fileName, List<Person> people) {

		PrintWriter writer;
		boolean didPrint = true;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
			for(Person p : people){
				writer.println(p.toString());
			}
			writer.close();
		} catch (Exception e) {
			didPrint = false;
		} 
		
		return didPrint;
	}

	/**
	 * Given a file location returns a list people from file
	 * 
	 * @param fileName
	 * @return null if wrong file type
	 */
	public static List<Person> getDataSetFromFile(String fileName) {
		List<Person> people = new ArrayList<Person>();
		BufferedReader bufferedReader = null;
		try {

			FileReader fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			String line = null;
			// Line should be
			// "birthYear,birthMonth,birthDay,deathYear,deathMonth,deathDay"
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(",");
				if (array.length != 6) {
					people = null;
					break;
				} else {
					people.add(new Person(new Date(Integer.valueOf(array[0]),
							Integer.valueOf(array[1]), Integer
									.valueOf(array[2])), new Date(Integer
							.valueOf(array[3]), Integer.valueOf(array[4]),
							Integer.valueOf(array[5]))));
				}

			}
			bufferedReader.close();

		} catch (Exception all) {
			people = null;
		} 
		return people;
	}
}
