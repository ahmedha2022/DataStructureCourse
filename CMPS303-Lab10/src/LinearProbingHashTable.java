public class LinearProbingHashTable
{
	private Student[] hashArray;    // array holds hash table
	private int arraySize;
	private Student  defunct;        // for deleted items
//	private int counter=0;
	

	// -------------------------------------------------------------
	public LinearProbingHashTable(int size)       // constructor
	{
		arraySize = size;
		hashArray = new Student[arraySize];
		defunct = new Student(-1,"null",0);   // deleted item key is -1
	}

	// -------------------------------------------------------------
	public double loadFactor()
	{
		double c=0;
		for (int i=0;i<arraySize;i++)
			if (hashArray[i]!=null && hashArray[i]!=defunct)
				c++;
		return c/arraySize;
	}
	
	// -------------------------------------------------------------
	public void rehash()
	{
		Student oldArray[]=hashArray;
		hashArray=new Student[arraySize*2];//oldArray points to old array
		
		arraySize*=2;
		for (int i=0;i<arraySize/2;i++)
			insert(oldArray[i]);
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
	
	// -------------------------------------------------------------
	public void insert(Student s) 
	{
		if (loadFactor()>=0.5)
			rehash();

		int key = s.getId();      // extract key
		int hashVal = hashFunc(key);  // hash the key

		while(hashArray[hashVal] != null && hashArray[hashVal]!= defunct)
		{
			hashVal++;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
		}
		hashArray[hashVal] = s;    // insert item

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
			hashVal++;                 // go to next cell
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
			hashVal++;                 // go to next cell
			hashVal %= arraySize;      // wraparound if necessary
			if (hashVal==start) // if we compare all and go back to the same start index
				checkAll=true;
		}
		return null;                  // can't find item
	}
}