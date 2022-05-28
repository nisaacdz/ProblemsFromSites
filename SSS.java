

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 0, 0, 1, 0, 0, 1, 1, 0 };
		System.out.println(jumpingOnClouds(arr, 2));
				
		
		List<Integer> l = new ArrayList<>();
	}


	static int jumpingOnClouds(int[] c, int k) {
		// 2 --- 0 0 1 0 0 1 1 0
		int index = 0;
		int n = c.length;
		int e = 100;

		while (e > 0) {
			index = (index + k) % n;

			e -= c[index] == 1 ? 3 : 1;

			if (index == 0)
				break;
		}

		return e;

	}

}
