package sorting;

public class BubbleSort {
	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			print(a);
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
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
