package doubly;

public class Node <E>{

	private E data;
	private Node<E> prev;
	private Node<E> next;

	public Node(E d, Node<E> p,Node<E> n) {
		data=d;
		prev=p;
		next=n;
	}

	public E getData() {
		return data;
	}
	
	public Node<E> getNext() {
		return next;
	}
	
	public Node<E> getPrev() {
		return prev;
	}
	
	public void setNext(Node<E> n) {
		next=n;
	}
	
	public void setPrev(Node<E> p) {
		prev=p;
	}
}