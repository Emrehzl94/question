package sample.model;

public abstract class Arac implements Sellable, Policyable{

	public abstract void hizlan();

	public Arac() {
		super();
		System.out.println("ARAC");
	}

	public String getColor() {
		return "red";
	}


	
	


}
