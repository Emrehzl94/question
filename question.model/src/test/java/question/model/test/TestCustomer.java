package question.model.test;

import sample.model.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		Customer cust=new Customer(new Long(123),"halil","kaya");
		System.out.println(cust.fullName());
		System.out.println(cust);

		Customer cust2=new Customer(new Long(123),"halil","kaya");
		
		System.out.println(cust==cust2);
		System.out.println(cust.equals(cust2));
		
		Customer.setUsdRate(12.0);
		System.out.println(cust2.getUsdRate());
		System.out.println(cust.getUsdRate());
		
	}

}
