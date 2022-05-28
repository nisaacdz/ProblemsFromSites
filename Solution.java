

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Result {

	/*
	 * Complete the 'findSubstring' function below.
	 *
	 * The function is expected to return a STRING. The function accepts following
	 * parameters: 1. STRING s 2. INTEGER k
	 */

	public static String findSubstring(String s, int k) {
		// Write your code here
		List<String> list1 = possibleSubstrings(s, k);
		Map<String, Integer> map1 = toMap(list1);
		System.out.println(map1);
		int maxValue = maxEntry(map1);
		if (maxValue == 0) {
			return "Not found!";
		}

		String keyString = getFirstOccurenceOf(maxValue, map1);

		return keyString;
	}

	private static String getFirstOccurenceOf(int maxValue, Map<String, Integer> map1) {
		for (String s : map1.keySet()) {
			if (map1.get(s) == maxValue) {
				return s;
			}
		}
		return null;
	}

	public static int maxEntry(Map<String, Integer> args) {
		int maxValue = 0;
		for (String temp : args.keySet()) {
			int c = args.get(temp);
			if (c > maxValue) {
				maxValue = c;
			}
		}
		return maxValue;
	}

	public static Map<String, Integer> toMap(List<String> arg) {
		Map<String, Integer> m = new LinkedHashMap<>();
		for (String each : arg) {
			m.put(each, countVowels(each));
		}
		return m;
	}

	public static List<String> possibleSubstrings(String s, int number) {
		int j = s.length();
		int N = j - number + 1;
		List<String> returnValue = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String temp = s.substring(i, i + number);
			returnValue.add(temp);
		}

		return returnValue;
	}

	public static int countVowels(String s) {

		/*
		 * List<Character> dCharList = new ArrayList<>();
		 * 
		 * for (char value : s.toCharArray()) { if (!dCharList.contains(value)) {
		 * dCharList.add(value); } }
		 */

		String v = "aeiou";
		List<Character> vowels = toList(v.toCharArray());
		int returnValue = 0;
		for (char c : s.toCharArray()) {
			if (vowels.contains(c)) {
				returnValue += 1;
			}
		}
		return returnValue;
	}

	public static List<Character> toList(char[] arr) {
		List<Character> l1 = new ArrayList<>();
		for (char s : arr) {
			l1.add(s);
		}
		return l1;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {

		/*
		 * BufferedReader bufferedReader = new BufferedReader(new
		 * InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		 * BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH"))); String s =
		 * bufferedReader.readLine(); int k =
		 * Integer.parseInt(bufferedReader.readLine().trim()); String result =
		 * Result.findSubstring(s, k); bufferedWriter.write(result);
		 * bufferedWriter.newLine(); bufferedReader.close(); bufferedWriter.close();
		 */
		System.out.println(Result.findSubstring("caberqiitefg", 5));
	}
}
