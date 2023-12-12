package sort012;

public class Sort012 {
    static int [] a={0,1,0,2};
    public static void main(String [] args) {
        sort012();
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }

    }
    public static void sort012() {

        int count0=0,count1=0,count2=0;

        for(int i=0;i<a.length;i++) {
            if(a[i]==0) count0++;
            else if(a[i]==1) count1++;
            else count2++;
        }
        for(int j=0;j<count0;j++) {
            a[j]=0;
        }
        for(int j=count0;j<(count0+count1);j++) {
            a[j]=1;
        }
        for(int j=(count0+count1);j<a.length;j++) {
            a[j]=2;
        }
    }
}
