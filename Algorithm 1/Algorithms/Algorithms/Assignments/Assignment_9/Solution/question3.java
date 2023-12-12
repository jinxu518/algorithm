import java.lang.reflect.Array;

public class question3 {
    public static void build_Heap_Sort(int[] A, int n) {
        question2.build_MaxHeap_BottomUP(A, n);
        int temp = 0;
        for (int j = n - 1; j > 0; j--) {
            temp = A[1];
            A[1] = A[j];
            A[j] = temp;
            // System.out.println("Last: " + A[1]);
            question2.build_MaxHeap_BottomUP(A, j);
        }
    }

    public static void main(String[] args) {
        int[][] Array = {
                { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 },
                { 0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15 },
                { 0, 4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15 },
                { 0, 5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9 },
        };
        for (int[] i : Array) {
            build_Heap_Sort(i, i.length);
        }
        for (int i[] : Array) {
            for (int j : i)
                System.out.print(" : " + j);
            System.out.println();
        }
    }
}
