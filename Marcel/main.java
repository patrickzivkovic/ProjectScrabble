
public class main {
	public static void main(String[] args) {
		
		String[] dictionary ={"sand","queasy","dust", "sandy", "dusty","easy", "yield"};
		char[] letters = {'a','d','e', 'i', 'l', 'n', 'q', 's', 't', 'u', 'y'};
		int[] points = {1,2,1,1,1,1,10,1,1,1,4};
		int[] nrTiles = {2,3,2,2,2,2,1,2,2,2,2};
//		SimpleScrabble game = new SimpleScrabble(dictionary, 8, letters, points, nrTiles);

		int size = 5;
//		
//		for (int i = 0; i < size; i ++) {
//			System.out.println(i);
//		}

		char [] letters_deluxe = {'a', 'c', 'm'};
		int [] nrTiles_deluxe = {3, 4, 2};

		int [] nrLettersNeeded = new int[nrTiles_deluxe.length];
//		
//		for(int i = 0; i < nrLettersNeeded.length; i ++) {
//			nrLettersNeeded[i] = 0;
//		}
		

//		String word = "mamaccccc";
		

		int x = 5;
		String word = "abc";
		int w_size = 3;


		System.out.println(word.length());
		for(int i = 0; i < w_size; i ++) {
			System.out.println("X Position: " + (x+i));
		}

	}

	
	
}
