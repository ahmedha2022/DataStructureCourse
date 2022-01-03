
public class ArrayMethods {

	public static boolean equal(int a[], int b[]) {
		if(a.length != b.length)	//5
			return false;

		for(int index = 0 ; index < a.length ; index++)
			if(a[index] != b[index])
				return false;

		return true;
	}

	public static boolean sameElements(int a[],int b[]) {
		for(int indexA = 0 ; indexA < a.length ; indexA++)
		{
			boolean found = false;
			for(int indexB = 0 ; indexB < b.length ; indexB++)
				if(a[indexA] == b[indexB])
				{
					found = true;
					break;
				}
			if(found == false)
				return false;
		}
		return true;
	}
	
	public static int[] removeDuplicate(int oldArr[]) {
		int newArr[] = new int[oldArr.length];
		int counter = 0;
		
		for(int element : oldArr)
		{
			boolean alreadyCopied = false;
			for(int indexNewArr = 0 ; indexNewArr < counter ; indexNewArr++)
				if(element == newArr[indexNewArr])
				{
					alreadyCopied = true;
					break;
				}
			if(alreadyCopied == false)
				newArr[counter++] = element;
		}
		
		int tempArr[] = new int[counter];
		for(int index = 0 ; index < counter ; index++)
			tempArr[index] = newArr[index];
		
		return tempArr;		
	}
	
	public static void main(String args[]) {
		int x[] = {4, 5, 2, 4, 3};
		int y[] = {2, 5, 4, 3};
		System.out.println(sameElements(x, y));
		int n[] = removeDuplicate(x);
		for(int element: n)
			System.out.println(element);
	}

}
