

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NewClass {

	public static void main(String[] args) {
		int[] nums = { 3, 3, 3, 1, 2 };
		System.out.println(birthdayCakeCandles(Arrays.stream(nums).boxed().collect(Collectors.toList())));
	}

	public static int birthdayCakeCandles(List<Integer> candles) {
		// Write your code here
		return max(candles).size();
	}

	public static List<Integer> max(List<Integer> candles) {
		List<Integer> maxList = new ArrayList<>();
		int max = Collections.max(candles);

		for (int l : candles) {
			if (l == max) {
				maxList.add(l);
			}
		}
		return maxList;
	}

}
