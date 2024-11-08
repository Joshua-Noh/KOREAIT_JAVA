package 나도코딩;

public class OperatorExam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num01 = 100;
		byte byNum01 = 10;
		long lyNum01 = 20;
		double dyNum01 = 33.333;
		
		// byte끼리 합산하나 결과는 int로 출력
		// byte byResult = byNum01 + byNum01;
		
		int inResult01 = byNum01 + byNum01;
		
		
		// inResult01 = lyNum01 + num01;
		long InResult01 = lyNum01 + num01;
		
		inResult01 = byNum01 + num01;
		
		int target = 10;
		System.out.println(target % 3);
		
		//증감연산자는 변수 앞 뒤에 붙인다
		// 위치에 따른 연산의 순서가 달라지므로 중요
		int num = 10;
		int sum = 0;
		
		sum = num++;
		
		String str = "";
		
		// 비교연산자
		
		int a = 10;
		int b = 15;
		int c = 12;
		
		System.out.println(a >= b);
		System.out.println(a < b);
		System.out.println( c == b);
		System.out.println( a !=b);
		
		//논리연산 && ||
		
		
		
	}

}
