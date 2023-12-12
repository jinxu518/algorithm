
import java.util.Arrays;
import java.util.Random;

//implemented by Angesh, Min and Win
public class W1D1Assignment{
    public static void main(String[] args) {
    	//testing result is correct using 4 algorithms
		int[] textRandomAry=new int[10];
    	for(int i=0;i<10;i++) 
        	textRandomAry[i] = new Random().nextInt(10000);
    	
        System.out.println("Using Algorithm 1: Lagest distance is "+algorithm1(textRandomAry));
        System.out.println("Using Algorithm 2: Lagest distance is "+algorithm2(textRandomAry));
        System.out.println("Using Algorithm 3: Lagest distance is "+algorithm3(textRandomAry));
        System.out.println("Using Algorithm 4: Lagest distance is "+algorithm4(textRandomAry));
        
        
        System.out.println("\nGetting running times by each algorithms");
    	int[] sizes = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
    	for(int i=0;i<sizes.length;i++) {
    		int[] randomAry=new int[sizes[i]];
            for (int j=0; j<randomAry.length; j++) {
                randomAry[j] = new Random().nextInt(10000);
            }
            algorithm1(randomAry);
            //algorithm2(randomAry);
            //algorithm3(randomAry);
            //algorithm4(randomAry);
    	}
    }
    
    //Algorithm 1
    //Create a new array consisting of even numbers only. Then use nested loops to solve the problem using
    //the newly created array of even numbers only.
    public static int algorithm1(int[] randomAry){
        long startTime = System.nanoTime();
        long endTime = 0;
        int[] rawEvenAry= new int[randomAry.length];
        int count=0;
        for(int i : randomAry){
            if(i%2==0)
            rawEvenAry[count++]=i;
        }

        int[] newEvenAry=new int[count];
        for(int i=0; i<newEvenAry.length; i++)
          newEvenAry[i]=rawEvenAry[i];

        rawEvenAry=null;//as we don't need that raw even array anymore

        int maxDistance = Integer.MIN_VALUE;
        for (int i=0; i<newEvenAry.length; i++){
            for(int j=i+1; j<newEvenAry.length; j++){
                int distance = Math.abs(newEvenAry[i] - newEvenAry[j]);
                if(maxDistance < distance){
                    maxDistance = distance;
                }
            }
        }

        endTime = System.nanoTime();
        long timeneeded =  endTime - startTime;

        System.out.println(timeneeded);

        return maxDistance;
    }

    //Algorithm 2
    //Use a nested loop to solve the problem without creating an extra array.
    public static int algorithm2(int[] randomAry){
        long startTime = System.nanoTime();
        long endTime = 0;
        
        int maxDistance = Integer.MIN_VALUE;
        for (int i=0; i<randomAry.length; i++){
        	if(randomAry[i]%2==0) {
	            for(int j=i+1; j<randomAry.length; j++){
	            	if(randomAry[j]%2==0) {
		                int distance = Math.abs(randomAry[i] - randomAry[j]);
		                if(maxDistance < distance){
		                    maxDistance = distance;
		                }
	            	}
	            }
        	}
        }

        endTime = System.nanoTime();
        long timeneeded =  endTime - startTime;

        System.out.println(timeneeded);

        return maxDistance;
    }
    
    //Algorithm 3
    //Use one loop. Find max and min of even integers. Compute max – min.
    public static int algorithm3(int[] randomAry){
        long startTime = System.nanoTime();
        long endTime = 0;
        
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i=0; i<randomAry.length; i++){
        	if(randomAry[i]%2==0) {
        		if(max<randomAry[i])
        			max=randomAry[i];
    			if(min>randomAry[i])
    				min=randomAry[i];
        	}
        }
        
        int maxDistance=max-min;
        
        endTime = System.nanoTime();
        long timeneeded =  endTime - startTime;

        System.out.println(timeneeded);

        return maxDistance;
    }
    
    //Algorithm 4
    //Use Streams to find the max and min. Compute max – min
    public static int algorithm4(int[] randomAry){
        long startTime = System.nanoTime();
        long endTime = 0;
        
        int max=Arrays.stream(randomAry).filter(x->x%2==0).max().getAsInt();
        int min=Arrays.stream(randomAry).filter(x->x%2==0).min().getAsInt();
       
        int maxDistance=max-min;
        
        endTime = System.nanoTime();
        long timeneeded =  endTime - startTime;

        System.out.println(timeneeded);

        return maxDistance;
    }
}