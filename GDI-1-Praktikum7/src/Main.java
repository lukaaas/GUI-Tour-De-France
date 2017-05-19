
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Angestellte mitarb1 = new Angestellte("Walser","Frank","Mitarbeiter",1600,false);	
		Angestellte mitarb2 = new Angestellte("Flink","Eva","Mitarbeiter",1650,true);
		Angestellte mitarb3 = new Angestellte("Boss","Hans","Mitarbeiter",3500,false);
		Angestellte azubi1 = new Angestellte("Vogel","Sven","Auszubildender",450,false);
		Aushilfen aushilf1 = new Aushilfen("Schmitz","Fritz","Aushilfe", 0,9.50);
		Aushilfen aushilf2 = new Aushilfen("Engel","Maike","Aushilfe",0,11);
		
		System.out.println("Mitarbeiter der TrinkWas GmbH");
		System.out.println("-----------------------------------");
		System.out.println("\n");
		
		System.out.println(mitarb1.getBezeichnung()+" "+mitarb1.getVorname() +" "+mitarb1.getName() +"  "+mitarb1.getGehalt());
		System.out.println(mitarb2.getBezeichnung()+" "+mitarb2.getVorname() +" "+mitarb2.getName() +"  "+mitarb2.getGehalt());
		System.out.println(mitarb3.getBezeichnung()+" "+mitarb3.getVorname() +" "+mitarb3.getName() +"  "+mitarb3.getGehalt());
		System.out.println(azubi1.getBezeichnung()+" "+azubi1.getVorname() +" "+azubi1.getName() +"  "+azubi1.getGehalt());
		
		System.out.println("\n");
		
		mitarb3.gehaltErhoehen(1000);
		System.out.println("\n");
		
		mitarb1.urlaubNehmen(14 + 14);				
		mitarb2.urlaubNehmen(22);
		mitarb3.urlaubNehmen(0);
		
		System.out.println("\n");			
		
		aushilf1.arbeiten(5 + 7);		
		aushilf2.arbeiten(3*6);
		
		System.out.println("\n");
		aushilf1.lohnBerechnen();
		aushilf2.lohnBerechnen();
		
		
		

	}

}
