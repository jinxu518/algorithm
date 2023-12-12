// Implement BuildHeap Top-Down.
public class question1 {
    // return the number of “data item” comparisons.
    public static void build_MaxHeap_TopDown(int[] A, int n) {
        for (int i = 1; i < n; i++) {
            upHeap(A, i);
        }
    }

    public static void upHeap(int[] A, int i) {
        int j = i;
        int temp;
        while (j > 1 && A[j / 2] < A[j]) {
            System.out.print("::" + A[j] + "::" + A[j / 2] + "\n");
            temp = A[j];
            A[j] = A[j / 2];
            A[j / 2] = temp;
            j = j / 2;
        }
    }

    public static void main(String[] main) {
        int[] Array = { 0, 56, 39, 14, 18, 75 };
        // Complete Binary Heap
        build_MaxHeap_TopDown(Array, 6);
        for (int i : Array) {
            System.out.println(i);
        }
    }

}
