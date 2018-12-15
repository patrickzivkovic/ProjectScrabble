public class Cell{
	
	private char letter;
	private int multiplier;
	private boolean empty;
	private int points;
	
	
	/** Constructor: empty cell with multiplier
	* @param multiplier 
	*/
	Cell(int multiplier){
		this.letter = '9';
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

	/** Sets the contents of the cell 
	* @param letter         the letter
	* @param points         the number of points for the letter
	* @return       true if success, false otherwise 
	*/
	public boolean setLetter(char letter, int points) {
		if(isEmpty()) {
			System.out.println("Setting Letter");
			this.letter = letter;
			this.points = points;
			this.empty = false;
			return true;
		}
		else return false;
	}
	
	public String toString() {
		String out = "";
		out += "Letter: " + getLetter() + "\n";
		out += "Value: " + getValue() + "\n";
		
		return out;
	}
}