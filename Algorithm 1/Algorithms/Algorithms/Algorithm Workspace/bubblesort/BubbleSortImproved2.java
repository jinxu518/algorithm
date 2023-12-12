package bubblesort;

public class BubbleSortImproved2 {
    static int [] a = {2,5,1,6,9,4,42,35};
    public static void main(String [] args) {
        bubbleSort();
        for(int k=0;k<a.length;k++) {
            System.out.print(a[k]+" ");
        }
    }
    public static void bubbleSort() {
        int len = a.length;
        int j=1;
        boolean b=true;
        while(b){
            b=false;
            for (int i = 0; i < len - j; ++i) {
                if (a[i] > a[i + 1]) {
                    b=true;
                    swap(i, i + 1);
                }
            }
            j++;
        }
    }
    static void swap(int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
