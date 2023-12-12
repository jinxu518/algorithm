package w1d2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algo1 {
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
        int firstMaxInd = 0, secondMaxInd = 0;
        int firstMax = arr[0], secondMax = arr[0], thirdMax = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                firstMax = arr[i];
                firstMaxInd = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == firstMaxInd)
                continue;
            if (arr[i] > secondMax) {
                secondMax = arr[i];
                secondMaxInd = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == firstMaxInd || i == secondMaxInd)
                continue;
            if (arr[i] > thirdMax) {
                thirdMax = arr[i];
            }
        }

        return thirdMax;
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
