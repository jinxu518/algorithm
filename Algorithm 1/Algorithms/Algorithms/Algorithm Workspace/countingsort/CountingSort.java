package countingsort;

import java.util.Arrays;

public class CountingSort{

    public static void main(String[] args) {

        System.out.println("Counting sort in Java");
        int[] input = { 60, 40, 30, 20, 10, 40, 30, 60, 60, 20, 40, 30, 40 };
        int k = 60;

        System.out.println("integer array before sorting");
        System.out.println(Arrays.toString(input));
        CountingSort c=new CountingSort();

        // sorting array using Counting Sort Algorithm
        c.countingSort(input, k);

        System.out.println("integer array after sorting using counting sort algorithm");
                System.out.println(Arrays.toString(c.countingSort(input, k)));

    }

    int[] countingSort(int[] a, int k) {
        int c[] = new int[k+1];
        for (int i = 0; i < k+1; i++)
            c[i]=0;
        for (int i = 0; i < a.length; i++)
            c[a[i]]++;
        for (int i = 1; i < k+1; i++)
            c[i] += c[i-1];
        int b[] = new int[a.length];
        for (int i = a.length-1; i >= 0; i--) {
            b[--c[a[i]]] = a[i];
        }
        return b;
    }

}