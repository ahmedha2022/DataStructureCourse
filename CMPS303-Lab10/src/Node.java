public class Node{
	private Student element;
	private Node next;
	public Node(Student e, Node n)
	{
		element=e;
		next=n;
	}
	public Student getElement(){
		return element;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node n)
	{
		next=n;
	}
}