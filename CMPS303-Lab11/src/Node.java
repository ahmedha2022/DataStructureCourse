
public class Node <E>{
	int key;
	E data;
	public Node(int k, E d)
	{
		key=k;
		data=d;
	}
	public void display()
	{
		System.out.print("Key:"+key);
		System.out.println(data);
	}

}