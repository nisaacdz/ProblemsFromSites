

import java.util.ArrayList;
import java.util.List;

public class Lattice {

	public static List<List<Integer>> latticePoints(List<Integer> M, int r) {
		List<List<Integer>> latticePoints = new ArrayList<>();
		int mX = M.get(0);
		int mY = M.get(1);

		int minX = mX - r;
		int maxX = mX + r;
		int minY = mY - r;
		int maxY = mY + r;

		List<Integer> xValues = listUp(minX, maxX, 1);
		List<Integer> yValues = listUp(minY, maxY, 1);

		latticePoints = generateValues(xValues, yValues, mX, mY, r);

		return latticePoints;
	}

	public static List<List<Integer>> generateValues(List<Integer> xValues, List<Integer> yValues, int cX, int cY,
			int r) {
		List<List<Integer>> list = new ArrayList<>();
		ArrayList<Integer> temp;
		for (int x : xValues) {
			for (int y : yValues) {
				boolean puttable = ((x - cX) * (x - cX)) + ((y - cY) * (y - cY)) == r * r;
				if (puttable) {
					temp = new ArrayList<>();
					temp.add(x);
					temp.add(y);
					list.add(temp);
				}
			}
		}

		return list;
	}

	public static List<Integer> listUp(int start, int end, int diff) {
		List<Integer> list = new ArrayList<>();

		for (int i = start; i <= end; i += diff) {
			list.add(i);
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> M = new ArrayList<>();
		M.add(-7);
		M.add(12);

		int r = 18;

		System.out.println(latticePoints(M, r));
	}

}
