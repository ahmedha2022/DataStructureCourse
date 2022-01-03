import java.util.ArrayList;

public class WaitingList <G> {
	private ArrayList<G> array = new ArrayList<>();

	public void add(G element) {
		array.add(element);
	}

	public G get(int index) {
		if(index < array.size() && index >= 0)
			return array.get(index);
		else
			return null;
	}
	
	public G remove() {
//		G temp = array.remove(0); 
//		return temp;
		
		return array.remove(0);
	}
	
	public void print() {
		for(G object : array)
			System.out.println(object);
	}
	
	public void reverse() {
		G temp;
		for(int i = 0 , j = array.size()-1 ; i < j ; i++ , j--)
		{
			temp = array.get(i);
			array.set(i, array.get(j));
			array.set(j, temp);
		}
	}



}
