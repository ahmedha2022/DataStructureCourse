import java.util.Random;

public class Ex1 {
	public static void main(String args[]) {
		int x[] = new int[1000];
		Random random = new Random();
		for(int index=0 ; index<x.length ; index++)
			x[index] = random.nextInt(100);		//0-99
		
//		long start = System.currentTimeMillis();
		long start = System.nanoTime();
		total(x);
		long end = System.nanoTime();
		System.out.println("The execution time is: " + (end-start) );		
	}

	public static int total(int x[]){
		int sum=0;
		for (int i=0;i<x.length;i++)
			sum=sum+x[i];
		return sum;
	}
}