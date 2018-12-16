
public class main {
	public static void main (String[] args) {
		
		
		// Make 2D Array
		int size = 4;
		int [][] intArray = new int [size][size];


		printSquareArray(intArray);
		
		System.out.println("Inserting 4 at position (1, 2)");
		intArray[1][2] = 4;
		printSquareArray(intArray);
		
		int word_length = 4;
		int zeile = 1;
		int spalte = 1;
		int direction = 1; //left to right
		//Check if word too long
		
		if(direction == 0) {
			if(size - spalte < word_length) {
				System.out.println("Cannot insert word: its too long");
			}
		}else {
			if(size - zeile < word_length) {
				System.out.println("Cannot insert word: its too long");
			}
		}
		
	}
	
	private static void printSquareArray(int[][] array) {
		
		for(int i = 0; i < array.length; i ++) {
			for(int j = 0; j < array.length; j ++) {
				System.out.print(array[i][j]);
			}
			System.out.println("");
		}
	}
}
