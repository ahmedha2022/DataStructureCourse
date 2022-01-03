public class DoubleHashing
{
	private Student[] hashArray;    // array holds hash table
	private int arraySize;
	private Student  defunct;        // for deleted items
	// -------------------------------------------------------------
	public DoubleHashing(int size)       // constructor
	{
		arraySize = size;
		hashArray = new Student[arraySize];
		defunct = new Student(-1,"null",0);   // deleted item key is -1
	}
	// -------------------------------------------------------------
	public void displayTable()
	{
		System.out.println("Table: ");
		for(int j=0; j<arraySize; j++)
			if(hashArray[j] != null)
				System.out.println(hashArray[j]);
			else
				System.out.println("** ");
	}
	//--------------------------------------------------
	public boolean isFull()
	{
		for (int i=0;i<arraySize;i++)
			if(hashArray[i]==null || hashArray[i]==defunct)
				return false;
		return true;

	}
	// -------------------------------------------------------------
	public int hashFunc(int key)
	{
		return key % arraySize;       // hash function
	}
	public int hashFunc2(int key)
	{
		return 5-(key%5); // 5 is prime number less than table size
	}
	// -------------------------------------------------------------
	public void insert(Student s) 
	{
		if (!isFull())
		{
			int key = s.getId();      // extract key
			int hashVal = hashFunc(key);  // hash the key

			while(hashArray[hashVal] != null && hashArray[hashVal]!= defunct)
			{
				hashVal+=hashFunc2(key);             // go to next cell
				hashVal %= arraySize;      // wraparound if necessary
			}
			hashArray[hashVal] = s;    // insert item
		}
	}// end insert()
	// -------------------------------------------------------------
	public Student delete(int key)  // delete a DataItem
	{
		int hashVal = hashFunc(key);  // hash the key
		int start=hashVal;
		boolean checkAll=false;
		while(hashArray[hashVal] != null && !checkAll)  
		{                               
			if(hashArray[hashVal].getId() == key)
			{
				Student temp = hashArray[hashVal]; // save item
				hashArray[hashVal] = defunct;       // delete item
				return temp;                        // return item
			}
			hashVal+=hashFunc2(key);                // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
			if (hashVal==start) // if we compare all and go back to the same start index
				checkAll=true;
		}
		return null;                  // can't find item
	}  // end delete()
	// -------------------------------------------------------------
	public Student find(int key)    // find item with key
	{
		int hashVal = hashFunc(key);  // hash the key
		int start=hashVal;
		boolean checkAll=false;
		while(hashArray[hashVal] != null && !checkAll)  // until empty cell,
		{                               // found the key?
			if(hashArray[hashVal].getId() == key)
				return hashArray[hashVal];   // yes, return item
			hashVal+=hashFunc2(key);                // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
			if (hashVal==start) // if we compare all and go back to the same start index
				checkAll=true;
		}
		return null;                  // can't find item
	}
	// -------------------------------------------------------------
}  