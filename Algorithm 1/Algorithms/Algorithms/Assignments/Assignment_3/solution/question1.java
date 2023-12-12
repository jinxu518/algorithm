package solution;

import java.util.Random;

public class question1 {
    // Algorithm in which bestcase time is eual to worstcase time
    public static void beautiful(int[] array) {
        int temp;
        for (int i = 0, j = array.length - 1; i < array.length / 2; j--, i++) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        int array_length = 10;
        int[] array = new int[array_length];
        Random rand = new Random();
        for (int i = 0; i < array_length; i++) {
            array[i] = rand.nextInt(100);
        }
        for (int i : array) {
            System.out.print(i + "\t");
        }
        beautiful(array);
        System.out.println("******************************");
        for (int i : array) {
            System.out.print(i + "\t");
        }

    }
}
