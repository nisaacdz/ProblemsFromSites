

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Resume {

	/*
	 * Complete the 'getTotalX' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY a 2. INTEGER_ARRAY b
	 */

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		// Write your code here
		List<Integer> nums = getRange(100);
		List<Integer> hypo = new ArrayList<>();
		List<Integer> hypo1 = new ArrayList<>();

		// System.out.println(nums);

		for (int i = 0; i < nums.size(); i++) {
			int temp = nums.get(i);
			int index = 0;
			for (int j = 0; j < a.size(); j++) {
				if (temp % a.get(j) == 0) {
					index++;
				} else {
					break;
				}
			}
			if (index == a.size()) {
				// System.out.println("Added to hypo " + temp);
				hypo.add(temp);
			}
		}

		for (int i = 0; i < hypo.size(); i++) {
			int temp = hypo.get(i);
			int index = 0;
			for (int j = 0; j < b.size(); j++) {
				if (b.get(j) % temp == 0) {
					index++;
				} else {
					break;
				}
			}
			if (index == b.size()) {
				// System.out.println("Added to hypo1 " + temp);
				hypo1.add(temp);
			}
		}

		return hypo1.size();
	}

	private static List<Integer> getRange(int x) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= x; i++) {
			list.add(i);
		}
		return list;
	}

}

public class TestCase {
	public static void main(String[] args) throws IOException {
		int[] aa = { 2, 4 };
		List<Integer> a = toList(aa);
		int[] bb = { 16, 32, 96 };
		List<Integer> b = toList(bb);

		System.out.println(Resume.getTotalX(a, b));

	}

	private static List<Integer> toList(int[] a) {
		List<Integer> l = new ArrayList<>();
		for (int x : a) {
			l.add(x);
		}
		return l;
	}
}
