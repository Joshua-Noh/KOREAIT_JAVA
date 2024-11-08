package 나도코딩;

public class _04_Operator4 {
	public static void main(String[] args) {
		// 논리 연산자
		boolean 김치찌개 = true;
		boolean 계란말이 = true;
		boolean 제육볶음 = false;
		
		System.out.println(김치찌개 || 계란말이 || 제육볶음);
		System.out.println(김치찌개 && 계란말이 && 제육볶음);

		System.out.println((5 > 3) && (3 > 1));
		System.out.println((5 > 3) && (3 < 1));
		
		System.out.println((5 > 3) || (3 > 1));
		System.out.println((5 > 3) || (3 < 1));
		System.out.println((5 < 3) || (3 < 1));
	
	// 결과값이 같더라도 가독성을 위해 괄호를 둘러싸는 연습 요망.
		
		System.out.println(!true);
		System.out.println(!false);
		System.out.println(!(5 == 5));
	
	}
}
