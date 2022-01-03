
public class Heap <E>{
	private Node<E> heapArray[];
	private int size;
	public Heap(int mx)
	{
		
		size=0;
		heapArray=new Node[mx];
	}
   public boolean isEmpty()
   {
	   return size==0;
   }
   public int size()
   {
	   return size;
   }
   private void upheap(int i)
   {
	   int parent=(i-1)/2;
	   Node<E> bottom=heapArray[i];
	   while (i>0 && heapArray[parent].key<bottom.key)
	   {
		   heapArray[i]=heapArray[parent];
		   i=parent;
		   parent=(parent-1)/2;
	   }
	   heapArray[i]=bottom;
   }
   private void upheap2(int i)
   {
	    if (i>0 && heapArray[(i-1)/2].key<heapArray[i].key)
	    {
	    	Node<E> t=heapArray[i];
	    	heapArray[i]=heapArray[(i-1)/2];
	    	heapArray[(i-1)/2]=t;
	    	upheap2((i-1)/2);
	    	
	    }
   }
   public void insert(int k, E d)throws IllegalStateException 
   {
	   if (size( ) == heapArray.length) throw new IllegalStateException("Heap is full");
	   Node<E> newNode=new Node<>(k,d);
	   heapArray[size]=newNode;
	   upheap2(size);
	   size++; 
   }
   private boolean hasLeftChild(int i)
   {
	   if ((2*i+1)<size)
		   return true;
	   else
		   return false;
   }
   private boolean hasRightChild(int i)
   {
	   if ((2*i+2)<size)
		   return true;
	   else
		   return false;
   }
   
   public void downHeap(int i)
   {
	   int largerChild;
	   Node<E> top=heapArray[i];
	   while (hasLeftChild(i))  // node has at least one child
	   {
		   int leftChild=2*i+1;
		   largerChild=leftChild;
		   if (hasRightChild(i))
		   {
			   int rightChild=2*i+2;
			   if (heapArray[rightChild].key>heapArray[leftChild].key)
				   largerChild=rightChild;			   
		   }
		   
		   if (top.key>heapArray[largerChild].key)
			break;
		   
		   heapArray[i]=heapArray[largerChild];
		   i=largerChild;			
	   }
	   heapArray[i]=top;
   }
   public Node<E> removeMax()
   {
	   if (isEmpty())
		   return null;
	   Node<E> tmp=heapArray[0];
	   heapArray[0]=heapArray[--size];
	   heapArray[size]=null;
	   downHeap(0);
	   return tmp;
	   
   }
   public Node<E> max()
   {
	   if (isEmpty())
		   return null;
	   return heapArray[0];
   }
   public void print()
   {
	   for (int i=0;i<size;i++)
	   {
		   heapArray[i].display();
	   }
   }
   public E search(int k)
   {
	   for (int i=0;i<size;i++)
		   if (heapArray[i].key==k)
			   return heapArray[i].data;
	   return null;
   }
   public void travers(int i)
   {
	   if (i==1)
		   preorder(0);
	   else
		   if (i==2)
			   inorder(0);
		   else
			   postorder(0);
	   
   }
   public void preorder(int i)
   {
	   if (i<size)
	   {
		   heapArray[i].display();
	       preorder(i*2+1);
	       preorder(i*2+2);
	   }
   }
   public void inorder(int i)
   {
	   if (i<size)
	   {
		   inorder(i*2+1);
		   heapArray[i].display();
	       inorder(i*2+2);
	   }
   }
   public void postorder(int i)
   {
	   if (i<size)
	   {
		   postorder(i*2+1);
		   postorder(i*2+2);
		   heapArray[i].display();
	   }
   }
}
