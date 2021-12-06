public class Main {

	public static void main(String[] args) 
	{
		Imitation imitation = new Imitation();
		for(int i = 0; i < 10000000; i++)
			imitation.nextState(i);
		System.out.println(imitation);
	}

}
