import java.util.Arrays;
import java.util.Random;

public class Sorting {
	public static void main(String args[]) {
		int n = 100000;
		Random random = new Random();
		int x[] = new int[n];
		
		for(int index = 0 ; index < x.length ; index++)
			x[index] = random.nextInt(1000);
		
		int y[] = x.clone();
		int z[] = x.clone();
		int f[] = x.clone();
		
		long start1 = System.currentTimeMillis();
		bubbleSort(x);
		long end1 = System.currentTimeMillis();
		System.out.println("Bubble sort execution time is: " + (end1-start1));
		
		long start2 = System.currentTimeMillis();
		selectionSort(y);
		long end2 = System.currentTimeMillis();
		System.out.println("Selection sort execution time is: " + (end2-start2));
		
		long start3 = System.currentTimeMillis();
		insertionSort(z);
		long end3 = System.currentTimeMillis();
		System.out.println("Insertion sort execution time is: " + (end3-start3));
		
		long start4 = System.currentTimeMillis();
		Arrays.sort(f);
		long end4 = System.currentTimeMillis();
		System.out.println("Arrays.sort() method execution time is: " + (end4-start4));
	}

	public static void bubbleSort(int[] a) {
		int outer, inner;
		for (outer = a.length - 1; outer > 0; outer--) { // counting down
			for (inner = 0; inner < outer; inner++) { // bubbling up
				if (a[inner] > a[inner + 1]) { // if out of order...
					int temp = a[inner]; // ...then swap
					a[inner] = a[inner + 1];
					a[inner + 1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] a) { 
		int outer, inner, min; 
		for (outer = 0; outer < a.length - 1; outer++) {
			// outer counts down 
			min = outer; 
			for (inner = outer + 1; inner < a.length; inner++) 
				if (a[inner] < a[min]) min = inner; 
			int temp = a[outer]; 
			a[outer] = a[min];
			a[min] = temp;
		}
	}

	public static void insertionSort(int[] array) { 
		int inner, outer; 
		for (outer = 1; outer < array.length; outer++) { 
			int temp = array[outer]; 
			inner = outer; 
			while (inner > 0 && array[inner - 1] >= temp) { 
				array[inner] = array[inner - 1]; 
				inner--; 
			} 
			array[inner] = temp; 
		} 
	}
}