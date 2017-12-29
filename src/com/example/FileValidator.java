package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class FileValidator {
	void inputPath(String path) {
		
		System.out.println("Inside inputPath--> " + new Date());
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			doValidation(br);
		} catch (IOException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		
		System.out.println("Outside inputPath--> " + new Date());
	}

	void doValidation(BufferedReader br) throws IOException {
		String line = "";
		String cvsSplitBy = ",";
		int i = 1; 
		while ((line = br.readLine()) != null) {

			// use comma as separator
			String[] country = line.split(cvsSplitBy);
			if (country[0] == "" && country[0] == null) {
				System.out.println("Null val for countryName " + i);
			}

			if (!Character.isDigit(country[3].charAt(1))) {
				System.out.println("InValid country Code " + i);
			}

			i++;
		}
	}

}
