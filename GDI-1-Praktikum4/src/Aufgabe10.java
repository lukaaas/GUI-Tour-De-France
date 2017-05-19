
public class Aufgabe10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num;
		int limit = 10;
		int div;
		int zaehler;
		
		for(num = 1; num <= limit; num++)
		{
			if(num != 1)
			{
				div = 0;
				for(zaehler =1; zaehler <=num; zaehler++ )
				{
					if(num % zaehler == 0)
					{
						div++;
					}
				}
				if(div == 2)
				{
					System.out.println(num +" ist eine Primzahl.");
				}
			}
		}

	}

}
