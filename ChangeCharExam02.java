package 나도코딩;

public class ChangeCharExam02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		char ch = 'E';
		int num = 37;
		
		int chToNum = 0;
		char intToCh = ' ';
		
		//int와 char는 자동형변환
		//char --> int로 변경할 때는 자동형변황 가능
		
		chToNum= ch;
		//int->> char 변경시 강제형변환
		
		intToCh = (char)num;
		System.out.println(chToNum);
		
		
	}

}
