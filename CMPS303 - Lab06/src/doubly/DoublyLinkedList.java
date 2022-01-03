package doubly;

public class DoublyLinkedList <E>{

	private Node<E> header;
	private Node<E> trailer;
	private int size=0;

	public DoublyLinkedList() { 
		header=new Node<>(null,null,null);
		trailer=new Node<>(null,header,null);
		header.setNext(trailer);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public E first(){
		if (isEmpty())
			return null;
		return header.getNext().getData();
	}

	public E last(){
		if (isEmpty())
			return null;
		return trailer.getPrev().getData();
	}

	private void addBetween(E e, Node<E> predecessor, Node<E> successor){
		Node<E> newest=new Node<>(e,predecessor,successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	public void addFirst(E e) { 
		addBetween(e,header,header.getNext());
	}

	public void addLast(E e) {
		addBetween(e,trailer.getPrev(),trailer);
	}

	private E remove(Node<E> node) {
		Node<E> predecessor=node.getPrev();
		Node<E> successor=node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getData();
	}

	public E removeFirst() {
		if(isEmpty())
			return null;
		return remove(header.getNext());
	}

	public E removeLast() {
		if(isEmpty()) 
			return null;
		return remove(trailer.getPrev());
	}

	public void printForward() {
		for (Node<E> tmp=header.getNext();tmp!=trailer;tmp=tmp.getNext())
			System.out.println(tmp.getData());
	}

	public void printBackward() {
		for (Node<E> tmp=trailer.getPrev();tmp!=header;tmp=tmp.getPrev())
			System.out.println(tmp.getData());
	}

	public E get(int n) {	// n=10			==> size 50		==> the lower half "from the header"
		if (n<1 || n>size)	// n=40			==> size 50 	==> the upper half "from the trailer"
			return null;

		if (n<size/2) {
			Node<E> tmp=header.getNext();
			for (int index = 1 ; index < n ; index++)
				tmp = tmp.getNext();
			return tmp.getData();
		}
		else {
			Node<E> tmp=trailer.getPrev();
			for (int index = size ; index > n ; index--)
				tmp = tmp.getPrev();
			return tmp.getData();
		}
	}

	public void insertAfter(int n, E e) {
		Node<E> tmp;
		if (n<1 || n>size) {
			System.out.println("Invalid node number");
			return;
		}

		if (n==size)
			addLast(e);
		else {
			if (n<size/2) {       
				tmp=header.getNext();
				for (int i=1 ;i<n;i++)
					tmp=tmp.getNext();
			}
			else {
				tmp=trailer.getPrev();
				for (int i=size ;i>n;i--)
					tmp=tmp.getPrev();
			}

			Node<E> newst=new Node(e,tmp, tmp.getNext());
			tmp.getNext().setPrev(newst);
			tmp.setNext(newst);
			size++;
		}
	}

	public E remove(int n) {
		Node<E> tmp;
		if (n<1|| n>size)
			return null;

		if (n==1)
			return removeFirst();

		if (n==size)
			return removeLast();

		if(n<size/2) {
			tmp=header.getNext();
			for (int i=1 ; i<n ; i++)
				tmp=tmp.getNext();
		}
		else {
			tmp=trailer.getPrev();
			for (int i=size ; i>n ; i--)
				tmp=tmp.getNext();
		}

		E answer=tmp.getData();
		tmp.getNext().setPrev(tmp.getPrev());
		tmp.getPrev().setNext(tmp.getNext());
		size--;
		return answer;	
	}
}