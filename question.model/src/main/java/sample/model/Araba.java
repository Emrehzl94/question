package sample.model;

public class Araba extends Arac {

	public Araba(String color) {
		super();
		System.out.println("ARABA");

	}
	public String getColor() {
		return "blue";
	}
	@Override
	public String toString() {
		return super.getColor();
	}
	@Override
	public void hizlan() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 200;
	}
	@Override
	public double calculateAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
