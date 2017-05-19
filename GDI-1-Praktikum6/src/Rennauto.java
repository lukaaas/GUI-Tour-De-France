/**
 * 
 */

/**
 * @author Lukas
 *
 */

	
public class Rennauto {	
	
	public void fahren()
	{
		double faktor = Math.random() * 0.25 + 0.25;
		this.rundenzahl += this.getGeschwindigkeit() * faktor;
		
		System.out.println("Der "+this.getFarbe() +" "+this.getName() +" gefahren von "
				+ " "+this.getFahrer() +" hat jetzt "+this.rundenzahl +" Runden zurückgelegt.");
	}
	
	/**
	 * @param startnummer
	 * @param fahrer
	 * @param name
	 * @param farbe
	 * @param geschwindigkeit
	 * @param rundenzahl
	 */
	
	int startnummer;
	String fahrer;
	String name;
	String farbe;
	int geschwindigkeit;
	int rundenzahl = 0;
	
	
	public Rennauto(int startnummer, String fahrer, String name, String farbe, int geschwindigkeit, int rundenzahl) {
		super();
		this.startnummer = startnummer;
		this.fahrer = fahrer;
		this.name = name;
		this.farbe = farbe;
		this.geschwindigkeit = geschwindigkeit;
		this.rundenzahl = rundenzahl;
	}
	
	/**
	 * @return the startnummer
	 */
	public int getStartnummer() {
		return startnummer;
	}
	/**
	 * @param startnummer the startnummer to set
	 */
	public void setStartnummer(int startnummer) {
		this.startnummer = startnummer;
	}
	/**
	 * @return the fahrer
	 */
	public String getFahrer() {
		return fahrer;
	}
	/**
	 * @param fahrer the fahrer to set
	 */
	public void setFahrer(String fahrer) {
		this.fahrer = fahrer;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the farbe
	 */
	public String getFarbe() {
		return farbe;
	}
	/**
	 * @param farbe the farbe to set
	 */
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
	/**
	 * @return the geschwindigkeit
	 */
	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}
	/**
	 * @param geschwindigkeit the geschwindigkeit to set
	 */
	public void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}
	/**
	 * @return the rundenzahl
	 */
	public int getRundenzahl() {
		return rundenzahl;
	}
	/**
	 * @param rundenzahl the rundenzahl to set
	 */
	public void setRundenzahl(int rundenzahl) {
		this.rundenzahl = rundenzahl;
	}

	
	
}
