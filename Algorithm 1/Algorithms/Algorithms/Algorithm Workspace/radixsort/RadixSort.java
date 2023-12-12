package radixsort;

// Radix sort Java implementation
import java.util.*;

class RadixSort {

    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int B[] = new int[n]; // B array
        int i;
        int C[] = new int[10];
        Arrays.fill(C,0);

        // Store C of occurrences in C[]
        for (i = 0; i < n; i++)
            C[(arr[i]/exp)%10 ]++;

        // Change C[i] so that C[i] now contains
        // actual position of this digit in B[]
        for (i = 1; i < 10; i++)
            C[i] += C[i - 1];

        // Build the B array
        for (i = n - 1; i >= 0; i--)
        {
            B[--C[(arr[i]/exp)%10] ] = arr[i];
        }

        // Copy the B array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = B[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

      /*Driver function to check for above function*/
    public static void main (String[] args)
    {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}
