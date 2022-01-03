import java.util.Arrays;
import java.util.Random;

public class Searching {
	
	public static void main(String args[]) {
		int n = 1000000000;
		Random random = new Random();
		int a[] = new int[n];
		
		for(int index = 0 ; index < a.length ; index++)
			a[index] = random.nextInt(1000);			// Will generate a values from 0-999;
		
		Arrays.sort(a);
		
		long start1 = System.currentTimeMillis();
		linearSearch(a, 1000);
		long end1 = System.currentTimeMillis();
		System.out.println("Linear search execution time is: " + (end1-start1));
		
		long start2 = System.currentTimeMillis();
		binarySearch(a, 1000);
		long end2 = System.currentTimeMillis();
		System.out.println("Binary search execution time is: " + (end2-start2));
	}

	public static int linearSearch(int[] a, int x) {
		int i; 
		for (i = 0; i < a.length ;i++) { 
			if (a[i] == x) 
				return i; }
		return -1;
	}

	public static int binarySearch(int a[], int x){
		int lo = 0;
		int hi = a.length-1;
		int mid;
		while(lo<=hi)
		{
			mid= (lo + hi ) / 2;
			if(a[mid]==x)
				return mid; // found it
			else
			{
				if(a[mid] < x) // decide which half to search in
					lo = mid + 1; // it in the upper half
				else
					hi = mid - 1; // it is in the lower half
			}
		}
		return -1; // not found
	}
}