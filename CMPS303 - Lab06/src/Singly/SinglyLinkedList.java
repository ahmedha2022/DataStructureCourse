package Singly;

public class SinglyLinkedList <E> {

	private Node<E> head=null;
	private Node<E> tail=null;
	private int size=0;

	public SinglyLinkedList() {
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public E first() {
		if (isEmpty())
			return null;
		return head.getData();
	}

	public E last() {
		if (isEmpty())
			return null;
		return tail.getData();
	}

	public void addFirst(E e) {
		head=new Node<>(e,head);
		if(size==0)
			tail=head;
		size++;
	}

	public void addLast(E e) {
		Node<E> newest=new Node<>(e,null);
		if(isEmpty())
			head=newest;
		else
			tail.setNext(newest);

		tail=newest;
		size++;
	}

	public E removeFirst() {
		if(isEmpty())
			return null;

		E answer=head.getData();
		head = head.getNext();
		size--;

		if (size==0)
			tail=null;

		return answer;
	}

	public E removeLast() {
		if(isEmpty())
			return null;
		E answer = tail.getData();
		if (head==tail)
			head=tail=null;
		else
		{
			Node<E> tmp=head;

			while (tmp.getNext()!=tail)
				tmp=tmp.getNext();

			tmp.setNext(null);
			tail=tmp;
		}

		size--;
		return answer;
	}

	public void display() {
		for (Node<E> tmp = head ; tmp != null ; tmp = tmp.getNext())
			System.out.println(tmp.getData());
	}

	public E get(int n) {		//n=5 ==> node number 5
		if (n<1 || n>size)
			return null;

		Node<E> tmp = head;

		for (int index = 1 ; index < n ; index++)
			tmp=tmp.getNext();

		return tmp.getData();
	}

	public void insertAfter(int n, E e) {		//node 5
		if (n < 1 || n > size) {
			System.out.println("Invalid node number.");
			return;
		}

		if (n==size)
			addLast(e);
		else
		{
			Node<E> tmp = head;
			for (int index = 1 ; index<n ; index++)
				tmp=tmp.getNext();

			Node<E> newest = new Node(e, tmp.getNext());
			tmp.setNext(newest);
			size++;
		}
	}
	
	
	
	
	
	
	
	
	
	

	public E remove(int n) {
		if (n<1 || n>size)
			return null;

		if (n==1)
			return removeFirst();

		if (n==size)
			return removeLast();

		Node<E> tmp=head;
		for (int index=1 ; index<n-1 ; index++)
			tmp=tmp.getNext();

		E answer=tmp.getNext().getData();
		tmp.setNext(tmp.getNext().getNext());
		size--;
		return answer;
	}
	
	public void reverse() {
		int n=size();
		E tmp[]=(E[]) new Object[n];

		for (int index = 0 ; index<n ; index++)
			tmp[index]=removeFirst();

		for (int index=0 ; index<n ; index++)
			addFirst(tmp[index]);
	}

}