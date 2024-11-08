package 나도코딩;

public class _Quiz_02 {
	public static void main(String[] args) {
		//어린이 키에 따른 놀이기구 탑승여부
		// 조건 120cm이상, 삼항 연산자 이용
		
		int height = 115;
		String result =(height >= 120) ? "탑승 가능" : "탑승 불가능";
		System.out.println("키가" + height + "cm 이므로 " + result);
	}
}
