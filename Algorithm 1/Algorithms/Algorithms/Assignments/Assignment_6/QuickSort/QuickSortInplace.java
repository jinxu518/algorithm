import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortInplace {
    public static Integer[] QuickSort(Integer[] array) {
        if (array == null || array.length == 1)
            return array;
        int pIndex = pickPivot(array); // pivot
        List<List<Integer>> Partitions = Partition(array, pIndex);
        QuickSort(Partitions.toArray(new Integer[Partitions.get(0).size()]));
        QuickSort(Partitions.toArray(new Integer[Partitions.get(2).size()]));

        return null;
    }

    private static List<List<Integer>> Partition(Integer[] array, int pIndex) {
        List<Integer> L = new ArrayList<>();
        List<Integer> E = new ArrayList<>();
        List<Integer> G = new ArrayList<>();
        List<List<Integer>> combined = new ArrayList<>();
        int index = 0;
        while (index != array.length) {
            if (array[index] < array[pIndex]) {
                L.add(array[index]);
            } else if (array[index] == array[pIndex]) {
                E.add(array[index]);
            } else {
                G.add(array[index]);
            }
            index++;
        }
        combined.add(L);
        combined.add(E);
        combined.add(G);
        return combined;

    }

    // median pivot
    private static int pickPivot(Integer[] array) {
        int mid = (0 + array.length - 1) / 2;
        int[] medianArray = { array[0], array[mid], array[array.length - 1] };
        Arrays.sort(medianArray);

        return medianArray[1];
    }

    public static void main(String[] args) {
        int[] array = { 18, 42, 58, 72, 63, 21, 79, 6, 37, 31, 10 };
        QuickSort(array);
        // for (int i : array) {
        // System.out.print(i);
        // }

    }

}
