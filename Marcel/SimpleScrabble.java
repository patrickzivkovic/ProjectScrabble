//Patrick Zivkovic, 01422129

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
		for(int zeile = 0; zeile < size; zeile++) {
			for(int spalte = 0; spalte < size; spalte++) {
				this.board[zeile][spalte] = new Cell(1);
			}
		}

		
	}

	/** Sets the multiplier of a board cell only if the cell is empty, otherwise no change is made
	* @param x                      horizontal coordinate (starts at zero)
	* @param y                      vertical coordinate (starts at zero)
	* @param mul                    cell multiplier                         
	*/
	public void setMultiplier(int x, int y, int mul) {
		if(this.board[y][x].isEmpty()) {
			this.board[y][x].setMultiplier(mul);
		}
	}
//
//	// Clears the board, resets game to initial state       
	public void clear() {
		for(int zeile = 0; zeile < this.size; zeile++) {
			for(int spalte = 0; spalte < this.size; spalte++) {
				this.board[zeile][spalte] = new Cell(1);
//				this.free[zeile][spalte] = true;
			}
		}
	}
	
	public void printBlocked() {
		System.out.println("Blocked Fields");
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j ++) {
				if(this.board[i][j].isBlocked()) {
					if(this.board[i][j].isEmpty()) {
						System.out.print("X");
					}else {
						System.out.print(this.board[i][j].getLetter());
					}
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
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

		
		
		// Catch x, y, out of bound
		if(x < 0 || x >= this.size || y < 0 || y >= this.size) return -1;
		
		// Catch direction invalid values
		if(direction != 0 && direction != 1) return -1;
		
		// Catch word too long 
		if(direction == 0) {
			if(this.size - x < letters.length()) return -1;
		}else {
			if(this.size - y < letters.length()) return -1;
		}
	
		//Check if letters is in dictionary:
		if(!condition1(letters)) return -1;
		
		//Array with numbers how often we need each letter
		int [] nrLettersNeeded = nrLettersNeeded(letters);

		//Check if enough letters
		if(!condition2(letters, nrLettersNeeded)) return -1;

		//Check if none of the fields are blocked
		if(!condition3(letters, x, y, direction)) return -1;

		
		int points;
		//Set word
		//von links nach rechts setzen:
		if(direction == 0) {
			points = insert_left_to_right(letters, x, y);
			//das ist einfuegen und blocken
		}else {
			//von oben nach unten
			points = insert_top_to_bottom(letters, x, y);
			//das ist einfuegen und blocken
		}
		
		update_lTiles(nrLettersNeeded);
		return points;
	
	}
	private void update_lTiles(int [] nrLettersNeeded) {
		for(int i = 0; i < this.lTiles.length; i ++) {
			this.lTiles[i] -= nrLettersNeeded[i];
		}
		
	}
	private boolean condition3(String letters, int x, int y, int direction) {
		if(direction == 0) {
			// left to right
			// first index of board is row, second one is column
			// and we want to go from column to column
			// but user input x is the column
			// and user input y is the row
			// so we need to switch them => board[y][x]
			// And as we go from left to right, we want to traverse the second [] indices
			for(int i = 0; i < letters.length(); i ++) {
				if(this.board[y][x+i].isBlocked()) return false;
			}
			return true;
		}else {
			// top to bottom
			for(int i = 0; i < letters.length(); i ++) {
				if(this.board[y+i][x].isBlocked()) return false;
			}
			return true;
		}
	}
	private void block_cells_first(int x, int y, int direction) {
		// (x, y) position of character
		if(direction == 0) {

			// left to right
			// first index of board is row, second one is column
			// and we want to go from column to column
			// but user input x is the column
			// and user input y is the row
			// so we need to switch them => board[y][x]
			// And as we go from left to right, we want to traverse the second [] indices
			

			//Block cells left of the first letter
			
			//left straigt
			if(x - 1 >= 0) 
				this.board[y][x-1].block();	
			//left down
			if(x - 1 >= 0 && y + 1 <= this.size-1) 
				this.board[y+1][x-1].block();
			//left up
			if(x-1 >= 0 && y - 1 >= 0) 
				this.board[y-1][x-1].block();
			
			
			//Block the cells above and below the current letter
			
			//Below
			if(y+1 <= this.size - 1) 
				this.board[y+1][x].block();

			// Above
			if(y-1 >= 0) 
				this.board[y-1][x].block();
			
			
				
		}else {
	
			
			//Block cells above
			
			//Above straigt
			if(y-1 >= 0) this.board[y-1][x].block();
			
			//Above right
			if(y-1 >= 0 && x+1 <= this.size - 1) this.board[y-1][x+1].block();
			
			//Above left
			if(y-1 >= 0 && x - 1 >= 0) this.board[y-1][x-1].block();
	
			
			//Block cells left and right

			// left
			if(x-1 >= 0) this.board[y][x-1].block();
			// right
			if(x+1 <= this.size - 1) this.board[y][x+1].block();

		}
	}
	private void block_cells_middle(int x, int y, int direction) {
		if(direction == 0) {
			
			//first [] is row, second[] is column
			// We want to block the cells above and below board[y][x]
			// again because user inputs x as column and y as row
			
			//Block the cell below
			if(y + 1 <= this.size -1) 
				this.board[y+1][x].block();
			//Block the cell above
			if(y-1 >= 0) 
				this.board[y-1][x].block();
		}else {

			//Block left and right (y stays the same)
			
			//right
			if(x+1 <= this.size - 1) this.board[y][x+1].block();
			//left
			if(x-1 >= 0) this.board[y][x-1].block();
			
		}		
	}
	private void block_cells_last(int x, int y, int direction) {
		
		//first [] is row, second[] is column
		// We want to block the cells above and below board[y][x]
		// again because user inputs x as column and y as row
		
		if(direction == 0) {
			//top and bottom from current character
			
			//Above
			if(y-1 >= 0) 
				this.board[y-1][x].block();
			//below
			if(y+1 <= this.size - 1 )
				this.board[y+1][x].block();
			
			
			//Right straight, right diagonal up and right diagonal down

			//right straight
			if(x+1 <= this.size - 1) 
				this.board[y][x+1].block();
			//right above
			if(x+1 <= this.size - 1 && y - 1 >= 0)
				this.board[y-1][x+1].block();
			//right below
			if(x+1 <= this.size - 1 && y + 1 <= this.size - 1)
				this.board[y + 1][x+1].block();
		}else {
			
			//top down
			
			
			//left and right from current
			
			//right
			if(x+1 <= this.size - 1) 
				this.board[y][x+1].block();
			//left
			if(x - 1 >= 0) 
				this.board[y][x-1].block();
			
			
			// bottom left diag, bottom right diag and bottom straigt
			// bottom straigt
			if(y+1 <= this.size - 1) 
				this.board[y+1][x].block();
			// bottom right
			if(x+1 <= this.size - 1 && y + 1 <= this.size)
				this.board[y+1][x+1].block();
			// bottom left
			if(x - 1 >= 0 && y+1 <= this.size - 1) 
				this.board[y+1][x-1].block();
		}
	}
	private int insert_top_to_bottom(String letters, int x, int y) {
		int len = letters.length();
		int last = len - 1;
		
		int pointsword = 0;
		for(int i = 0; i < letters.length(); i ++) {
			
			char einf = letters.charAt(i);
			int points = this.lPoints[index_of_character(einf)];
						
			this.board[y+i][x].setLetter(einf, points);
			pointsword += this.board[y+i][x].getValue();
			
			if(i == 0) {
				//First Letter
				block_cells_first(x, y+i, 1);
				
			}else if (i == last) {
				//Last letter
				block_cells_last(x, y+i, 1);
			}else {
				// Middle letter
				block_cells_middle(x, y+i, 1);
			}

			
			

		}
		
		return pointsword;

	}
	private int insert_left_to_right(String letters, int x, int y) {
		int len = letters.length();
		int last = len - 1;
		int pointsword = 0;
		for(int i = 0; i < len ; i ++) {
			
			char einf = letters.charAt(i);
			int points = this.lPoints[index_of_character(einf)];
						
			this.board[y][x+i].setLetter(einf, points);
			pointsword += this.board[y][x+i].getValue();
			
			if(i == 0) {
				//First Letter
				block_cells_first(x+i, y, 0);
				
			}else if (i == last) {
				//Last letter
				block_cells_last(x+i, y, 0);
			}else {
				// Middle letter
				block_cells_middle(x+i, y, 0);
			}

		}

		
		return pointsword;
		
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
	private boolean condition2(String letters, int [] nrLettersNeeded) {
//		int [] nrLettersNeeded = nrLettersNeeded(letters);
		
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
	public int placeTiles(int x, int y, int direction, String letters) {
		return 0;
	}
//
//	// Prints the contents of the board, see format from example below
	public void printBoard() {
		for(int i = 0; i < this.size; i ++) {
			for(int j = 0; j < this.size; j ++) {
				System.out.print(this.board[i][j].getLetter());
			}
			System.out.println();
		}
	}
}