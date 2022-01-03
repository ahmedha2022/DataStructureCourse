public class SortedList {
	private Node head=null;
	private Node tail=null;
	
	public int size()
	{
		int c=0;
		Node current=head;
		while (current!=null)
		{
			c++;
			current=current.getNext();
		}
		return c;

	}
	public Student removeFirst()
	{
		if (head!=null)
		{
			Student tmp=head.getElement();
			head=head.getNext();
			return tmp;
		}
		else
			return null;
	}
	public void insert(Student s) //insert in ordered list. 
	{
		int key = s.getId();
		Node previous = null; 
		Node current = head;;
		while(current != null && key > current.getElement().getId())
		{ 
			previous = current;
			current = current.getNext(); 
		}
		if(previous==null) 
			head = new Node(s,head);
		else 
			previous.setNext(new Node(s,current)); 
	} 

	public Student find(int key)
	{
		Node current=head;
		while (current!=null && current.getElement().getId()<=key)
		{
			if (current.getElement().getId()==key)
				return current.getElement();
			current=current.getNext();
		}
		return null;

	}


	public void delete(int key)
	{
		Node previous = null; 
		Node current = head;

		while(current != null && key != current.getElement().getId())
		{
			previous = current;
			current = current.getNext(); 
		}

		if(previous==null) // if beginning of list
			head = head.getNext(); // delete first node
		else // not at beginning
			previous.setNext(current.getNext());
	}
	public void displayList()
	{
		Node current=head;
		while (current!=null)
		{
			System.out.println(current.getElement());
			current=current.getNext();
		}
	}

}