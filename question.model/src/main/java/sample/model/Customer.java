package sample.model;

import java.util.ArrayList;

public class Customer {
	private Long tckn;
	private String firstName;
	private String lastName;
	private static double usdRate;
	
	
	
	public static double getUsdRate() {
		return usdRate;
	}
	public static void setUsdRate(double usdRate) {
		Customer.usdRate = usdRate;
	}
	public Customer() {
		
	}
	public Customer(Long x, String firstName, String lastName) {
		super();
		this.tckn = x;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	private ArrayList<Address> addressList;
	
	public ArrayList<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}
	public Long getTckn() {
		return tckn;
	}
	public void setTckn(Long tckn) {
		this.tckn = tckn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String fullName(){
		return firstName + " " + lastName; 
	}
	@Override
	public String toString() {
		return "Customer [tckn=" + tckn + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tckn == null) ? 0 : tckn.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (tckn == null) {
			if (other.tckn != null)
				return false;
		} else if (!tckn.equals(other.tckn))
			return false;
		return true;
	}
	

}
