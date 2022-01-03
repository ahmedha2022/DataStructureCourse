
public class Testing {
	public static void main(String args[]) {

	}
	
	public static void print0(int a[], double x[]) { // O(1)
		System.out.println("Hello");
		System.out.println("Hello" + 4);
		System.out.println("Hello" + 6);
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
	}
	
	public static void print1(int a[]) {									//			size=2		size=5		size=6
		for(int index1 = 0 ; index1 < a.length ; index1++)					//O(2n2)		8			50			72
			for(int index2 = 0 ; index2<a.length ; index2++) {
				System.out.println("Index1 = " + index1);
				System.out.println("Index2 = " + index2);
			}
	}
			
	public static void print2(int a[]) {									//			size=2		size=5		size=6
		for(int index1 = 0 ; index1 < a.length ; index1++) {				//O(10n)		20			50			60
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
				System.out.println("a[ " + index1 + "] = " + a[index1]);
			}
	}

}
