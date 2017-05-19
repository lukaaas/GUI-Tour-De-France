import java.util.Scanner;

public class Aufgabe11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] schublade = new int [4];
		int anzahl;
		int gesamt;
		int welcher;
		Scanner s = new Scanner (System.in);
		System.out.println("In welcher Schublade möchten Sie etwas hinzufügen ?");
		welcher = s.nextInt();
		
		switch(welcher)
		{
		case 1: if(welcher ==1)
		{
			System.out.println("Geben Sie die Anzahl ein");
			schublade[0] = s.nextInt();
			break;
		}
		case 2: if(welcher ==2)
		{
			System.out.println("Geben Sie die Anzahl ein");
			schublade[1] = s.nextInt();
			break;
		}
		case 3: if(welcher ==3)
		{
			System.out.println("Geben Sie die Anzahl ein");
			schublade[2] = s.nextInt();
			break;
			
		}
		case 4: if(welcher ==4)
		{
			System.out.println("Geben Sie die Anzahl ein");
			schublade[3] = s.nextInt();
			break;
		}
		
		}
		gesamt = schublade[0] +schublade[1] +schublade[2] + schublade[3];
		System.out.println(gesamt);

	}

}
