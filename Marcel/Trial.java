
public class Trial {
	public static void main(String[] args) {
		int[][] a = new int[3][3];
		
		a[0][0] = 1;
		
		print(a);	//also die linkere obere Ecke hat koordinaten (0, 0)
	}
	private static void print(int [][]a) {
		for(int i = 0; i < a.length; i ++) {
			for(int j = 0; j < a[0].length; j ++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
