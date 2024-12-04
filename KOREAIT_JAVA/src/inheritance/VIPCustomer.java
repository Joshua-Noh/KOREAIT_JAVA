package inheritance;

public class VIPCustomer extends Customer {
	private int agentID; // VIP 고객 상담원 아이디
	double saleRatio; // 할인율
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio; // 보너스 포인트 적립
		return price - (int)(price * saleRatio); // 할인된 가격을 계산하여 반환
	}
	
	public VIPCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
//		System.out.println("VIPCustomer() 생성자 호출");
	}
	
	public int getAgentID() {
		return agentID;
		

	}
}
