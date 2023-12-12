package countzero;

public class CountZero {
    public static void main (String [] args) {
        int [] a={1,1,1,1,1};
        System.out.println(countZero(a,0,a.length-1));

    }

    //Count number of zeros first then number of ones will be n-number of zeros

    public static int countZero(int [] a,int lower,int upper) {
        if(a[lower]==1) return lower;
        else if (a[upper]==0) return upper+1;
        if (lower > upper)  return a.length;
        int mid =(upper + lower)/2;
        if (a[mid]==1) {
            if (a[mid - 1] == 0) return mid;
            return countZero(a, lower, mid - 1);
        }
        else {
            if(a[mid+1]==1) return mid+1;
            return countZero(a,mid+1,upper);
        }
    }
}
