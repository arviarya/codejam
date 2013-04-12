import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
