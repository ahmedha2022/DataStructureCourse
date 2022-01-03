
public class Tree<E> {
	private Node<E> root;
	
	public E search(int k)
	{
		Node<E> current=root;
		while(current.key!=k)
		{
			if (k<current.key)
				current=current.leftChild;
			else
				current=current.rightChild;
			if(current==null)
				return null;
		}
		return current.data;
	}

	public void insert(int k, E e)
	{
		Node<E> newNode = new Node(k,e); 
		if(root==null) 
			root = newNode;
		else 
		{
			Node current = root; 
			Node parent;
			while(true) {
				parent = current;
				if(k < current.key)
				{
					current = current.leftChild;
					if(current == null) { 
						parent.leftChild = newNode;
						return;
					}
				} 
				else{
					current = current.rightChild;
					if(current == null) { 
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public int max()
	{
		Node<E> current=root;
		while (current.rightChild!=null)
			current=current.rightChild;
		return current.key;
	}

	public int min()
	{
		Node<E> current=root;
		while (current.leftChild!=null)
			current=current.leftChild;
		return current.key;
	}
	
	//**==**==**==**==**==**==**==**==**==**==**==**==**==**==**==**==**==**==**==**==
	
	
	public void traverse(int traverseType)
	{
		switch (traverseType)
		{
		case 1: preorder(root); break;
		case 2: inorder(root);  break;
		case 3: postorder(root); break;
		}

	}
	public void preorder(Node<E> n)
	{
		if(n==null)
			return;
		else
		{
			n.display();
			preorder(n.leftChild);
			preorder(n.rightChild);
		}
	}
	public void inorder(Node<E> n)
	{
		if(n==null)
			return;
		else
		{
			inorder(n.leftChild);
			n.display();
			inorder(n.rightChild);
		}
	}
	public void postorder(Node<E> n)
	{
		if(n==null)
			return;
		else
		{
			postorder(n.leftChild);
			postorder(n.rightChild);
			n.display();
		}

	}
	

	
	public int depth(int k)
	{
		int d=0;
		Node<E> current=root;

		while(current.key!=k)
		{
			if (k<current.key)
				current=current.leftChild;
			else
				current=current.rightChild;
			d=d+1;
			if(current==null)
				return -1;
		}
		return d;
	}
	
	public void printLeaves()
	{
		printAllLeaves(root);
	}
	private void printAllLeaves(Node n)
	{
		if (n!=null)
			if (n.leftChild==null && n.rightChild==null)
				n.display();
			else
			{
				printAllLeaves(n.leftChild);
				printAllLeaves(n.rightChild);
			}
	}
	
	public int count()
	{
		return countNodes(root);
	}

	private int countNodes(Node n)
	{
		if (n==null)
			return 0;
		else
			return 1+countNodes(n.leftChild)+countNodes(n.rightChild);

	}

	public int countLeaves()
	{
		return countAllLeaves(root);
	}

	private int countAllLeaves(Node<E> n)
	{
		if (n!=null)
			if (n.leftChild==null && n.rightChild==null)
				return 1;
			else
				return countAllLeaves(n.leftChild)+countAllLeaves(n.rightChild);
		return 0;

	}	
}