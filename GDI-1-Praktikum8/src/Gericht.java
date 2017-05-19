
public class Gericht {
	String name;
	double preis;
	double neuerPreis;
	
	public double berechnePreis(String groesse)
	{
		if(groesse == "klein")
		{
			this.neuerPreis = this.preis/100 * 80;
			return neuerPreis;
		}
		else if(groesse=="mittel")
		{
			return preis;
		}
		else if(groesse=="groﬂ")
		{
			this.neuerPreis = this.preis / 100 * 120;
			return neuerPreis;
		}
		
		return neuerPreis;
	}
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPreis() {
		return preis;
	}



	public void setPreis(double preis) {
		this.preis = preis;
	}



	public Gericht(String name, double preis) {
		super();
		this.name = name;
		this.preis = preis;
	}
	
	
}
