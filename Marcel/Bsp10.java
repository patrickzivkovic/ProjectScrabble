
public class Bsp10 {
	public static void main(String[] args) {
		

		String[] dictionary ={"sand","queasy","dust", "sandy", "dusty","easy", "yield"};
		char[] letters = {'a','d','e', 'i', 'l', 'n', 'q', 's', 't', 'u', 'y'};
		int[] points = {1,2,1,1,1,1,10,1,1,1,4};
		int[] nrTiles = {2,3,2,2,2,2,1,2,2,2,2};
		SimpleScrabble game = new SimpleScrabble(dictionary, 8, letters, points, nrTiles);
		game.setMultiplier(5,4,3);

		int p1 = game.placeTilesDisjoint(2,4,0,"easy"); // p1 has value 15 (=1+1+1+4*3)
		int p2 = game.placeTilesDisjoint(1,0,1,"sand"); // tiles are not placed (p2=-1) because 'd' of "sand" would be adjacent to 'y' of "easy"
		
		System.out.println("Pouints for sand: " + p2);
		
		p2 = game.placeTilesDisjoint(0,0,1,"sand"); // successful placement, p2 = 5 (1+1+1+2)
		int p3 = game.placeTilesDisjoint(3,0,0,"dust"); // unsuccessful because there are no more 's' tiles available, p3=-1
		game.printBoard();                               // console output is:

//
//
//		game.clear();   //board is erased
//		game.setMultiplier(5,4,3);
		
		game.printBlocked();
//		
	}

	

	
}
