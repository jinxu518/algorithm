package w1d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algo3{
    static List<Long> times = new ArrayList<>();

    public static void main(String[] args) {
        int[] sizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
        for(int size : sizes){
            System.out.println("Max Distance for " + size + " numbers : " + maxDistance(size) + "\n");
        }
        times.forEach(t -> System.out.print(t + " "));
    }

    private static int maxDistance(int size){
        long start = System.nanoTime();

        int[] arr = getRandomEvenNumbers(size);
        int maxEven = 0, minEven = Integer.MAX_VALUE;

        for (int k : arr) {
            if (k % 2 == 0) {
                if (k > maxEven) {
                    maxEven = k;
                }

                if (k < minEven) {
                    minEven = k;
                }
            }

        }

        System.out.println(maxEven + " " + minEven);
        long end = System.nanoTime();
        long d = end - start;
        times.add(d);
        System.out.println("Time Required (In nano-second) : " + d);
        return maxEven - minEven;
    }

    public static int[] getRandomEvenNumbers(int size){
        Random random = new Random();

        int[] arr = new int[size];
        int ind = 0;
        while(ind < size){
            arr[ind] = random.nextInt(10000);
            ind++;
        }
        return arr;
    }
}
