import java.util.Arrays;

public class HeapTopDown {

	static int comparisons = 0;
	static int swaps = 0;

	public static void main(String[] args) {

		int[] A = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		topDown(A);
		System.out.println(Arrays.toString(A));
		System.out.println(comparisons + " C " + "\n"
				+ swaps + " S");

	}

	public static void topDown(int[] A) {
		for (int i = 1; i < A.length; i++) {
			upHeap(A, i);
		}
	}

	public static void upHeap(int[] A, int i) {
		int j = i;

		while (j > 1) {
			comparisons++;
			if (A[j / 2] < A[j]) {

				int temp = A[j / 2];
				A[j / 2] = A[j];
				A[j] = temp;
				swaps++;
			}
			j /= 2;
		}
	}

}
