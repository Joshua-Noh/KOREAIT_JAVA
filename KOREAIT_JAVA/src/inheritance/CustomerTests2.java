package inheritance;

public class CustomerTests2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VIPCustomer customerKim = new VIPCustomer(); // 하위클래스 생성
		customerKim.setCustomerID(10020);
		customerKim.setCustomerName("김유신");
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.showCustomerInfo());
	}

}
