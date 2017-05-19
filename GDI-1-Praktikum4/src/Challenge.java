import java.util.Scanner;

public class Challenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
		int [][] schuhschrank = new int [2][2];
		int gesamt;
		int welchesFach;	
		int nochmal = 1;
		
		do
		{
			System.out.println("In welchem Fach möchten Sie etwas hinzufügen ?");
			welchesFach = s.nextInt();
			
			switch(welchesFach)
			{
			case 1:
				if(welchesFach == 1)
					System.out.println("Geben Sie die Anzahl ein");
					schuhschrank[0][0] = s.nextInt();
					break;
			case 2:		
				if(welchesFach == 2)
						System.out.println("Geben Sie die Anzahl ein");
						schuhschrank[0][1] = s.nextInt();
						break;
			case 3:	
				if(welchesFach == 3)
							System.out.println("Geben Sie die Anzahl ein");
							schuhschrank[1][0] = s.nextInt();
							break;
			case 4:
				if(welchesFach == 4)
								System.out.println("Geben Sie die Anzahl ein");
								schuhschrank[1][1] = s.nextInt();
								break;
								
			default: System.out.println("Bitte nur Zahlen von 1-4 eingeben");
			
			}
			System.out.println("Möchten Sie nochwas hinzufügen ? ");
			nochmal = s.nextInt();
		}
		
			
			while(nochmal == 1);
		gesamt = schuhschrank[0][0] +schuhschrank[0][1]+schuhschrank[1][0]+schuhschrank[1][1];	
		System.out.println("Insgesammt befinden sich im Schrank "+gesamt);
		}

}
