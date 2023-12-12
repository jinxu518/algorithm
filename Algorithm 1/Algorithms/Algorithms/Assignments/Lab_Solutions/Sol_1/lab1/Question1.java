import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Find the largest distance between any two even integers in an integer array
 */
public class Question1 {
	/**
	 * Create a new array consisting of even numbers only. Then use nested loops to
	 * solve the problem using the newly created array of even numbers only
	 */
	public static int findLargestDistance1(int[] numbers) {
		int maxDistance = Integer.MIN_VALUE;
		int[] evens = {};
		for (int n : numbers) {
			if (n % 2 == 0) {
				int[] tmpEvens = new int[evens.length + 1];
				System.arraycopy(evens, 0, tmpEvens, 0, evens.length);
				tmpEvens[evens.length] = n;
				evens = tmpEvens;
			}
		}
		for (int i = 0; i < evens.length - 1; i++) {
			for (int j = i + 1; j < evens.length; j++) {
				int distance = Math.abs(evens[i] - evens[j]);
				if (maxDistance < distance) {
					maxDistance = distance;
				}
			}
		}

		return maxDistance;
	}

	/**
	 * Use a nested loop to solve the problem without creating an extra array
	 */
	public static int findLargestDistance2(int[] numbers) {
		int maxDistance = Integer.MIN_VALUE;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] % 2 != 0) {
				continue;
			}
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[j] % 2 != 0) {
					continue;
				}
				int distance = Math.abs(numbers[i] - numbers[j]);
				if (maxDistance < distance) {
					maxDistance = distance;
				}
			}
		}

		return maxDistance;
	}

	/**
	 * Use one loop. Find max and min of even integers. Compute max - min
	 */
	public static int findLargestDistance3(int[] numbers) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int n : numbers) {
			if (n % 2 == 0) {
				if (n < min) {
					min = n;
				}
				if (n > max) {
					max = n;
				}
			}
		}

		return max - min;
	}

	/**
	 * Use Streams to find the max and min. Compute max - min
	 */
	public static int findLargestDistance4(int[] numbers) {
		IntSummaryStatistics evens = Arrays.stream(numbers).filter(n -> n % 2 == 0).summaryStatistics();
		int max = evens.getMax();
		int min = evens.getMin();
		return max - min;
	}

	public static void main(String... args) throws IOException {
		if (args.length == 0) {
			System.out.println("How to use: java Question1 2000 3000 4000 5000");
			System.exit(1);
		}
		int[] lengths = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			lengths[i] = Integer.valueOf(args[i]);
		}

		PrintWriter writer = new PrintWriter("times.txt", "UTF-8");
		for (int length : lengths) {
			int[] numbers = new int[length];
			Random r = new Random(100);
			for (int i = 0; i < length; i++) {
				numbers[i] = r.nextInt(length * 2);
			}
			
			System.out.print("Input array length: " + length);

			System.out.println();
			long before1 = System.currentTimeMillis();
			int maxDistance = findLargestDistance1(numbers);
			long duration1 = System.currentTimeMillis() - before1;
			System.out.println("Algorithm 1 (miliseconds): " + duration1);
			long before2 = System.currentTimeMillis();
			findLargestDistance2(numbers);
			long duration2 = System.currentTimeMillis() - before2;
			System.out.println("Algorithm 2 (miliseconds): " + duration2);
			long before3 = System.currentTimeMillis();
			findLargestDistance3(numbers);
			long duration3 = System.currentTimeMillis() - before3;
			System.out.println("Algorithm 3 (miliseconds): " + duration3);
			long before4 = System.currentTimeMillis();
			findLargestDistance4(numbers);
			long duration4 = System.currentTimeMillis() - before4;
			System.out.println("Algorithm 4 (miliseconds): " + duration4);
			System.out.println("Max distance between two evens: " + maxDistance);

			writer.println(String.format("%s %s %s %s %s", length, duration1, duration2, duration3, duration4));
		}

		writer.close();
	}
}