// Patrick Zivkovic, 01422129

public class Cell {
  
  private char letter;
  private int multiplier;
  private int points;
  
  Cell(int multiplier) {
    this.letter = '0';
    this.multiplier = multiplier;
    
    //System.out.println(letter);
  }
  
  public char getLetter(){
  
    if(letter == '0')
      return '.';
    else
      return letter;  
  
  }
  
  public void setMulitplier(int mult) {
  
    this.multiplier = mult;
  
  }
  
  public int getValue(){
  
    if(!isEmpty())
      return this.points * this.multiplier;
    else
      return 0;  
  
  }
  
  public boolean isEmpty() {
  
    if(letter == '0')
      return true;
    else
      return false;  
  
  }
  
  public boolean setLetter(char letter, int points) {
  
    if(isEmpty()){
      this.letter = letter;
      this.points = points;
      return true;
    }  
    else
      return false;  
  
  }
  
  
}

