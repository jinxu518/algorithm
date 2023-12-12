package w1d1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Algo1 {
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

        int[] evenArr = new int[arr.length];
        int ind = 0;

        for(int i : arr){
            if(i % 2 == 0){
                evenArr[ind] = i;
                ind++;
            }
        }

        for(int i=0; i<evenArr.length; i++){
            for(int j=0; j<evenArr.length; j++){
                if(i != j){
                    int diff = Math.abs(evenArr[i] - evenArr[j]);
                    if(diff > max){
                        max = diff;
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
