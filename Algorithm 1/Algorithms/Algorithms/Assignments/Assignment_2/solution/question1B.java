package Assignment2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class question1B {
    public static int thirdLargest(int[] array) {

        int max = 0;
        int premax = 0;
        int prepremax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                prepremax = premax;
                premax = max;
                max = array[i];
            } else if (array[i] > premax)
                premax = array[i];
            else if (array[i] > prepremax)
                prepremax = array[i];
        }
        return prepremax;
    }

    public static void main(String[] args) {
        Random rand = new Random(); // instance of random class
        int Size = 1000;
        int input_Size = 0;
        try (FileWriter myWriter = new FileWriter("algo2.txt")) {
            for (int i = 1; i <= 10; i++) {
                input_Size = Size * i;
                int[] array = new int[input_Size];
                for (int j = 0; j < input_Size; j++) {
                    array[i] = rand.nextInt();
                }
                long startTime = System.nanoTime();
                thirdLargest(array);
                long endTime = System.nanoTime();
                long timeElapsed = endTime - startTime;
                myWriter.write(timeElapsed + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
