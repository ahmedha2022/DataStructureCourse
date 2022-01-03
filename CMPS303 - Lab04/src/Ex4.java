
public class Ex4 {

	public static double[] prefixTotal1(double a[])
	{
		double tmp[]=new double[a.length];
		for (int i=0;i<a.length;i++) {
			double sum=0;
			for (int j=0;j<=i;j++)
				sum=sum+a[j];
			tmp[i]=sum;
		}
		return tmp;
	}

	public static double[] prefixTotal2(double a[])
	{
		double tmp[]=new double[a.length];
		double sum=0;
		for (int i=0;i<a.length;i++) {
			sum=sum+a[i];
			tmp[i]=sum;
		}
		return tmp;
	}

}
