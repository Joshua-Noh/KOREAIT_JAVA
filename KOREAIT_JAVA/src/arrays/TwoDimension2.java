package arrays;

public class TwoDimension2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[2][3]; // 2행 3열 이차원 배열 선언
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j <arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
			System.out.println();
			
		}
		System.out.println(arr.length);
		System.out.println(arr[0].length);
	}

}