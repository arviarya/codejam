package arviarya;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem
 * 
 * Alice and Bob have a lawn in front of their house, shaped like an N metre by
 * M metre rectangle. Each year, they try to cut the lawn in some interesting
 * pattern. They used to do their cutting with shears, which was very
 * time-consuming; but now they have a new automatic lawnmower with multiple
 * settings, and they want to try it out.
 * 
 * The new lawnmower has a height setting - you can set it to any height h
 * between 1 and 100 millimetres, and it will cut all the grass higher than h it
 * encounters to height h. You run it by entering the lawn at any part of the
 * edge of the lawn; then the lawnmower goes in a straight line, perpendicular
 * to the edge of the lawn it entered, cutting grass in a swath 1m wide, until
 * it exits the lawn on the other side. The lawnmower's height can be set only
 * when it is not on the lawn.
 * 
 * Alice and Bob have a number of various patterns of grass that they could have
 * on their lawn. For each of those, they want to know whether it's possible to
 * cut the grass into this pattern with their new lawnmower. Each pattern is
 * described by specifying the height of the grass on each 1m x 1m square of the
 * lawn.
 * 
 * The grass is initially 100mm high on the whole lawn.
 * 
 * Input
 * 
 * The first line of the input gives the number of test cases, T. T test cases
 * follow. Each test case begins with a line containing two integers: N and M.
 * Next follow N lines, with the ith line containing M integers ai,j each, the
 * number ai,j describing the desired height of the grass in the jth square of
 * the ith row.
 * 
 * Output
 * 
 * For each test case, output one line containing "Case #x: y", where x is the
 * case number (starting from 1) and y is either the word "YES" if it's possible
 * to get the x-th pattern using the lawnmower, or "NO", if it's impossible
 * (quotes for clarity only).
 * 
 * @author arvindkumar
 * 
 */
public class Lawnmower {

	final static String PATH = "/Users/arvindkumar/QuantumDB/workspace_trunk_new/CodeTest/src/arviarya";

	public static void main(String[] args) throws Exception {

		final Scanner sc = new Scanner(new FileReader(PATH + "/in.txt"));
		final PrintWriter pw = new PrintWriter(
				new FileWriter(PATH + "/out.txt"));
		final int datasetNumber = sc.nextInt();

		for (int i = 0; i < datasetNumber; i++) {
			final int length = sc.nextInt();
			sc.nextLine();

			final Set<String> samePatternSet = new HashSet<String>();

			for (int p = 0; p < length; p++) {
				samePatternSet.add(sc.nextLine());
			}

			pw.print("Case #" + (i + 1) + ": ");

			pw.print(checkPossibility(samePatternSet));

			pw.println();

		}

		pw.flush();
		pw.close();
		sc.close();

	}

	private static String checkPossibility(Set<String> samePatternSet) {

		int patternCount = 0;
		for (final String pattern : samePatternSet) {
			final String[] data = pattern.split(" ");
			for (int i = 0; i < data.length; i++) {
				// Non-equal data set should only be one
				if (!data[0].equals(data[i])) {
					patternCount++;
					break;
				}
			}
		}

		if (patternCount > 1) {
			return "NO";
		} else {
			return "YES";
		}
	}
}
