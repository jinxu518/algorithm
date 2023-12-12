package bubblesort;

public class BubbleSortImproved {
    static int [] a = {2,5,1,6,9,1,42,35};
    public static void main(String [] args) {
        bubbleSort();
        for(int k=0;k<a.length;k++) {
            System.out.print(a[k]+" ");
        }
    }
    public static void bubbleSort() {
        int len = a.length;
        boolean b=true;
        while(b){
            b=false;
            for (int j = 0; j < len - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    b=true;
                    swap(j, j + 1);
                }
                }
            }
        }


    static void swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
