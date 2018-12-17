//Patrick Zivkovic, 01422129

public class Bsp10 {
	public static void main(String[] args) {
		

		String[] dictionary ={"orange", "door", "computer", "construction", "winter", "hotel", "box", "nut", "tunnel"};
		char[] letters = {'d', 'n', 'h', 'b', 'u', 'k', 'l', 'x', 'p', 't', 'c', 'q', 'i', 'z', 'f', 'm', 's', 'a', 'w', 'y', 'o', 'j', 'e', 'g', 'r', 'v'};
		int[] points = {6, 10, 8, 8, 1, 1, 3, 6, 1, 3, 2, 6, 4, 7, 9, 4, 1, 10, 2, 5, 1, 4, 8, 1, 7, 5};
		int[] nrTiles = {1, 2, 3, 3, 1, 3, 1, 2, 2, 2, 1, 2, 3, 1, 2, 1, 2, 1, 1, 2, 1, 3, 1, 1, 1, 3};
		SimpleScrabble game = new SimpleScrabble(dictionary, 15, letters, points, nrTiles);
		game.setMultiplier(3,6,1);

		int p1 = game.placeTilesDisjoint(3,6,0,"nut");
      System.out.println(p1); 
		
		game.printBoard();                              

		game.printBlocked();
      for(int el:game.getlTtilesCopy())
        System.out.print(el + " ");
      System.out.println();  
		game.clear(); 
      for(int el:game.getlTtilesCopy())
        System.out.print(el + " ");  //board is erased
      
	}

	

	
}
