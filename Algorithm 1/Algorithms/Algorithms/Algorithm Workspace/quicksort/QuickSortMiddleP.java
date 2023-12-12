package quicksort;

public class QuickSortMiddleP {

    private void quickSort(int array[],int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[(lowerIndex+higherIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;

                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array,lowerIndex, j);
        if (i < higherIndex)
            quickSort(array,i, higherIndex);
    }

    public static void main(String a[]){

        QuickSortMiddleP sorter = new QuickSortMiddleP();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        int n=input.length;
        sorter.quickSort(input,0,n-1);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }

}
