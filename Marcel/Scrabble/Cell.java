//Patrick Zivkovic, 01422129

public class Cell{
	
	private char letter;
	private int multiplier;
	private boolean empty;
	private int points;
	private boolean blocked;
	
	
	/** Constructor: empty cell with multiplier
	* @param multiplier 
	*/
	Cell(int multiplier){
		this.letter = '9'; // '9' marks an empty cell
		this.empty = true;
		this.multiplier = multiplier;
		this.points = 0;
	}
	
	public void setMultiplier(int mult) {
		this.multiplier = mult; 
	}

	/** Gets the contents of the cell 
	* @return the letter in the cell, or '.' if the cell is empty
	*/
	public char getLetter() {
		if(!isEmpty()) {
			return this.letter;
		}else return '.';
	}

	public void reset() {
		this.empty = true;
		this.blocked = false;
		this.multiplier = 1;
		this.letter = '9';
		this.points = 0;
	}
	/** Gets the value of the cell 
	* @return cell value equals the letter points multiplied by cell multiplier
	* @return zero if cell empty 
	*/
	public int getValue() {
		if(isEmpty()) return 0;
		else return this.points * this.multiplier;
	}

	/** Checks for emptiness
	* @return true if cell empty, false otherwise
	*/
	public boolean isEmpty() {
		return this.empty;
	}
	
	public boolean isBlocked() {
		return this.blocked;
	}
	
	public void block() {
		this.blocked = true;
	}

	/** Sets the contents of the cell 
	* @param letter         the letter
	* @param points         the number of points for the letter
	* @return       true if success, false otherwise 
	*/
	public boolean setLetter(char letter, int points) {
      
   	this.letter = letter;
   	this.points = points;
   	this.empty = false;
   	this.blocked = true;
   		
      return true;   
	}

}