public class Ex2 {
	public static void main(String args[]) {
		int n = 50000;		
		long start1 = System.currentTimeMillis();
		repeat1('a', n);
		long end1 = System.currentTimeMillis();
		System.out.println("repeat1 execution time is: " + (end1-start1));
		
		long start2 = System.currentTimeMillis();
		repeat2('a', n);
		long end2 = System.currentTimeMillis();
		System.out.println("repeat2 execution time is: " + (end2-start2));		
	}

	public static String repeat1(char c,int n){
		String s="";
		for (int i=0;i<n;i++)
			s=s+c;
		return s;
	}
	
	public static String repeat2(char c,int n){
		StringBuilder sb=new StringBuilder();
		for (int i=0;i<n;i++)
			sb.append(c);
		return sb.toString();
	}
}