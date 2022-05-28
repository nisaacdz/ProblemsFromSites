

//This is a java program to print all possible combinations out of a, b, c, d, e

public class AllPossibleCombinatons {
	static void printCombinations(char[] sequence, int N) {
		char[] data = new char[N];
		// for (int r = 0; r < sequence.length; r++)
		combinations(sequence, data, 0, N - 1, 0, 3);
	}

	static void combinations(char[] sequence, char[] data, int start, int end, int index, int r) {

		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println();
		}

		for (int i = start; i <= end && ((end - i + 1) >= (r - index)); i++) {
			data[index] = sequence[i];
			combinations(sequence, data, i + 1, end, index + 1, r);
		}
	}

	public static void main(String args[]) {
		char[] sequence = { '0', '1', '2', '3', '4'};
		System.out.print("The combinations are: ");
		printCombinations(sequence, sequence.length);
	}
}