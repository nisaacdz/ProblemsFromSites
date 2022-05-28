

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class RR {

	/*
	 * Complete the 'possibleChanges' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * STRING_ARRAY usernames as parameter.
	 */

	public static List<String> possibleChanges(List<String> usernames) {
		// Write your code here
		List<String> ans = new ArrayList<>();
		boolean k = false;

		for (String name : usernames) {
			List<List<Integer>> indices = generateSwaps(name.length());
			for (List<Integer> swap : indices) {
				if (firstIsSmaller(implementSwap(name, swap), name)) {
					ans.add("YES");
					k = true;
					break;
				}
			}

			if (k)
				continue;
			ans.add("NO");
		}

		return ans;
	}

	private static String implementSwap(String s, List<Integer> indices) {
		int indexA = indices.get(0);
		int indexB = indices.get(1);
		char a = s.charAt(indexA);
		char b = s.charAt(indexB);

		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(indexA, a);
		sb.setCharAt(indexB, b);
		return sb.toString();
	}

	private static List<List<Integer>> generateSwaps(int stringLength) {
		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < stringLength; i++) {

			int k = i + 1;
			while (k < stringLength) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				list.add(k);
				ans.add(list);
				k++;
			}

		}

		return ans;
	}

	private static boolean firstIsSmaller(String first, String second) {
		boolean returnValue = true;

		for (int k = 0; k < first.length(); k++) {
			if (getLetterCode(first.charAt(k)) > getLetterCode(second.charAt(k)))
				return false;
		}

		char lastA = first.charAt(first.length() - 1);
		char lastB = second.charAt(second.length() - 1);

		if (getLetterCode(lastA) == getLetterCode(lastB)) {
			return false;
		}

		return returnValue;
	}

	private static int getLetterCode(char letter) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		return alphabet.indexOf(letter);
	}

}

public class ClassOne {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int usernamesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> usernames = IntStream.range(0, usernamesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(toList());

		List<String> result = RR.possibleChanges(usernames);

		bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
