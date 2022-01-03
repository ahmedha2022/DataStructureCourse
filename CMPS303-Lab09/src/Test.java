
public class Test {
	public static void main(String arg[])
	{
		Tree t=new Tree();
		t.insert(50,new Student(50,"Ali"));
		t.insert(20,new Student(20,"Khalid"));
		t.insert(70,new Student(70,"Nasser"));
		t.insert(60,new Student(60,"Nasser"));
		t.insert(10,new Student(10,"Sara"));
		t.insert(4,new Student(4,"Nour"));
		t.insert(90,new Student(90,"Nour"));
		t.traverse(1);
//		t.traverse(2);
//		t.traverse(3);
		System.out.println(t.count());
	}
}