package sorting;

public class HeapSort {
	private int maxChildren(int[] numbers, int j, int length) {
		if (j * 2 + 1 > length) {
			return -1;
		}
		
		int child1 = numbers[j * 2 + 1];
		int child2 = Integer.MIN_VALUE;
		if(j * 2 + 2 <= length) {
			child2 = numbers[j * 2 + 2];
		}
		
		if (numbers[j] >= child1 && numbers[j] >= child2) {
			return -1;
		}

		return child1 > child2 ? j * 2 + 1 : j * 2 + 2;
	}

	private void downHeap(int[] numbers, int i, int length) {
		int j = i, tmp;
		int maxChild = maxChildren(numbers, j, length);
		while (maxChild >= 0) {
			tmp = numbers[j];
			numbers[j] = numbers[maxChild];
			numbers[maxChild] = tmp;
			j = maxChild;
			maxChild = maxChildren(numbers, j, length);
		}
	}

	/**
	 * Heapify an array of numbers using bottom-down approach
	 * 
	 * @param numbers
	 */
	public void heapify(int[] numbers, int right) {
		for (int i = right / 2; i >= 0; i--) {
			downHeap(numbers, i, right);
		}
	}
	
	public void sort(int[] numbers) {
		for(int right = numbers.length - 1; right > 0; right--) {
			heapify(numbers, right);
			int tmp = numbers[0];
			numbers[0] = numbers[right];
			numbers[right] = tmp;
		}
	}

	public static void print(int[] numbers) {
		for (int i : numbers) {
			System.out.print(i + " ");
		}
	}

	public static void main(String... strings) {
		int[] numbers = { 2, 9, 7, 6, 5, 8, 10, 3, 6, 9 };
		HeapSort.print(numbers);
		HeapSort hs = new HeapSort();
		hs.sort(numbers);
		System.out.println();
		HeapSort.print(numbers);
	}
}
