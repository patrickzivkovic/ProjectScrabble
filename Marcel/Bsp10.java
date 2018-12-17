//Patrick Zivkovic, 01422129

public class Bsp10 {
	public static void main(String[] args) {
		

//		String[] dictionary ={"orange", "door", "computer", "construction", "winter", "hotel", "box", "nut", "tunnel"};
//		char[] letters = {'d', 'n', 'h', 'b', 'u', 'k', 'l', 'x', 'p', 't', 'c', 'q', 'i', 'z', 'f', 'm', 's', 'a', 'w', 'y', 'o', 'j', 'e', 'g', 'r', 'v'};
//		int[] points = {6, 10, 8, 8, 1, 1, 3, 6, 1, 3, 2, 6, 4, 7, 9, 4, 1, 10, 2, 5, 1, 4, 8, 1, 7, 5};
//		int[] nrTiles = {1, 2, 3, 3, 1, 3, 1, 2, 2, 2, 1, 2, 3, 1, 2, 1, 2, 1, 1, 2, 1, 3, 1, 1, 1, 3};
//		SimpleScrabble game = new SimpleScrabble(dictionary, 15, letters, points, nrTiles);
//		game.setMultiplier(3,6,1);
//
//		int p1 = game.placeTilesDisjoint(3,6,0,"nut");
//      System.out.println(p1); 
//		
//		game.printBoard();                              
//
//		game.printBlocked();
//      for(int el:game.getlTtilesCopy())
//        System.out.print(el + " ");
//      System.out.println();  
//		game.clear(); 
//      for(int el:game.getlTtilesCopy())
//        System.out.print(el + " ");  //board is erased
      
		
		String[] dictionary ={"sand","queasy","dust", "sandy", "dusty","easy", "yield"};
		char[] letters = {'a','d','e', 'i', 'l', 'n', 'q', 's', 't', 'u', 'y'};
		int[] points = {1,2,1,1,1,1,10,1,1,1,4};
		int[] nrTiles = {2,3,2,2,2,2,1,2,2,2,2};
		SimpleScrabble game = new SimpleScrabble(dictionary, 8, letters, points, nrTiles);
		game.setMultiplier(5,4,3);

//		int p1 = game.placeTilesDisjoint(2,4,0,"easy"); // p1 has value 15 (=1+1+1+4*3)
//		int p2 = game.placeTilesDisjoint(5,0,1,"sand"); // tiles are not placed (p2=-1) because 'd' of "sand" would be adjacent to 'y' of "easy"
//		 p2 = game.placeTilesDisjoint(0,0,1,"sand"); // successful placement, p2 = 5 (1+1+1+2)
//		int p3 = game.placeTilesDisjoint(3,0,0,"dust"); // unsuccessful because there are no more 's' tiles available, p3=-1
// 	
//		game.printBoard();                              // console output is:
//	
		game.clear();   //board is erased
		game.setMultiplier(5,4,3);
		
		int p1 = game.placeTilesDisjoint(2,4,0,"easy"); // first word is placed, same as above
//		System.out.println(p2);
		int p2 = game.placeTiles(5,0,1,"sandy");        // uses 'y' from "easy" and p2= 17 (1+1+1+2+4*3)
//		System.out.println(p2);
		
		int p3 = game.placeTiles(1,7,0,"dust"); // unsuccessful because it connects to no word on the board, p3 = -1
//		System.out.println(p3);
//		game.printBoard();
		p3 = game.placeTiles(3,0,0,"dusty");        // ok because it uses 's' from "sand", p3=9
//		System.out.println(p3);

		game.printBoard();
		System.out.println("QUEASY");
		int p4 = game.placeTiles(0,4,0,"qu");   // extends "easy" to "queasy", p4=26 (10+1+1+1+1+4*3)
		System.out.println(p4);
//		game.printBoard();
//		int p5 = game.placeTiles(7,0,1,"yield");        // adds new word "yield" uses 'y' from "dusty", p5=9
		game.printBoard();      // console output is:
	}

	

	
}
