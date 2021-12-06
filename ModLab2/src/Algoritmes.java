
public class Algoritmes 
{
	public static double[] uniformDistribution(double a, double b, int n) 
	{
		double[] x = new double[n];
		for(int i = 0; i < n; i++)
		{
			x[i] = a + (b - a) * Math.random();
		}
		calculateValues(x, n);
		return x;
	}
	
	public static double[] gaussDistribution(int N, double m, double sko, int n)
	{
		double[] x = new double[N];
		for(int i = 0; i < N; i++)
		{
			double tmp = 0;
			for(int j = 0; j < n; j++)
				tmp += Math.random();
			
			x[i] = m + sko * Math.sqrt(12.0 / n)*(tmp - (double) n/2);
		}
		calculateValues(x, N);
		return x;
	}
	
	public static double[] exponentalDistribution(int N, double l)
	{
		double[] x = new double[N];
		for(int i = 0; i < N; i++)
		{
			x[i] = - Math.log(Math.random()) / l;
		}
		calculateValues(x, N);
		return x;
	}
	
	public static double[] gammalDistribution(int N, int n, double l)
	{
		double[] x = new double[N];
		for(int i = 0; i < N; i++)
		{
			double tmp = 1;
			for(int j = 0; j < n; j++)
			{
				tmp *= Math.random();
			}
			x[i] = -Math.log(tmp) / l;
		}
		calculateValues(x, N);
		return x;
	}
	
	public static double[] triangleDistribution(int N, double a, double b)
	{
		double[] x = new double[N];
		for(int i = 0; i < N; i++)
		{
			x[i] = a + (b - a) * Math.max(Math.random(), Math.random());
		}
		calculateValues(x, N);
		return x;
	}
	
	public static double[] triangleDistributionMin(int N, double a, double b)
	{
		double[] x = new double[N];
		for(int i = 0; i < N; i++)
		{
			x[i] = a + (b - a) * Math.min(Math.random(), Math.random());
		}
		calculateValues(x, N);
		return x;
	}
	
	public static double[] simpsonDistribution(int N, double a, double b)
	{
		double[] x = new double[N];
		for(int i = 0; i < N; i++)
		{
			x[i] = a/2 + (b/2 - a/2)*Math.random() + a/2 +(b/2 - a/2) * Math.random();
		}
		calculateValues(x, N);
		return x;
	}
	
	public static void calculateValues(double[] x, int N)
	{
		double mx = 0;
		double dx = 0;
		
		for(int i = 0; i < N; i++)
		{
			mx += x[i];
		}
		
		mx = mx / N;
		System.out.println("Мат.ожидание = " + mx);
		
		for(int i = 0; i < N; i++)
		{
			dx += (x[i] - mx) * (x[i] - mx);
		}
		System.out.println("Дисперсия = " + dx / N);
		System.out.println("Среднее квадратичное отклонение  = " + Math.sqrt(dx / N));
	}

}
