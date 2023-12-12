package insertionsort;

public class InsertionSort {
    int [] arr={9,4,6,0,7,12,10};
    void sort(){
        int len = arr.length;
        int temp = 0;
        int j = 0;
        for(int i = 1; i < len; ++i) {
            temp = arr[i];
            j=i;
            while(j>0 && temp < arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j]=temp;
        }
    }
    public static void main(String [] args) {
        InsertionSort in=new InsertionSort();
        in.sort();
        for (int i=0;i<in.arr.length;i++) {
            System.out.print(in.arr[i]+" ");
        }
    }
}
