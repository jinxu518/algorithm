package w1d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algo2 {
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
        int max = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 == 0){
                for(int j=0; j<arr.length; j++){
                    if(i != j){
                        if(arr[j] % 2 == 0){
                            int diff = Math.abs(arr[i] - arr[j]);
                            if(diff > max){
                                max = diff;
                            }
                        }
                    }
                }
            }
        }

        long end = System.nanoTime();
        long d = end - start;
        times.add(d);
        System.out.println("Time Required (In nano-second) : " + d);

        return max;
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
