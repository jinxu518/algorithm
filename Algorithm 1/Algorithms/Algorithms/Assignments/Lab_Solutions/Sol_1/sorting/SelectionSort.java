package sorting;

public class SelectionSort {
	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			print(a);
			int min = min(a, i, a.length);
			int tmp = a[i];
			a[i] = a[min];
			a[min] = tmp;
		}
	}
	
	private static int min(int[] a, int from, int to) {
		int min = from;
		for(int i = from + 1; i < to; i++) {
			if(a[i] < a[min]) {
				min = i;
			}
		}
		return min;
	}

	public static void print(int[] a) {
		for(int i : a) {
			System.out.print(i + ";");
		}
		System.out.println();
	}
	
	public static void main(String... strings) {
		int[] numbers = { 8, 7, 1, 2, 3, 4, 6 };
		sort(numbers);
		print(numbers);
	}
}
