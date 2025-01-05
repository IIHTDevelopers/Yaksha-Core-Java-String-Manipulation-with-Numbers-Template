package com.yaksha.assignment;

public class StringWithNumbersAssignment {

	public static void main(String[] args) {

		// Step 1: Declare a string containing numbers
		String str1 = "The total cost is 150 dollars.";

		// Step 2: Convert a number to a string
		String numToStr = String.valueOf(250);

		// Step 3: Parse a number from the string
		String str2 = "100";
		int parsedNumber = Integer.parseInt(str2);

		// Step 4: Perform arithmetic operation
		int totalCost = parsedNumber + 50;

		// Step 5: Check if the string contains a number
		boolean containsNumber = str1.matches(".*\\d+.*");

		// Print the results
		System.out.println("Converted Number to String: " + numToStr);
		System.out.println("Parsed Number: " + parsedNumber);
		System.out.println("Total Cost: " + totalCost);
		System.out.println("Contains Number: " + containsNumber);
	}
}
