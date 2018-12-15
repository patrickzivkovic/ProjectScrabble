public class SimpleScrabble{
	
	private String [] dictionary;
	private int size;
	private char[] letters;
	private int [] lPoints;
	private int [] lTiles;
	private Cell [][] board;
	
	
	private boolean [][] free;
	
	/** Constructor: new SimpleScrabble game
	* @param dictionary             list of valid words 
	* @param size                   size of the board 
	* @param letters                list of valid letters 
	* @param lPoints                points of each letter
	* @param lTiles                 number of available tiles for each letter
	*/
	SimpleScrabble(String [] dictionary, int size, char[] letters, int[] lPoints, int[] lTiles){
		System.out.println("Creating SimpleScrabble");
		
		this.dictionary = dictionary;
		this.size = size;
		this.letters = letters;
		this.lPoints = lPoints;
		this.lTiles = lTiles;
		
		
		// Creating multidimensional array of class Cell
		this.board = new Cell [size][size]; // Cells are not instantiated yet
		
		//Instantiate:
//		for(int zeile = 0; zeile < size; zeile++) {
//			for(int spalte = 0; spalte < size; spalte++) {
//				this.board[zeile][spalte] = new Cell(1);
//			}
//		}
		clear();
	}

	/** Sets the multiplier of a board cell only if the cell is empty, otherwise no change is made
	* @param x                      horizontal coordinate (starts at zero)
	* @param y                      vertical coordinate (starts at zero)
	* @param mul                    cell multiplier                         
	*/
	public void setMultiplier(int x, int y, int mul) {
		if(this.board[x][y].isEmpty()) {
			this.board[x][y].setMultiplier(mul);
		}
	}
//
//	// Clears the board, resets game to initial state       
	public void clear() {
		for(int zeile = 0; zeile < size; zeile++) {
			for(int spalte = 0; spalte < size; spalte++) {
				this.board[zeile][spalte] = new Cell(1);
				this.free[zeile][spalte] = true;
			}
		}
	}
//
//	/** Places tiles on board to form a new word, separated from existing words
//	* @param x                      horizontal coordinate for starting cell 
//	* @param y                      vertical coordinate for starting cell
//	* @param direction              direction to place tiles: 0=left->right, 1=top->down
//	* @param letters                every letter tile is placed in order from the starting position along the provided direction
//	* @return                       the number of points for the word, or -1 if tiles could not be placed                   
//	*/
	public int placeTilesDisjoint(int x, int y, int direction, String letters) {
		//Check if letters is in dictionary:
//		if(letters not in dictionary) return -1
		if(!condition1(letters)) return -1;
//		if(not enough letters) retuern -1
		if(!condition2(letters)) return -1;
//		if(atleast one field blocked  return -1)
		
		
//		char [] charletters = letters.toCharArray();
		
		//von links nach rechts setzen:
		
		for(int i = 0; i < letters.length(); i ++) {
			
			char einf = letters.charAt(i);
			int points = this.lPoints[index_of_character(einf)];
						
			board[x+i][y].setLetter(einf, points);

		}

		//von oben nach unten
		
		for(int i = 0; i < letters.length(); i ++) {
			
			char einf = letters.charAt(i);
			int points = this.lPoints[index_of_character(einf)];
						
			board[x][y+i].setLetter(einf, points);

		}

		
		
		// Catch x, y, out of bound

		// Catch direction invalid values
		
		// Catch word too long (size-x >= wordsize, dann valid)
		
	}
	
	private int index_of_character(char c) {

		/*
		 * Function that checks in which position of letters, the character c occurs
		 * returns that index
		 * 
		 * if character c not in letters, returns -1
		 * */
		
		for(int i = 0; i < this.letters.length; i ++) {
			if(this.letters[i] == c) return i;
		}
		return -1;
	}
	
	private int[] nrLettersNeeded (String letters) {

		/*
		 * 
		 * 
		 * Idea: letters array: {'a', 'd', 'm'}
		 * nrTiles array:      {2  ,  4 ,   2}
		 * nrLettersNeeded     {0  ,    ,   0}
		 * 
		 * Now when we want to build the word "mama", we loop over every character in "mama"
		 * and check the position of the character in the letters array and save the position of the current character
		 * at the same position in nrLettersNeeded we increment
		 * 
		 * 
		 * */
		
		
		
		
		//Create empty integer array of same size as all our available letters in the game
		int [] nrLettersNeeded  = new int[this.letters.length];
		// loop over every character of letters (parameter of this function)
		for(char c: letters.toCharArray()) {
//			System.out.println("Current Character: " + c);
			//create index and set to -1 (if we dont find the current character of the word we want to build in our dictionary
			// this will stay -1 and we wont get a nullpointer exception later on
			int index = index_of_character(c);
			if(index != -1 ) {
				nrLettersNeeded[index]++;
			}	
		}
		
		return nrLettersNeeded;
	}

	private boolean condition2(String letters) {
		int [] nrLettersNeeded = nrLettersNeeded(letters);
		
		for(int i = 0; i < nrLettersNeeded.length; i ++) {
			if(nrLettersNeeded[i] > this.lTiles[i]) return false;
		}
		return true;
	}
	
	private boolean condition1(String letters) {
		for(String dictionary_element: this.dictionary) {
			if(dictionary_element.equals(letters)) return true;
		}
		return false;
	}
//
//	// Prints the contents of the board, see format from example below
//	public void printBoard()
}