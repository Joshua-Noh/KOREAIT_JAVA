package finalex;

public class Constant {
	int num = 10;
	final int NUM = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constant cons = new Constant();
		cons.num = 50;
//		cons.NUM = 200; - 오류
		
		System.out.println(cons.num);
		System.out.println(cons.NUM);
	}

}
