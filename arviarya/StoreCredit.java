package com.arviarya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoreCredit {

	/**
	 * Problem: You receive a credit C at a local store and would like to buy
	 * two items. You first walk through the store and create a list L of all
	 * available items. From this list you would like to buy two items that add
	 * up to the entire value of the credit. The solution you provide will
	 * consist of the two integers indicating the positions of the items in your
	 * list (smaller number first).
	 * 
	 * -------
	 * Input
	 * -------
	 * The first line of input gives the number of cases, N. N test cases
	 * follow. For each test case there will be:
	 * 
	 * One line containing the value C, the amount of credit you have at the
	 * store. One line containing the value I, the number of items in the store.
	 * One line containing a space separated list of I integers. Each integer P
	 * indicates the price of an item i
	 * n the store. Each test case will have
	 * exactly one solution.
	 */
	public static void main(String[] args) {

		// first input
		final String totalInputCount = getInput();
		if (totalInputCount != null) {
			final int count = convertToInt(totalInputCount);
			for (int i = 0; i < count; i++) {
				// First parameter -> Credit score
				final int creditScore = convertToInt(getInput());
				final int numberOFItemsSelected = convertToInt(getInput());
				final String items = getInput();
				final String[] charArray = items.split(" ");
				if (numberOFItemsSelected != charArray.length) {
					System.out
							.println("Number of items are not matched to total provided");
					System.exit(1);
				}
				final int[] intArray = new int[numberOFItemsSelected];
				for (int j = 0; j < numberOFItemsSelected; j++) {
					intArray[j] = convertToInt(charArray[j]);
				}

				process(i, creditScore, intArray);
			}
		}

	}

	private static void process(int caseNo, int creditScore, int[] items) {

		boolean isDone = false;
		for (int i = 0; i < items.length; i++) {
			int scoreCount = 0;
			// Do not repeat same item 2 times
			for (int j = i + 1; j < items.length; j++) {
				scoreCount = items[i] + items[j];
				if (scoreCount == creditScore) {
					System.out.println("Case #" + (caseNo + 1) + ": " + (i + 1)
							+ " " + (j + 1));
					isDone = true;
					break;
				}
			}

			if (isDone) {
				break;
			}
		}

		if (!isDone) {
			System.out.println("Fail to get products matching credit score");
		}
	}

	// Read input data
	private static String getInput() {
		final BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (final IOException e) {
			System.out.println("Error!");
			System.exit(1);
		}

		return input;
	}

	private static int convertToInt(String input) {
		int i = 0;
		try {
			i = Integer.valueOf(input);
		} catch (final NumberFormatException e) {
			System.out.println("Error in input parameter!");
			System.exit(1);
		}

		return i;
	}

}
