
public class Random 
{
	private long a, m, rPrev, r0;
	
	public Random(long a, long m, long r0)
	{
		this.a = a;
		this.m = m;
		this.r0 = r0;
		this.rPrev = r0;
	}
	
	public Double next()
	{
		rPrev = (a * rPrev) % m;
		return (double)rPrev / (double)m;
	}
	
	public void reset()
	{
		rPrev = r0;
	}
	
	public Double Current()
	{
		return (double)rPrev / (double)m;
	}
}
