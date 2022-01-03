import java.util.ArrayList;

public class Recursion {

	public static void printDecending(int n) {	//n = 5
		if (n>=0){
			System.out.println(n);
			printDecending(n-1);
		}
	}	

	public static void printAcending(int n) {	// n = 5
		if(n>=0){
			printAcending(n-1);
			System.out.println(n);
		}
	}	

	public static int total(int n){	// n = 5
		if (n==1)
			return 1;
		else
			return n+total(n-1);
	}
	
	public static int totalDigits(int n) {	//n = 452
		if (n<10)
			return n;
		else
			return n%10+totalDigits(n/10);
	}	
	
	public void reverseArray(int a[],int i,int j){
		if (i<j){
			int tmp=a[i];
			a[i]=a[j];
			a[j]= tmp;
			i++;
			j--;
			reverseArray(a,i,j);
		}
	}

	public static void reverseArrayList (ArrayList<Integer> a){
		if (!a.isEmpty()){
			int x=a.remove(0);
			reverseArrayList(a);
			a.add(x);
		}
	}
	
/*	Answer of reversing the linked list, this method has to be added in the 
 * SinglyLinkedList class of the previous lab "Lab06".
  	
  	public void reverseSinglyList(SinglyLinkedList<E> myList) {
		if (!myList.isEmpty()){
			E x=myList.removeFirst();
			reverseSinglyList(myList);
			myList.addLast(x);
		}
	}
*/
	
	public static boolean isPalindrome(String s){
		if (s.length()==1 || s.length()==0)
			return true;
		else{
			if (s.charAt(0)!=s.charAt(s.length()-1))
				return false;
			else
				return isPalindrome(s.substring(1,s.length()-1));
		}
	}

	public static void main(String arg[]){
		ArrayList<Integer> x=new ArrayList<>();
		x.add(5);
		x.add(4);
		x.add(3);
		x.add(1);
		reverseArrayList(x);
		for(int i:x)
			System.out.println(i);

		System.out.println(isPalindrome("radar"));
	}
}