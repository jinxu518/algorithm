package Assignment2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class question1 {
    // Comparing Algorithms. Problem: Find the THIRD largest in an array.
    public static int thirdLargest(int[] array) {

        int firstMaxIndex = 0;
        int secMaxIndex = 0;
        int thrdMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[firstMaxIndex]) {
                firstMaxIndex = i;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[secMaxIndex] && i != firstMaxIndex) {
                secMaxIndex = i;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > thrdMax && i != firstMaxIndex && i != secMaxIndex) {
                thrdMax = array[i];
            }
        }
        return thrdMax;
    }

    public static void main(String[] args) {
        Random rand = new Random(); // instance of random class
        int Size = 1000;
        int input_Size = 0;
        try (FileWriter myWriter = new FileWriter("algo1.txt")) {
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
