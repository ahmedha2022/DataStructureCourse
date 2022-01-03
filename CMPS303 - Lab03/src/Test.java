
public class Test {
	public static void main(String args[]) {
		MyList<Integer> x = new MyList<>(3);
		
		System.out.println("x.isEmpty(): " + x.isEmpty());
		x.add(1);
		System.out.println("x.isEmpty(): " + x.isEmpty());
		x.add(2);
		x.add(3);
		System.out.println("x.size(): " + x.size());
		System.out.println("x.length(): " + x.length());
		x.add(4);
		System.out.println("x.size(): " + x.size());
		System.out.println("x.length(): " + x.length());
		x.display();
		x.set(3, null);
		x.display();
		System.out.println("x.contains(): " + x.contains(1));
		System.out.println("x.indexOf(): " + x.indexOf(1));
		System.out.println("x.remove(1): " + x.remove(1));
		x.display();
	}

}
