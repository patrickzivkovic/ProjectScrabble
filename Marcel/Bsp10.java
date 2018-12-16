//Patrick Zivkovic, 01422129

public class Bsp10 {
	public static void main(String[] args) {
		

//		String[] dictionary ={"sand","queasy","dust", "sandy", "dusty","easy", "yield"};
//		char[] letters = {'a','d','e', 'i', 'l', 'n', 'q', 's', 't', 'u', 'y'};
//		int[] points = {1,2,1,1,1,1,10,1,1,1,4};
//		int[] nrTiles = {2,3,2,2,2,2,1,2,2,2,2};
//		SimpleScrabble game = new SimpleScrabble(dictionary, 8, letters, points, nrTiles);
//		game.setMultiplier(5,4,3);
//
//		int p1 = game.placeTilesDisjoint(2,4,0,"easy"); // p1 has value 15 (=1+1+1+4*3)
//		int p2 = game.placeTilesDisjoint(5,0,1,"sand"); // tiles are not placed (p2=-1) because 'd' of "sand" would be adjacent to 'y' of "easy"
//		 p2 = game.placeTilesDisjoint(0,0,1,"sand"); // successful placement, p2 = 5 (1+1+1+2)
//		int p3 = game.placeTilesDisjoint(3,0,0,"dust"); // unsuccessful because there are no more 's' tiles available, p3=-1
//		game.printBoard();                              // console output is:
////		s.......
////		a.......
////		n.......
////		d.......
////		..easy..
////		........
////		........
////		........
//
//		game.printBlocked();
//		game.clear();   //board is erased
//		game.setMultiplier(5,4,3);
//		
//		game.printBlocked();
//      
//      Cell c = new Cell(1);
//      c.setLetter('z',1);
//      System.out.println(c.getLetter());
//      System.out.println(c.isEmpty());
////
		
		
		String[] dictionary = {"junction", "biscuits", "phone", "waiter", "tunnel"};
		char[] letters = {'i', 'q', 'a', 'p', 'f', 'y', 'k', 'b', 'h', 'n', 'e', 's', 
				'm', 'o', 'z', 'g', 'u', 'w', 'v', 'j', 'r', 'c', 'l', 'x'};
		int[] points = {7, 4, 4, 4, 6, 7, 6, 7, 1, 3, 9, 9, 8, 7, 2, 10, 6, 2, 9, 4, 10, 4, 2, 6};
		int[] nrTiles = {1, 2, 2, 1, 3, 2, 3, 3, 1, 2, 3, 1, 2, 3, 2, 3, 1, 3, 1, 1, 2, 2, 3, 3};
		
		SimpleScrabble game = new SimpleScrabble(dictionary, 9, letters, points, nrTiles);

		game.clear();
		game.setMultiplier(0, 2, 8);
		System.out.println(game.placeTilesDisjoint(0, 2, 0, "junction "));
		
//		game.clear();
		
		game.printBoard();
		game.printBlocked();
		


//				Place tiles disjoint (x: 2, y: 2, direction: 1, letters: heating)
	}

	

	
}
