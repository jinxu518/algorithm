package bucketsort;

import java.util.Arrays;

public class BucketSort {

    public static void main(String[] args) {

        int[] num = { 42,6,56,7,40,8,10,4,109,30};
        int n = max_value(num);

        bucketSort(num,n);

        for (int h = 0; h < num.length; h++)
            System.out.print(num[h]+ " ");
    }
    static int max_value(int[] nums)
    {
        int max_value = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > max_value)
                max_value = nums[i];
        return max_value;
    }


    public static int[] bucketSort(int[] arr,int n) {
        int i, j;
        int[] bucket = new int[n+1];
        Arrays.fill(bucket, 0);

        for (i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int k=0;
        for (i = 0; i < bucket.length; i++) {
            for (j = 0; j<bucket[i]; j++) {
                arr[k++] = i;
            }
        }
        return arr;
    }


}