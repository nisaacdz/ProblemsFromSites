

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test {

	static List<Integer> toList(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for (int a : arr) {
			list.add(a);
		}
		return list;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 4, 4, 5, 3 };
		System.out.println(migratoryBirds(toList(arr)));
	}

	public static int migratoryBirds(List<Integer> arr) {
		// Write your code here
		Collections.sort(arr);

		Map<Integer, Integer> mp = getMap(arr);

		return findMax(mp);
	}

	private static int findMax(Map<Integer, Integer> arg) {
		int maxValue = 0;
		int maxKey = 0;

		for (Map.Entry<Integer, Integer> each : arg.entrySet()) {
			if (each.getValue() > maxValue) {
				maxValue = each.getValue();
				maxKey = each.getKey();
			}
		}

		return maxKey;
	}

	private static Map<Integer, Integer> getMap(List<Integer> arr) {
		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int a : arr) {
			if (!map.containsKey(a)) {
				map.put(a, 1);
			} else {
				map.put(a, map.get(a) + 1);
			}
		}
		return map;
	}

}
