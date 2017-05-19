
public class Angestellte extends Mitarbeiter {

	
	boolean firmenwagen = true;
	
	public Angestellte(String name, String vorname, String bezeichnung, int gehalt, boolean firmenwagen) {
		super(name, vorname, bezeichnung, gehalt);
		this.firmenwagen = firmenwagen;		
		
	}
	//nochaml überarbeiten
	public void urlaubNehmen(int tage)
	{
		int rest = 26 - tage;
		if(tage <= 26)
		{
			System.out.println("Schönen Urlaub");
			System.out.println("Sie haben noch:"+rest +" Urlaubstage zur Verfügung.");
		}
		else
		{
			System.out.println("Sie haben nicht genug Urlaubstage.");
		}
	}

}
