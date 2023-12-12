package quicksort;

public class QuickSortStartP {

    int partition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        int i = (low+1); // index of smaller element
        for (int j=low+1; j<high; j++)
        {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot)
            {
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i-1];
        arr[i-1] = arr[low];
        arr[low] = temp;

        return i-1;
    }


    /* The main function that implements QuickSortEndP()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    public static void main(String args[])
    {
        int arr[] = {10, 7, 8, 9, 1, 5,1,1,0,78,34};
        int n = arr.length;

        QuickSortStartP ob = new QuickSortStartP();
        ob.sort(arr, 0, n-1);

        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
