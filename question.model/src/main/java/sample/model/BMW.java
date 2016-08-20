package sample.model;

public class BMW extends Araba {
	public String getColor() {
		return "black";
	}

	public BMW() {
		super("black");
		System.out.println("BMW");

	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 10000;
	}

	
	
	
}
