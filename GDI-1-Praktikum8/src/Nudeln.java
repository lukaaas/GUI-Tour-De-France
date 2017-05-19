
public class Nudeln extends Gericht {

	public Nudeln(String name, double preis) {
		super(name, preis);
		// TODO Auto-generated constructor stub
	}
	String sauce;
	
	
	
	public String ueberbacken()
	{	
		String s = "";
		System.out.println(s.concat(getName() +" Al Forno"));
		String backen = s.concat(getName() +" Al Forno");
		return backen;
		
	}

}
