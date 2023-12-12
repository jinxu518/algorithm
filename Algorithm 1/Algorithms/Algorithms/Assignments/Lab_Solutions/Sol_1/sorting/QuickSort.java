package sorting;

public class QuickSort {
	private static int paritition(int[] a, int pivot, int left, int right) {
		int i = left;
		int j = right - 1;
		while (i <= j) {
			while (a[i] < pivot) {
				i++;
				if(i > j) {
					break;
				}
			}
			while (a[j] > pivot) {
				j--;
				if(i > j) {
					break;
				}
			}
			if(i > j) {
				break;
			}
			
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			i++;
			j--;
		}

		return i;
	}

	/**
	 * 1. Pick a pivot value<br/>
	 * 2. Partition in to 3 parts based on pivot <br/>
	 * 3. Recursively calls
	 * 
	 * @param a
	 */
	public static void sort(int[] a, int left, int right) {
		if (a.length < 2 || left > right) {
			return;
		}

		int pivotIndex = left;
		int pivot = a[pivotIndex];
		a[pivotIndex] = a[right];
		a[right] = pivot;

		int i = paritition(a, pivot, left, right);
		a[right] = a[i];
		a[i] = pivot;
		print(a);
		sort(a, left, i - 1);
		sort(a, i + 1, right);
	}
	
	public static void print(int[] a) {
		for(int i : a) {
			System.out.print(i + ";");
		}
		System.out.println();
	}
	
	public static int select(int[] a, int nth, int left, int right) {
		if(a.length == 0 || a.length < nth) {
			return -1;
		}
		
		int pivotIndex = left;
		int pivot = a[pivotIndex];
		a[pivotIndex] = a[right];
		a[right] = pivot;
		
		int i = paritition(a, pivot, left, right);
		a[right] = a[i];
		a[i] = pivot;
		print(a);
		if(nth > Math.abs(left - i) && nth <= (Math.abs(left - i) + 1)) {
			return pivot;
		} else if(nth < Math.abs(left - i)) {
			return select(a, nth, 0, Math.abs(left - i) - 1);
		} else {
			return select(a, nth - Math.abs(left - i) - 1, i + 1, right);
		}
	}

	public static void main(String... strings) {
//		int[] numbers = { 5, 7, 10, 1, 3, 6, 20, 11, 8 };
		int[] numbers = { 8, 7, 6, 5 , 4, 3, 2, 1, 9 };
		//sort(numbers, 0, numbers.length - 1);
		System.out.println(select(numbers, 5, 0, numbers.length - 1));
	}
}
