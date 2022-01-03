public class SinglyLinkedList<E> {
	private Node<E> head=null;
	private Node<E> tail=null;
	private int size=0;
	public int size() { return size;}
	public boolean isEmpty(){ return size==0;}
	public E first()
	{
		if (isEmpty()) return null;
		return head.getElement();
	}
	public E last()
	{
		if (isEmpty()) return null;
		return tail.getElement();
	}
	public void addFirst(E e)
	{
		head=new Node<>(e,head);
		if(size==0)
			tail=head;
		size++;
	}
	public void addLast(E e)
	{
		Node<E> newest=new Node<>(e,null);
		if(isEmpty())
			head=newest;
		else
			tail.setNext(newest);
		tail=newest;
		size++;
	}
	public E removeFirst()
	{
		if(isEmpty()) return null;
		E answer=head.getElement();
		head=head.getNext();
		size--;
		if (size==0)
			tail=null;
		return answer;
	}
	SinglyLinkedList<E> copy()
	{
		SinglyLinkedList<E> t=new SinglyLinkedList<E>();
		Node<E> n=head;
		while(n!=null)
		{
			t.addLast(n.getElement());
			n=n.getNext();
		}
		return t;
	}
	public SinglyLinkedList<E> intersection(SinglyLinkedList<E> list)
	{
		SinglyLinkedList<E> tmp=new SinglyLinkedList<E>();
		for (Node<E> t=head;t!=null;t=t.getNext())
			for (Node<E> t2=list.head;t2!=null;t2=t2.getNext())
				if (t.getElement()==t2.getElement())
					tmp.addLast(t.getElement());
		return tmp;
	}

	public boolean sameElements(SinglyLinkedList<E> list)
	{

		for (Node<E> t=head; t!=null;t=t.getNext())
		{
			boolean found=false;
			for (Node<E> t2=list.head;t2!=null;t=t.getNext())
				if (t.getElement()==t2.getElement())
				{
					found=true;
					break;
				}
			if(!found)
				return false;
		}
		return true;
	}

}