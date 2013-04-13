package arviarya;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Problem from google codejam @ 2013
 * 
 * Little John likes palindromes, and thinks them to be fair (which is a fancy
 * word for nice). A palindrome is just an integer that reads the same backwards
 * and forwards - so 6, 11 and 121 are all palindromes, while 10, 12, 223 and
 * 2244 are not (even though 010=10, we don't consider leading zeroes when
 * determining whether a number is a palindrome).
 * 
 * He recently became interested in squares as well, and formed the definition
 * of a fair and square number - it is a number that is a palindrome and the
 * square of a palindrome at the same time. For instance, 1, 9 and 121 are fair
 * and square (being palindromes and squares, respectively, of 1, 3 and 11),
 * while 16, 22 and 676 are not fair and square: 16 is not a palindrome, 22 is
 * not a square, and while 676 is a palindrome and a square number, it is the
 * square of 26, which is not a palindrome.
 * 
 * Now he wants to search for bigger fair and square numbers. Your task is,
 * given an interval Little John is searching through, to tell him how many fair
 * and square numbers are there in the interval, so he knows when he has found
 * them all.
 * 
 * -----
 * Solving this problem
 * -----
 * 
 * Usually, Google Code Jam problems have 1 Small input and 1 Large input. This
 * problem has 1 Small input and 2 Large inputs. Once you have solved the Small
 * input, you will be able to download any of the two Large inputs. As usual,
 * you will be able to retry the Small input (with a time penalty), while you
 * will get only one chance at each of the Large inputs.
 * 
 * -----
 * Input
 * -------
 * 
 * The first line of the input gives the number of test cases, T. T lines
 * follow. Each line contains two integers, A and B - the endpoints of the
 * interval Little John is looking at.
 */
public class FairAndSquare {

	final static String PATH = "/Users/arvindkumar/QuantumDB/workspace_trunk_new/CodeTest/src/arviarya";

	public static void main(String[] args) throws Exception {

		final Scanner sc = new Scanner(new FileReader(PATH + "/in.txt"));
		final PrintWriter pw = new PrintWriter(
				new FileWriter(PATH + "/out.txt"));
		final int datasetNumber = sc.nextInt();

		for (int i = 0; i < datasetNumber; i++) {

			final long start = sc.nextLong();
			final long end = sc.nextLong();

			int count = 0;
			for (long j = start; j <= end; j++) {
				if (isPalindrome("" + j)) {
					final double squareRoot = Math.sqrt(j);
					final long squareRootLong = (long) squareRoot;
					if ((squareRootLong == squareRoot)
							&& isPalindrome("" + squareRootLong)) {
						count++;
					}
				}

			}
			pw.print("Case #" + (i + 1) + ": " + count);
			pw.println();

		}

		pw.flush();
		pw.close();
		sc.close();

	}

	private static boolean isPalindrome(String number) {

		String palindrone = "";
		final int length = number.length();

		for (int i = length - 1; i >= 0; i--) {
			palindrone = palindrone + number.charAt(i);
		}

		if (number.equals(palindrone)) {
			return true;
		} else {
			return false;
		}
	}
}
