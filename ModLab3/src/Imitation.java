
public class Imitation 
{
	private double p1 = 0.75;
	private double p2 = 0.7;
	
	public byte j;
	public byte t1;
	public byte t2;
	
	public int denialCounter;
	public int counter1;
	public int counter2;
	public int counterJ = 0;
	public int counterQueue = 0;
	public int[][][] counter;
	int counterWork = 0;
	
	public Imitation()
	{
		j = 0;
		t1 = 0;
		t2 = 0;
		counter1 = 0;
		counter2 = 0;
		denialCounter = 0;
		counter = new int[3][2][2];
	}
	
	public String toString()
	{
		return "P000 - " + (double)counter[0][0][0]/10000000 
				+ "\nP001 - " + (double)counter[0][0][1]/10000000
				+ "\nP010 - " + (double)counter[0][1][0]/10000000 
				+ "\nP011 - " + (double)counter[0][1][1]/10000000 
				+ "\nP111 - "+ (double)counter[1][1][1]/10000000 
				+ "\nP211 - "+ (double)counter[2][1][1]/10000000 
				+ "\nЗаблокировано - " + denialCounter  
				+ "\nСредняя длина очереди- " + (double)counterQueue/10000000
				+ "\nСреднее время заявки в очереди " + (double)counterQueue/counterJ
				+ "\nАбсолютная пропускная способность " + (double)counterWork/10000000;
	}
	
	private boolean isNoService1()
	{
		return Math.random() < p1;
	}

	private boolean isNoService2()
	{
		return Math.random() < p2;
	}
	
	public void checkChannels()
	{
		if(t1 == 1)
		{
			if(isNoService1()) counter1++;
			else 
				{
					t1 = 0;
					counterWork++;
				}
		}
		
		if(t2 == 1)
		{
			if(isNoService2()) counter2++;
			else 
				{
					t2 = 0;
					counterWork++;
				}
		}
	}
	
	public void checkQueue()
	{
		if(j == 2)
		{
			if(t1 == 0)
			{
				j--;
				t1 = 1;
				counter1++;
			}
			if(t2 == 0)
			{
				j--;
				t2 = 1;
				counter2++;
			}
		}
		
		else if(j == 1)
		{
			if(t1 == 0)
			{
				j--;
				t1 = 1;
				counter1++;
			}
			else if(t2 == 0)
			{
				j--;
				t2 = 1;
				counter2++;
			}
		}
	}

	public void checkNew(int i)
	{
		if(i % 2 == 1) return;
		
		if(j < 2)
		{
			if(t1 == 0)
			{
				t1 = 1;
				counter1++;
			}
			else if(t2 == 0)
			{
				t2 = 1;
				counter2++;
			}
			else j+=1;
		}
		else
		{
			denialCounter++;
			return;
		}
	}
	
	public void nextState(int i)
	{	
		counterJ+=j + t1 + t2;
		counter[j][t1][t2]++;	
		counterQueue += j;
		//сначала проверяем каналы
		checkChannels();
		//затем проверяем заявки и если есть отправляем на каналы
		checkQueue();
		//поступали ли новые
		checkNew(i);
		
	}

	public byte getJ() {
		return j;
	}
	public void setJ(byte j) {
		this.j = j;
	}
	public byte getT1() {
		return t1;
	}
	public void setT1(byte t1) {
		this.t1 = t1;
	}
	public byte getT2() {
		return t2;
	}
	public void setT2(byte t2) {
		this.t2 = t2;
	}
	public int getDenialCounter() {
		return denialCounter;
	}
	public void setDenialCounter(int denialCounter) {
		this.denialCounter = denialCounter;
	}
	public int getCounter1() {
		return counter1;
	}
	public void setCounter1(int counter1) {
		this.counter1 = counter1;
	}
	public int getCounter2() {
		return counter2;
	}
	public void setCounter2(int counter2) {
		this.counter2 = counter2;
	}
	
}
