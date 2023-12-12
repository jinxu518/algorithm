package algorithm3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class solution {
    // Use one loop. Find max and min of even integers. Compute max – min.
    public static void Algorithm(int[] array) {

        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] < max)
                    max = array[i];
                if (array[i] > min) {
                    min = array[i];
                }
            }
        }
        int result = max - min;
        System.out.println("Max - Min: " + result);
    }

    public static void main(String[] args) throws IOException {
        Random rand = new Random(); // instance of random class
        int Size = 1000;
        int input_Size = 0;
        try (FileWriter myWriter = new FileWriter("algo3.txt")) {
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
