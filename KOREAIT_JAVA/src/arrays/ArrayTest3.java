package arrays;

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] data = new double[5];
		int size = 0;
		
		data[0] = 10.0; size++;
		data[1] = 20.0; size++;
		data[2] = 30.0; size++;
		
		for(int i = 0; i < size; i++) {
			System.out.println(data[i]);
		}
		
	}

}
