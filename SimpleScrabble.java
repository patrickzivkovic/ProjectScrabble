// Patrick Zivkovic, 01422129

public class SimpleScrabble {

   private String[] dictionary;
   private int size;
   private char[] letters;
   private int[] lPoints;
   private int[] lTiles;
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
   
     this.dictionary = dictionary;
     this.size = size;
     this.letters = letters;
     this.lPoints = lPoints;
     this.lTiles = lTiles;
     
     board = new Cell[size][size];
     for (int zeile = 0; zeile < size; zeile++)
       for (int spalte = 0; spalte < size; spalte++)
         board[zeile][spalte] = new Cell(1);
         free[zeile][spalte] = true;

   
   }
   
   /** Sets the multiplier of a board cell only if the cell is empty, otherwise no change is made
   * @param x                      horizontal coordinate (starts at zero)
   * @param y                      vertical coordinate (starts at zero)
   * @param mul                    cell multiplier                         
   */
   public void setMultiplier(int x, int y, int mul){
   
     if(board[x][y].isEmpty())
       this.board[x][y].setMultiplier(mul);
   
   }
   
   // Clears the board, resets game to initial state       
   public void clear(){
   
     for (int zeile = 0; zeile < size; zeile++)
       for (int spalte = 0; spalte < size; spalte++)
         board[zeile][spalte] = new Cell(1);
         free[zeile][spalte] = true;
   
   }
   
   /** Places tiles on board to form a new word, separated from existing words
   * @param x                      horizontal coordinate for starting cell 
   * @param y                      vertical coordinate for starting cell
   * @param direction              direction to place tiles: 0=left->right, 1=top->down
   * @param letters                every letter tile is placed in order from the starting position along the provided direction
   * @return                       the number of points for the word, or -1 if tiles could not be placed                   
   */
   public int placeTilesDisjoint(int x, int y, int direction, String letters) {
   
     //check if in dictionary
     boolean inDictionary = false;
     for(int i = 0; i < dictionary.length; i++) {
       if(letters.equals(dictionary[i])
         inDictionary = true;  
     }
     
     if(!inDictionary)
       return -1;
     
     //ein Array mit selber Dimension wie verfuegbare Buchstaben, das jetzt die Anzahl der Buchstaben in String letters repraesentiert
     int[] nrLettersNeeded = new int[this.letters.length];  
     //every letter in the string letters is tested against the available letters  
     int index = -1;
     for(char c: letters.toCharArray()){
       for(int i = 0; i < this.letters.length; i++) {
         if(this.letters[i] == c)
           index = i;  
       }
       //if the letter is found then count up
       if(index != -1)
         nrLettersNeeded[i]++;
     }
     
     //check if every letter is avaiable enough times to set the word
     boolean everyletteravaiable = true;
     for (int i = 0; i < nrLettersNeeded; i++){
       if (lTiles[i] < nrLettesNeeded[i]) {
         everyletteravaiable = false;
         break;
       }  
     }
     
     
     char[] charletters = letters.toCharArray();
     
     for (int zeile = 0; zeile < size; zeile++)
       for (int spalte = 0; spalte < size; spalte++)
         board[zeile][spalte] = new Cell(1);
         free[zeile][spalte] = true;
       board[x][y].setLetter(charletters[i], lPoints[index_of_character(charletters[i])])
     
     //catch x/y out of bound
     
     //catch too long word out of bound (size-x >= wordsize, dann valid)
     
     
     
     
     
         
       
   
   }
   
   public int index_of_character(char c) {
     for(int i = 0; i < this.letters.length; i++) 
       if(this.letters[i] == c)
         return i;
     return -1;    
   }
   
   // Prints the contents of the board, see format from example below
   public void printBoard()
   
}

