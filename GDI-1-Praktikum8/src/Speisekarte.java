
public class Speisekarte extends Gericht {
	

	//Test Feld Erzeugt um eine Speisekarte zu generieren
	Gericht [] speisekarte = new Gericht [10];
	

	public Speisekarte(String name, double preis, Gericht[] speisekarte) {
		super(name, preis);
		this.speisekarte = speisekarte;
	}

	public Gericht[] getSpeisekarte() {
		return speisekarte;
	}

	public void setSpeisekarte(Gericht[] speisekarte) {
		this.speisekarte = speisekarte;
	}
}
