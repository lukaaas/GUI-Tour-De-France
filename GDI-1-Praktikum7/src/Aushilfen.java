
public class Aushilfen extends Mitarbeiter {
	
	double stundenlohn;
	int stundenGearbeitet = 0;

	/**
	 * @param name
	 * @param vorname
	 * @param bezeichnung
	 * @param gehalt
	 * @param stundenlohn
	 */
	public Aushilfen(String name, String vorname, String bezeichnung, int gehalt, double stundenlohn) {
		super(name, vorname, bezeichnung,gehalt);
		this.stundenlohn = stundenlohn;
	}
	
	public void arbeiten(int stunden)
	{
		this.stundenGearbeitet = stunden;
		
	}
	
	public double lohnBerechnen()
	{
		double lohn;
		lohn = this.stundenlohn * this.stundenGearbeitet;	
		System.out.println("Die Aushilfe "+this.vorname +" "+this.name +" hat insgesammt "+ lohn +"€ verdient.");
		
		return lohn;
	}

	
	
	

}
