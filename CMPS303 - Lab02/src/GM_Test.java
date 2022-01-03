
public class GM_Test {
	
/*	public <T> T test(T array[])
	{
		T temp;
		temp = array[0];
		return temp;
	}
*/
	public static void main(String args[]) {
/*		Student s[] = new Student[5];
		s[0] = new Student(1, "Ahmad", 4);
		s[1] = new Student(2, "Ali", 3.9);
		s[2] = new Student(3, "Khalid", 3.8);
		s[3] = new Student(4, "Mohammad", 3.7);
		s[4] = new Student(5, "Nasser", 3.6);		*/
		
/*		Car s[] = new Car[5];
		s[0] = new Car(1, "Car1");
		s[1] = new Car(2, "Car2");
		s[2] = new Car(3, "Car3");
		s[3] = new Car(4, "Car4");
		s[4] = new Car(5, "Car5");			*/
		
//		Integer s[] = {1, 2, 3, 4, 5};
		Character s[] = {'a', 'b', 'c', 'd', 'e'};
		
		print(s);
		
		System.out.println("swapFirstLast(s): ");
		swapFirstLast(s);
		print(s);
		
		System.out.println("reverse(s): ");
		reverse(s);
		print(s);
		
		System.out.println("shift(s): ");
		shift(s);
		print(s);
		
	}
	
	public static <G> void swapFirstLast(G array[]){
		G temp = array[0];
		array[0] = array[array.length-1];
		array[array.length-1] = temp;
	}
	
	public static <T> void reverse(T array[]){
		T temp;
//		for(int i = 0 , j = array.length-1 ;  i < array.length/2 ; i++ , j-- )
		for(int i = 0 , j = array.length-1 ;  i < j ; i++ , j-- )
		{
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
	
	public static <T> void shift(T array[]){
		T temp = array[0];
		
		for(int i = 0 ; i < array.length-1 ; i++)
			array[i] = array[i+1];
		
		array[array.length-1] = temp;
	}
	
	public static <R> void print(R array[]) {
		for(R instance : array)
			System.out.println(instance);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
