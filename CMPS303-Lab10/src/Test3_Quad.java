public class Test3_Quad {
	public static void main(String arg[])
	{
		QuadProbingHashTable t2=new QuadProbingHashTable(7);//table size
		t2.insert(new Student(17,"ali",2));			//3
		t2.insert(new Student(14,"ahmed",2));		//0
		t2.insert(new Student(28,"khaled",2));		//1
		t2.insert(new Student(7,"khaled",2));		//4
		t2.displayTable();
		t2.delete(28);
		System.out.println();
		System.out.println();
		t2.displayTable();
		Student s=t2.find(14);
		System.out.println(s);
		Student s2=t2.find(15);
		System.out.println(s2);
	}
}