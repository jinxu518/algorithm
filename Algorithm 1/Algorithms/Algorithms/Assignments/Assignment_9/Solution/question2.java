// Implement BuildHeap Bottom-Up.
public class question2 {
    // return the number of “data item” comparisons.
    public static void build_MaxHeap_BottomUP(int[] A, int n) {
        for (int i = n / 2; i >= 1; i--) {
            downHeap(A, i, n);
        }
    }

    public static void downHeap(int[] A, int i, int n) {
        int j = i;
        int k = maxChildIndex(A, j, n);
        int temp;
        while (k != 0) {
            System.out.println("::" + A[j] + "::" + A[k]);
            temp = A[j];
            A[j] = A[k];
            A[k] = temp;
            j = k;
            k = maxChildIndex(A, j, n);
        }
    }

    public static int maxChildIndex(int A[], int j, int n) {
        int maxChild = j;
        int leftChild = j * 2;
        int rightChild = j * 2 + 1;
        if (leftChild < n && A[leftChild] > A[maxChild]) {
            maxChild = leftChild;
        }
        if (rightChild < n && A[rightChild] > A[maxChild]) {
            maxChild = rightChild;
        }
        if (maxChild == j) {
            return 0;
        }
        return maxChild;

    }

    public static void main(String[] main) {
        int[] Array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        // Complete Binary Heap
        build_MaxHeap_BottomUP(Array, Array.length);
        for (int i : Array) {
            System.out.println(i);
        }
    }
}
