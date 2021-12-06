
public class Main 
{
	public static void main(String[] args)
	{
		int n = 0;
		n = 360000;
		System.out.println("ѕрибыль в час с 2 каналами и без очереди - " + noQue(n, 2));
		System.out.println("ѕрибыль в час с 3 каналами и без очереди - " + noQue(n, 3));
		System.out.println("ѕрибыль в час с 2 каналами и с 2-х местной очередью - " + queue(n, 2, 1));
	}
	
	public static double noQue(int n, int numberOfChannels)
	{
		int[] timeOfWorkingChannels = new int[numberOfChannels];
		int[] t = new int[numberOfChannels];
		
		double profit = 0;
		double time = 0;
		double lastRequest = 0;
		double x = 0;
		
		for(int i = 0; i< numberOfChannels; i++)
		{
			timeOfWorkingChannels[i] = 0;
			t[i] = 0;
		}
	
		x = Math.random();
		time = -15 * (Math.log(x));
		
		for(int i = 1; i <=n; i++)
		{
			
			if(i>= lastRequest + time)
			{
				for(int j = 0; j < numberOfChannels; j++)
				{
					if(t[j] == 0)
					{
						t[j] = 1;
						break;
					}
				}
				lastRequest = i;
				x = 0;
				x = Math.random();
				time = -15*(Math.log(x));
			}
			for(int j = 0; j < numberOfChannels; j++)
			{
				if((t[j] == 1)&&(timeOfWorkingChannels[j] > 0))
				{
					timeOfWorkingChannels[j]--;
				}
				if((t[j] == 1)&&(timeOfWorkingChannels[j] == 0))
				{
					t[j] = 0;
					timeOfWorkingChannels[j] = 48;
					profit += 4;
				}
			}
			if(i % 60 == 0)
				profit -= 2 * numberOfChannels;
		}
		return profit / (n / 60);
	}
	
	public static double queue(int n, int numberOfChannels, int m)
	{
		int[] timeOfWorkingChannels = new int[numberOfChannels];
		int[] t = new int[numberOfChannels];
		
		int que = 0;
		double profit = 0;
		double time = 0;
		double lastRequest = 0;
		double x = 0;
		
		for(int i = 0; i< numberOfChannels; i++)
		{
			timeOfWorkingChannels[i] = 0;
			t[i] = 0;
		}
	
		x = Math.random();
		time = -1 * (Math.log(x));
		
		for(int i = 1; i <=n; i++)
		{
			if(i>= lastRequest + time)
			{
				int fl = 0;
				
				for(int j = 0; j < numberOfChannels; j++)
				{

					if(t[j] == 0)
					{
						t[j] = 1;
						fl = 1;
						break;
					}
				}
				
				if((fl == 0)&&(que < m))
				{
					que++;
				}
				lastRequest = i;
				x = 0;
				x = Math.random();
				time = -1 * (Math.log(x));
			}
			for(int j = 0; j < numberOfChannels; j++)
			{
				if((t[j] == 0)&&(que > 0))
				{
					t[j] = 1;
					que--;
					timeOfWorkingChannels[j] = 48;
				}
				if((t[j] == 1)&&(timeOfWorkingChannels[j] > 0))
				{
					timeOfWorkingChannels[j]--;
				}
				if((t[j] == 1)&&(timeOfWorkingChannels[j] == 0))
				{
					t[j] = 0;
					timeOfWorkingChannels[j] = 2;
					profit += 4;
				}
			}
			
			if(i % 60 == 0)
				profit -= 20 * m;
		}
		return profit / (n / 60);
	}
}
