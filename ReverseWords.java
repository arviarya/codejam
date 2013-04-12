import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 Problem given in Google Code jam @  2010 Qualification Round
 Given a list of space separated words, reverse the order of the words. 
 Each line of text contains L letters and W words. 
 A line will only consist of letters and space characters.
 There will be exactly one space character between each pair of consecutive words.
 
 Input data:
 First line of input - Enter a 'numer' indicating number of rows to be entered for test
 Second onwards Line input - Provide number of lines in input to satisfy 'count' given in line 1.
 
 Ex:
 line 1: 2
 this is a test
 we are trying well
 
 
 Output:
 test a is this
 well trying are we
 
 */
 
public class ReverseWords {

	public static void main(String[] args) {

		// first input
		List<String> inputStringList = null;
		String totalCount = getInput();
		if (totalCount != null) {
			int count = Integer.valueOf(totalCount);
			inputStringList = new ArrayList<String>(count);
			for (int i = 0; i < count; i++) {
				inputStringList.add(getInput());
			}
		}

		int p = 1;
		String finalString = "";
		for (String str : inputStringList) {
			String[] charArray = str.split(" ");

			for (int i = 0; i < charArray.length; i++) {
				finalString = finalString + " "
						+ charArray[charArray.length - (i + 1)];
			}

			System.out.println("Case #" + p++ + ":" + finalString);
			finalString = "";
		}

	}

    // Read input data
	private static String getInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = br.readLine();
		} catch (IOException e) {
			System.out.println("Error!");
			System.exit(1);
		}

		return input;
	}


}
