package Singly;

public class Test {
	public static void main(String args[]) {
		SinglyLinkedList<Student> myLinkedList = new SinglyLinkedList<>();
		System.out.println("myLinkedList.isEmpty(): " + myLinkedList.isEmpty());
		myLinkedList.addFirst(new Student(1, "Student1"));
		myLinkedList.addFirst(new Student(2, "Student2"));
		myLinkedList.addLast(new Student(0, "Student0"));
		
		System.out.println("myLinkedList.isEmpty(): " + myLinkedList.isEmpty());
		System.out.println("myLinkedList.first(): " + myLinkedList.first());
		System.out.println("myLinkedList.last(): " + myLinkedList.last());
		
		myLinkedList.addLast(new Student(3, "Student3"));
		myLinkedList.addLast(new Student(4, "Student4"));
		
		myLinkedList.display();
		System.out.println("myLinkedList.size(): " + myLinkedList.size());
		
		Student rF = myLinkedList.removeFirst();
		Student rL = myLinkedList.removeLast();
		myLinkedList.display();
		
		myLinkedList.insertAfter(3, new Student(6, "Student6"));
		myLinkedList.display();
		System.out.println("myLinkedList.size(): " + myLinkedList.size());
	}

}
