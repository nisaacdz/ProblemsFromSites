

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoCharsR {

	public static void main(String[] args) {
		System.out.println(alternate("a"));
	}

	public static int alternate(String s) {
		// Write your code here
		List<Integer> sizes = new ArrayList<>();
		List<Character> distinctChars = listOfDifferentChars(s);
		List<List<Integer>> remChars = new ArrayList<>();

		if (distinctChars.size() == 0 || distinctChars.size() == 1) {
			return 0;
		}
		if (distinctChars.size() == 2) {
			return isAlternatingTwoChars(s) ? s.length() : 0;
		}
		if (distinctChars.size() > 2) {
			int dSize = distinctChars.size();
			remChars = generateRemovalList(dSize);
			for (List<Integer> lst : remChars) {
				String tempS = removeAll(s, distinctChars, lst);

				if (isAlternatingTwoChars(tempS)) {
					sizes.add(tempS.length());
				} else {
					sizes.add(0);
				}
			}
		}

		return Collections.max(sizes);
	}

	public static String removeAll(String s, List<Character> dChars, List<Integer> list) {
		String tempS = s;
		for (int index : list) {
			char removing = dChars.get(index);
			tempS = tempS.replaceAll(String.valueOf(removing), "");
		}
		return tempS;
	}

	public static List<List<Integer>> generateRemovalList(int dSize) {
		List<Integer> sq = new ArrayList<Integer>();

		for (int i = 0; i < dSize; i++) {
			sq.add(i);
		}

		List<Integer> dt = new ArrayList<>();
		List<List<Integer>> b = new ArrayList<>();
		int r = elementsLength(dSize);
		int start = 0;
		int end = dSize - 1;
		int index = 0;

		b = com(sq, dt, start, end, index, r, b);

		return b;
	}

	public static List<List<Integer>> com(List<Integer> s, List<Integer> d, int start, int end, int index, int r,
			List<List<Integer>> b) {
		if (index == r) {
			List<Integer> temp = new ArrayList<>(r);
			for (int j = 0; j < r; j++) {
				temp.add(d.get(j));
			}

			b.add(temp);
		}

		for (int i = start; i <= end && ((end - i + 1) >= (r - index)); i++) {
			d.add(index, s.get(i));
			com(s, d, i + 1, end, index + 1, r, b);
		}
		return b;
	}

	public static int elementsLength(int a) {
		return a - 2;
	}

	// int a represents the size of the list of distinct characters
	public static int combinationsLength(int a) {
		int returnValue = 0;

		if (a > 2) {
			int sum = 0;
			while (a > 0) {
				a--;
				sum += a;
			}
			returnValue = sum;
		}

		return returnValue;
	}

	public static List<Character> listOfDifferentChars(String ori) {
		List<Character> dCharList = new ArrayList<>();

		for (char value : ori.toCharArray()) {
			if (!dCharList.contains(value)) {
				dCharList.add(value);
			}
		}
		return dCharList;
	}

	public static boolean isAlternatingTwoChars(String arg) {

		boolean truth = false;

		int index = 0;

		int n = arg.length();

		if (n > 1) {
			char firstChar = arg.charAt(0);
			char secondChar = arg.charAt(1);

			for (char value : arg.toCharArray()) {
				if (index % 2 == 0) {
					truth = value == firstChar;
				} else {
					truth = value == secondChar;
				}
				if (truth == false) {
					break;
				}
				index++;
			}

			return truth;
		} else {
			return false;
		}
	}

}