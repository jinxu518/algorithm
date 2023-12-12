package sortmerged;

public class SortedMerge {
    public static void main(String [] args) {
        int [] a={1,4,5,8,17};
        int [] b={2,4,8,11,13,21,23,25};
        SortedMerge s=new SortedMerge();
        int [] m=s.merge(a,b);

        for(int i=0;i<m.length;i++) {
            System.out.print(m[i]+" ");

        }

    }
    public int [] merge(int [] a, int [] b) {
        int [] c= new int [a.length +b.length];
        int i=0,j=0,k=0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                k++;i++;
            }
            else {
                c[k] = b[j];
                k++;j++;
            }
        }
        while (i < a.length) {
            c[k] = a[i];
            k++;i++;
        }
        while (j < b.length) {
            c[k] = b[j];
            k++;j++;
        }

        return c;
    }
}
