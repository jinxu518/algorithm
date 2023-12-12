package mergesort;

public class MergeSortPlus {
    private int[] array;
    private int length;

    public static void main(String a[]) {

        int[] inputArr=new int[100];
        for(int i=0;i<100;i++) {
            inputArr[i]=(int)(Math.random()*100);
        }
        MergeSortPlus m = new MergeSortPlus();
        long t1=System.nanoTime();
        m.sort(inputArr);
        long t2=System.nanoTime();
        System.out.println(t2-t1);
        MergeSort m1 = new MergeSort();
        long t3=System.nanoTime();
        m1.sort(inputArr);
        long t4=System.nanoTime();
        System.out.println(t4-t3);
        System.out.println();
        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = (lowerIndex + higherIndex) / 2;
            // Below step sorts the left side of the array
            if(middle>20) {
                doMergeSort(lowerIndex, middle);
                // Below step sorts the right side of the array
                doMergeSort(middle + 1, higherIndex);
            }
            // Now merge both sides
            insertionSort(lowerIndex, higherIndex);
        }
    }

    private void insertionSort(int lowerIndex, int higherIndex) {
        int temp = 0;
        int j = 0;
        for (int i = lowerIndex; i <= higherIndex; i++) {
            temp = array[i];
            j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
}
