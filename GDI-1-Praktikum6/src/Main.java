
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rennauto BMW = new Rennauto (1,"Klaus","BMW","blau",200,0);
		Rennauto OPEL = new Rennauto(2,"Peter","Opel","rot",190,0);
		Rennauto VW = new Rennauto (3,"Marie","VW","gr�n",194,0);
		Rennauto Ford = new Rennauto(4,"Antje","Ford","gebl",186,0);
		Rennauto Audi = new Rennauto(5,"Stefan","Audi","wei�",192,0);
		
		/*System.out.println("Der Fahrer des" +BMW.getFarbe() + BMW.getName()+" hei�t "+BMW.getFahrer());
		System.out.println("Die H�chstgeschwindigkeit des"+OPEL.getFarbe()+OPEL.getName()+" liegt bei "+OPEL.getGeschwindigkeit());
		System.out.println("Der "+VW.getFarbe()+" "+VW.getName()+" hat die Startnummer "+VW.getStartnummer());
		*/
		int durchl�ufe = 0;
		for(int i = 0; i<=6; i++)
		{
			System.out.println("Trainingssession "+durchl�ufe +":");
			System.out.println("=========================");
			System.out.println("\n");			
			durchl�ufe++;
		
			BMW.fahren();			
			OPEL.fahren();
			VW.fahren();
			
			System.out.println("\n");
		}
		
	}

	

}
