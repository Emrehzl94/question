package sample.model;

public class Kamyon extends Arac{
	public String getColor() {
		return "white";
	}
	@Override
	public String toString() {
		return getColor();
	}
	@Override
	public void hizlan() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 300;
	}
	@Override
	public double calculateAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
