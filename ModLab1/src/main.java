import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main 
{
	public static void main(String[] args)
	{
		double[] x = new double[20];
		
		System.out.println("Введите число а:");
		Scanner scanner = new Scanner(System.in);
		
		int a = scanner.nextInt();
		
		System.out.println("Введите число m:");
		
		int m = scanner.nextInt();
		
		System.out.println("Введите число Ro:");
		
		int r = scanner.nextInt();
		
		Random rand = new Random(a, m, r);
		System.out.println(rand.next());
		
		ArrayList<Double> randArray = new ArrayList<Double>();
		//нахождение периода
		for(int i=0; i<200000; i++)
		{
			randArray.add(rand.next());
		}
		System.out.println("Size = " + randArray.size());
		Double xV = rand.Current();
		rand.reset();
		int i1 =-1, i2 = -1;
		boolean flag = false;
		
		for(int i = 0; i<randArray.size(); i++)
		{
			if(randArray.get(i).compareTo(xV) == 0)
			{
				if(!flag)
				{
					flag = true;
					i1 = i;
					continue;
				}
				else
				{
					i2 = i;
					break;
				}
			}
		}
		int period = i2 - i1;
		
		//участок aпериодичности
		int i3 = 0;
		while(randArray.get(i3).compareTo(randArray.get(i3 + period)) != 0)
		{
			i3++;
			if(i3 == randArray.size()) break;
		}
		int aperiod = i3 + period;
		for(int i = aperiod; i < randArray.size(); i++)
			randArray.remove(aperiod);
		
		//mx
		Double mx = 0.0;
		for(int i = 0; i < aperiod; i++)
		{
			mx += randArray.get(i);
		}
		
		mx /= aperiod;
		
		//dx
		Double dx = 0.0;
		for(int i = 0; i < aperiod; i++)
		{
			dx += (randArray.get(i) - mx) * (randArray.get(i) - mx);
		}
		
		dx /= aperiod - 1;
		
		//ax
		Double ax = Math.sqrt(dx);
		
		//check uniformity
		
		int k = 0, n= aperiod;
		for(int i = 0; i < aperiod; i+= 2)
		{
			Double q = Math.pow(randArray.get(i), 2) + Math.pow(randArray.get(i+1), 2);
			if(q.compareTo(1.0) == -1)
					k++;
			
		}
		
		//output
		System.out.println("Мат.ожидание = " + mx);
		System.out.println("Дисперсия = " + dx);
		System.out.println("Отклонение = " + ax);
		System.out.println("2K/N = " + (double)2*k / n);
		System.out.println("PI/4 = " + Math.PI / 4);
		System.out.println("Длинна периода = " + period);
		System.out.println("Длинна апериодичности = " + aperiod);
		
		//гистограмма
		double[] histogram = new double[aperiod];
		for(int i = 0; i<aperiod; i++)
		{
			histogram[i] = randArray.get(i).doubleValue();
		}
		Window window = new Window(histogram);
		window.showWindow(histogram);
	}

}
