public class ChainingHashTable
{
	private SortedList[] hashArray;   // array of lists
	private int arraySize;

	// -------------------------------------------------------------
	public ChainingHashTable(int size)        // constructor
	{
		arraySize = size;
		hashArray = new SortedList[arraySize];  // create array
		for(int j=0; j<arraySize; j++)          // fill array
			hashArray[j] = new SortedList();     // with lists
	}

	// -------------------------------------------------------------
	public double loadFactor()
	{
		double c=0;
		for (int i=0;i<arraySize;i++)
			c=c+hashArray[i].size();

		return c/arraySize;
	}

	// -------------------------------------------------------------
	public void rehash()
	{
		SortedList oldArray[]=hashArray;
		arraySize*=2;
		hashArray=new SortedList[arraySize];

		for (int i=0;i<arraySize;i++)
			hashArray[i]=new SortedList();


		for(int i=0;i<arraySize/2;i++)
		{
			Student t=oldArray[i].removeFirst();
			while (t!=null)
			{
				insert(t);
				t=oldArray[i].removeFirst();
			}
		}
	}

	// -------------------------------------------------------------
	public void displayTable()
	{
		for(int j=0; j<arraySize; j++) // for each cell,
		{
			System.out.print(j + ".\n"); // display cell number
			hashArray[j].displayList(); // display list
			System.out.println("");
		}
	}

	// -------------------------------------------------------------
	public int hashFunc(int key)      // hash function
	{
		return key % arraySize;
	}

	// -------------------------------------------------------------
	public void insert(Student s)  
	{
		int key = s.getId();
		int hashVal = hashFunc(key);   // hash the key
		hashArray[hashVal].insert(s); // insert at hashVal
	}  // end insert()

	// -------------------------------------------------------------
	public void delete(int key)       // delete a node
	{
		int hashVal = hashFunc(key);   // hash the key
		hashArray[hashVal].delete(key); // delete the node
	}  // end delete()

	// -------------------------------------------------------------
	public Student find(int key)         
	{
		int hashVal = hashFunc(key);   
		Student s = hashArray[hashVal].find(key);   
		return s;               
	}

}