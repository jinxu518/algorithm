package algorithm1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class solution {
    /**
     * Find the largest distance between any two even integers in an integer array.
     * <> Create a new array consisting of even numbers only. Then use nested loops
     * to solve the problem using the newly created array of even numbers only.
     */
    public static void Algorithm(int[] array) {
        int result = 0;
        ArrayList<Integer> evenArray = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenArray.add(array[i]);
            }
        }
        for (int i = 0; i < evenArray.size(); i++) {
            for (int j = i; j < evenArray.size(); j++) {
                result = Math.max(result, j - i);

            }
        }
    }

    public static void main(String[] args) throws IOException {
        Random rand = new Random(); // instance of random class
        int Size = 1000;
        int input_Size = 0;
        try (FileWriter myWriter = new FileWriter("algo1.txt")) {
            for (int i = 1; i <= 10; i++) {
                input_Size = Size * i;
                int[] array = new int[input_Size];
                for (int j = 0; j < input_Size; j++) {
                    array[j] = rand.nextInt();
                }
                long startTime = System.nanoTime();
                Algorithm(array);
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                myWriter.write(timeElapsed + "\n");
            }
            myWriter.close();
        }
    }

}
