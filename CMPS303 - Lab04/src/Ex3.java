
public class Ex3 {
	public static void main(String args[]) {
		int n = 100000000;
		int x[] = new int[n];
		
		//for the best case, fill the array where the first index "0" has the maximum value.
		x[0] = n;	//10,000,000
		for(int index = 1 ; index < n ; index++)  // n will vary from 1 - 9,999,999
			x[index] = index;	// The maximum index is 9,999,999
		
		long start1 = System.currentTimeMillis();
		max(x);
		long end1 = System.currentTimeMillis();
		System.out.println("The best case execution time is: " + (end1-start1));
		
		//for the worst case, fill the array where the last index "n-1" has the maximum value.
		for(int index = 0 ; index < n ; index++)  // n will vary from 0 - 9,999,999
			x[index] = index;	// The maximum index is 9,999,999 and it will include the maximum value
		
		long start2 = System.currentTimeMillis();
		max(x);
		long end2 = System.currentTimeMillis();
		System.out.println("The worst case execution time is: " + (end2-start2));
	}

	public static int max(int a[])
	{
		int m=a[0];
		for (int i=0;i<a.length;i++)
			if (a[i]>m)
				m=a[i];
		return m;
	}

}
