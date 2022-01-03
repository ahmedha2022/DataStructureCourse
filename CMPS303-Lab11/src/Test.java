import java.util.Random;

public class Test {
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
		int temp = array[i];
		int j = i;
		while (j > 0 && array[j - 1] >= temp) {
		array[j] = array[j - 1];
		j--;
		}
		array[j] = temp;
		}
		}
public static void heapSort(int a[])
{
	Heap h=new Heap(a.length);
	for (int i=0;i<a.length;i++)
		h.insert(a[i], null);
	
	for (int i=a.length-1;i>=0;i--)
		a[i]=h.removeMax().key;
}
public static void main(String arg[])
{
	int n=100;
	int x[]=new int[n];
	Random r=new Random();
	for (int i=0;i<n;i++)
		x[i]=r.nextInt(n);
	int y[]=x.clone();
	long start1=System.currentTimeMillis();
	insertionSort(x);
	long end1=System.currentTimeMillis();
	long insertionTime=end1-start1;
	System.out.println("Insertion:"+insertionTime);
	
	long start2=System.currentTimeMillis();
	heapSort(x);
	long end2=System.currentTimeMillis();
	long heapTime=end2-start2;
	System.out.println("Heap:"+heapTime);
	
	
	
	Heap h=new Heap(10);
	h.insert(8,new Patient(1,"Khalid"));
	h.insert(3,new Patient(2,"Naser"));
	h.insert(6,new Patient(3,"Ahmed"));
	h.insert(2,new Patient(4,"Sameer"));
	h.insert(9,new Patient(5,"Maged"));
	
//int c=h.size();
//	for (int i=0;i<c;i++)
//		System.out.println(h.removeMax().data);
h.travers(3);	
	
}
}