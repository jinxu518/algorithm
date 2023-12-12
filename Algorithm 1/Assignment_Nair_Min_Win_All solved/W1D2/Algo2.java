package w1d2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algo2 {
    static Random random = new Random();
    static List<Long> times = new ArrayList<>();

    public static void main(String[] args) {
        int[] testArr = { 7, 20, 18, 4, 20, 19, 20, 3 };
        System.out.println("Third Max : " + getThirdMax(testArr) + "\n");

        int[] sizes = { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000 };
        for (int size : sizes) {
            long start = System.nanoTime();

            int[] arr = getRandomEvenNumbers(size);
            System.out.println("Third Max no in array of " + size + " : " + getThirdMax(arr));

            long end = System.nanoTime();
            long d = end - start;
            System.out.println("Time Required (In nano-second) : " + d + "\n");
            times.add(d);
        }

        times.forEach(t -> System.out.print(t + " "));
    }

    private static int getThirdMax(int[] arr) {
        int max = 0, preMax = 0, prePreMax = 0;

        for (int a : arr) {
            if (a >= max) {
                prePreMax = preMax;
                preMax = max;
                max = a;
            } else if (a >= preMax) {
                prePreMax = preMax;
                preMax = a;
            } else if (a >= prePreMax) {
                prePreMax = a;
            }
        }
        return prePreMax;
    }

    public static int[] getRandomEvenNumbers(int size) {
        int[] arr = new int[size];
        int ind = 0;
        while (ind < size) {
            arr[ind] = random.nextInt(10000);
            ind++;
        }
        return arr;
    }
}
