

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(caesarCipher("abcdR-fghijklmnop-qrstuvwxyz", 3));
	}

	public static String caesarCipher(String s, int k) {
		StringBuilder sb = new StringBuilder();
		// Write your code here
		for (char c : s.toCharArray()) {
			if (isALetterOfTheAlphabet(c)) {
				c = shiftChar(c, k);
			}
			sb.append(c);
		}

		return sb.toString();
	}

	public static char shiftChar(char q, int k) {
		char[] a = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		List<Character> alphabet1 = toList(a);
		List<Character> alphabet2 = toList(b);

		if (alphabet1.contains(q)) {
			int before = alphabet1.indexOf(q);

			int after = (before + k) % 26;
			return alphabet1.get(after);

		} else {
			int before = alphabet2.indexOf(q);

			int after = (before + k) % 26;
			return alphabet2.get(after);

		}

	}

	public static boolean isALetterOfTheAlphabet(char c) {
		char[] a = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] b = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		List<Character> alphabet1 = toList(a);
		List<Character> alphabet2 = toList(b);
		return alphabet1.contains(c) || alphabet2.contains(c);
	}

	public static List<Character> toList(char[] array) {
		List<Character> l = new ArrayList<>();
		for (char c : array) {
			l.add(c);
		}
		return l;
	}

}
