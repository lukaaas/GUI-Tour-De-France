
public class Angestellte extends Mitarbeiter {

	
	boolean firmenwagen = true;
	
	public Angestellte(String name, String vorname, String bezeichnung, int gehalt, boolean firmenwagen) {
		super(name, vorname, bezeichnung, gehalt);
		this.firmenwagen = firmenwagen;		
		
	}
	//nochaml �berarbeiten
	public void urlaubNehmen(int tage)
	{
		int rest = 26 - tage;
		if(tage <= 26)
		{
			System.out.println("Sch�nen Urlaub");
			System.out.println("Sie haben noch:"+rest +" Urlaubstage zur Verf�gung.");
		}
		else
		{
			System.out.println("Sie haben nicht genug Urlaubstage.");
		}
	}

}
