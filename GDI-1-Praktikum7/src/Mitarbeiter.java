
public class Mitarbeiter {
	
	String name;
	String vorname;
	String bezeichnung;
	int gehalt;
	/**
	 * @param name
	 * @param vorname
	 * @param bezeichnung
	 * @param gehalt
	 */
	public Mitarbeiter(String name, String vorname, String bezeichnung, int gehalt) {
		
		this.name = name;
		this.vorname = vorname;
		this.bezeichnung = bezeichnung;
		this.gehalt = gehalt;
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
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}
	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	/**
	 * @return the bezeichnung
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}
	/**
	 * @param bezeichnung the bezeichnung to set
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	/**
	 * @return the gehalt
	 */
	public int getGehalt() {
		return gehalt;
	}
	/**
	 * @param gehalt the gehalt to set
	 */
	public void setGehalt(int gehalt) {
		this.gehalt = gehalt;
	}
	
	public void gehaltErhoehen(int betrag)
	{
		int gehalt = betrag + this.gehalt;
		System.out.println("Das neue Gehalt von " +this.getVorname() +" "+this.getName() +" beträgt "+gehalt);
	}
	
	

}
