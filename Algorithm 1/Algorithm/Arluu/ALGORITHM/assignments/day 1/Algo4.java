package w1d1;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Random;

public class Algo4 {
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
        int maxEven = Arrays.stream(arr).filter(a -> a%2==0).max().orElse(0);
        int minEven = Arrays.stream(arr).filter(a -> a%2==0).min().orElse(0);

        long end = System.nanoTime();
        long d = end - start;
        times.add(d);
        System.out.println("Time Required (In nano-second) : " + d);

        return Math.abs(maxEven - minEven);
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
