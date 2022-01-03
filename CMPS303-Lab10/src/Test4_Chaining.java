public class Test4_Chaining {
	public static void main(String arg[])
	{
		ChainingHashTable t2=new ChainingHashTable(7);//table size
		t2.insert(new Student(17,"ali",2));
		t2.insert(new Student(14,"ahmed",2));
		t2.insert(new Student(28,"khaled",2));
		t2.insert(new Student(7,"khaled",2));
		t2.insert(new Student(21,"Nasser",2));
		t2.displayTable();
		System.out.println("---------------");
		t2.delete(28);
		t2.displayTable();
		Student s=t2.find(14);
		System.out.println(s);
		Student s2=t2.find(15);
		System.out.println(s2);
	}
}