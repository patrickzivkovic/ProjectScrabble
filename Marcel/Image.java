public class Image{
	
	private int width, height;
	private char[][] pixels;
	/** Constructs an empty image of the given width and height.
	*
	* @param width  the image width in pixels
	* @param height the image height in pixels
	*
	*/
	public Image(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new char[height][width];
		
		for(int i = 0; i < width; i ++) {
			for(int j = 0; j < height; j ++) {
				this.pixels[i][j] = ' ';
			}
		}
	}

	/** Returns the width of the image. 
	*
	* @return       the width in pixels
	*/
	public int getWidth() {
		return this.width;
	}
	                        
	/** Returns the height of the image. 
	*
	* @return       the height in pixels
	*/
	public int getHeight() {
		return this.height;
	}

	/** Returns the "color" of a pixel.
	*
	* @param i the horizontal location of the pixel, so in the array[][] it is the second index
	* @param j the vertical location of the pixel, so first index in array[][]
	*
	* @return               the "color", which is simply a character
	*
	*/
	
	
	public char getPixel(int i, int j) {
		return this.pixels[j][i];
	}


	/** Sets the "color" of a pixel.
	*
	* @param i      the horizontal location of the pixel
	* @param j the vertical location of the pixel
	* @param c      the "color"
	*
	*/
	public void setPixel(int i, int j, char c) {
		this.pixels[j][i] = c;
	}


	/** Returns the image in string representation. Each pixel of the image is represented
	* by the pixel "color".
	*
	* @return               the image as a string
	*
	*/
	public String toString() {
		String empty = "";
		
		for(int j = 0; j < this.height; j++) {
			for(int i = 0; i < this.width; i++) {
				empty += getPixel(i, j);
			}
			empty += "\n";
		}
		
		return empty;
	}
	
}