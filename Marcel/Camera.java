public class Camera{

	private Scene scene;
	private Image img;
	
	
	double view_x, view_y, view_width, view_height;
	
	public Camera() {};
	
/** Sets the scene.
	*
	* @param scene    a scene
	*
	*/
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	
	
	/** Sets the size of the image to be captured.
	*
	* @param width  the width of the image in pixels
	* @param height the height of the image in pixels
	*
	*/
	public void setImageSize(int width, int height) {
		this.img = new Image(width, height);
	}
	
	
	/** Sets the section of the scene to be captured.
	*
	* @param x  the upper left corner of the view in the image plane
	* @param y  the lower left corner of the view in the image plane
	* @param width  the width of the view in scene units
	* @param height the height of the view in scene units
	*
	*/
	public void setView(double x, double y, double width, double height) {
		this.view_x = x;
		this.view_y = y;
		this.view_width = width;
		this.view_height = height;
	}
	
	public double get_resolution_horizontal() {
		return this.view_width / this.img.getWidth();
//		return this.img.getWidth() / this.view_width ;
	}
	
	public double get_resolution_vertical() {
		return this.view_height / this.img.getHeight();

//		return this.img.getHeight() / this.view_height;
	}
	
	public double get_projection_img_pixel_to_view_x(int i) {
//" works" :return this.view_x + i * this.get_resolution_horizontal();
		return this.view_x + i * this.get_resolution_horizontal();
	}
	

	public double get_projection_img_pixel_to_view_y(int j) {
		// "works: 	return  this.view_y + j * this.get_resolution_vertical();
		return  this.view_y + j * this.get_resolution_vertical();
	}
	
	public boolean check_in_bound(double x_proj, double y_proj, int i, int j) {
		
		// Koordinaten des Pixels
		double x_proj_pixel_to_view = this.get_projection_img_pixel_to_view_x(i);
		double y_proj_pixel_to_view = this.get_projection_img_pixel_to_view_y(j);

		if (Math.abs(x_proj - x_proj_pixel_to_view) <= this.get_resolution_horizontal()) {
			if (Math.abs(y_proj - y_proj_pixel_to_view) <= this.get_resolution_vertical()) {
				// Bildpunktprojektion liegt in pixel bounds
				return true;
			}
		}
		
		return false;
		
	}
	
	/** Captures the image from the view of the scene. The direction of view
	* of the camera is always in negative z-direction, i.e., the image is captured
	* from "above". Each point of the view (scene) contributes to the image.
	*
	* @return  the image of the view
	*
	*/
	public Image capture() {
		
		// Project onto x,y
		// Ignore z
		int size_cloud = this.scene.getSize();
		
		double x;
		double y;
		
		double h;
		double v;
		
		for(int k = 0; k < size_cloud; k ++) {
			// Iterate over every 3D Point in the cloud of the scene
			
			// ignore z 

			x = this.scene.getPoint(k).getX();
			y = this.scene.getPoint(k).getY();
			
			// Check if Point2D is in view
			h = x;
			v = -y;
			
//			System.out.println("Projected points: (" + h + ", " + v + ")");
//			System.out.println("Breite x: " + (this.view_x + this.view_width));
			if(h >= this.view_x & h <= this.view_x + this.view_width) {
//				System.out.println("X valid");
//				System.out.println("Breite y: " + (this.view_y + this.view_height));
				if(v >= this.view_y & v <= this.view_y + this.view_height) {
					// Loop over every pixel in the image
					
//				/	System.out.println("Y valid");
					for(int i = 0; i < this.img.getWidth(); i ++) {
						for(int j = 0; j < this.img.getHeight(); j++) {
							if (check_in_bound(h, v, i, j)) {
								// Color pixel
//				/				System.out.println("in bound");
								img.setPixel(i, (this.img.getHeight() -1 - j) , '#');
							}
						}
					}
					
				}
			}
			
		}
		
		return this.img;
		
		
	}

	Image capture(int direction) {
		return null;
	}
}