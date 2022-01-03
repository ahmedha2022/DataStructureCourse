
public class GC_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		WaitingList<Student> wl = new WaitingList<>(); 
		wl.add(new Student(1, "Ahmad", 4));
		wl.add(new Student(2, "Ali", 3.9));
		wl.add(new Student(3, "Nasser", 3.8));
		wl.add(new Student(4, "Fahad", 3.7));
		wl.add(new Student(5, "Khalid", 3.6));			*/
		
		WaitingList<Car> wl = new WaitingList<>(); 
		wl.add(new Car(1, "Car1"));
		wl.add(new Car(2, "Car2"));
		wl.add(new Car(3, "Car3"));
		wl.add(new Car(4, "Car4"));
		wl.add(new Car(5, "Car5"));
		
		wl.print();
		
		System.out.println("wl.get(0): ");
		System.out.println(wl.get(0));
		
		System.out.println("wl.reverse(): ");
		wl.reverse();
		wl.print();
		
		System.out.println("wl.remove(): ");
		System.out.println(wl.remove());

		System.out.println("The waiting list after removing the first element: ");
		wl.print();
	}

}
