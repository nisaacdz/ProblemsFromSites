

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class R {

	public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
		// Write your code here
		List<Integer> ans = new ArrayList<>();
		int s = a.size();

		for (int q : queries) {
			int pos = ((q - k) % s + s) % s;
			ans.add(a.get(pos));
		}

		return ans;
	}
}

public class Another {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] line1 = sc.nextLine().split(" ");

		int n = Integer.parseInt(line1[0]);
		int k = Integer.parseInt(line1[1]);
		int q = Integer.parseInt(line1[2]);

		List<Integer> a = new ArrayList<>();

		String[] line2 = sc.nextLine().split(" ");

		for (String s : line2) {
			a.add(Integer.parseInt(s));
		}

		List<Integer> queries = new ArrayList<>();
		for (int i = 0; i < q; i++) {
			queries.add(Integer.parseInt(sc.nextLine()));
		}

		sc.close();

		System.out.println(R.circularArrayRotation(a, k, queries));

	}

}
