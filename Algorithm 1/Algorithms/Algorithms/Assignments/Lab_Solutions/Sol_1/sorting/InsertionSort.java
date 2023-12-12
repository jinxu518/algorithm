package sorting;

public class InsertionSort {
	public static void sort(int[] a) {
		int j = 0;
		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			print(a);
			j = i;
			temp = a[i];
			while(j > 0 && temp < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
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
