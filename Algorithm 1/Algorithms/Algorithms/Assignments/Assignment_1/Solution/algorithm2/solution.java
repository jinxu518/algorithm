package algorithm2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class solution {
    // Use a nested loop to solve the problem without creating an extra array.

    public static void Algorithm(int[] array) {
        int result = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] % 2 == 0 && array[j] % 2 == 0) {
                    result = Math.max(result, j - i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Random rand = new Random(); // instance of random class
        int Size = 1000;
        int input_Size = 0;
        try (FileWriter myWriter = new FileWriter("algo2.txt")) {
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
