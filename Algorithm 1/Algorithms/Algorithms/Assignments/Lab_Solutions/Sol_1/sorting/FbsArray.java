package sorting;

public class FbsArray {
	public static void makeFbsArray(int[] a) {
		QuickSort.sort(a, 0, a.length - 1);
		QuickSort.print(a);
		int j = a.length % 2 == 0 ? a.length - 2 : a.length - 1;
		int[] b = new int[a.length];
		for (int i = 0, k = 0; i < a.length - 1; i++, j--, k += 2) {
			b[k] = a[i];
			b[k + 1] = a[j];
		}
		QuickSort.print(b);
	}

	public static void main(String... strings) {
		makeFbsArray(new int[] { 7, 15, 17, 15, 19, 20, 10, 14, 10 });
	}
}
