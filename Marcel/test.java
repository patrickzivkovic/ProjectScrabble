
public class test {
	public static void main(String[] args) {

		Camera cam = new Camera();
		Point3D[] cloud = new Point3D[1];
		cloud[0] = new Point3D(0.5, 0.4, 0.3);
		
		Scene scene = new Scene(cloud);
		
		cam.setScene(scene);
		cam.setImageSize(10, 10);
		cam.setView(-1, -1, 2, 2);
		
		Image img = cam.capture();
		
		System.out.println(img.toString()); // Res 0.5
		System.out.println(cam.get_resolution_horizontal());
		System.out.println(cam.get_resolution_vertical());
//		
		
//		Image img = new Image(3, 3);
//		// i horizontal, (links nach rechts)
//		// j vertikal (oben nach unten)
//		
//		for(int i = 0; i < 3; i ++) {
//			for (int j = 0; j < 3; j++) {
////				System.out.println(i + j);
//				img.setPixel(i, j, 'X');
//			}
//		}
//		
//		img.setPixel(0, 0, '0');
//		
//		img.setPixel(0, 1, '1');
//		
//		img.setPixel(0, 2, '2');
//		
//		String res = img.toString();
//		
//		// scene:
//		Point3D[] cloud = new Point3D[5];
//		for(int i = 0; i < cloud.length; i++) {
//			cloud[i] = new Point3D();
//		}
//
//
//		cloud[0].setX(0);
//		cloud[0].setY(0);
//		cloud[0].setZ(0);
//	
//		cloud[1].setX(3.5);
//		cloud[1].setY(3.5);
//		cloud[1].setZ(3.5);
//	
//		cloud[2].setX(7.5);
//		cloud[2].setY(7.5);
//		cloud[2].setZ(7.5);
//	
//		cloud[3].setX(9);
//		cloud[3].setY(9);
//		cloud[3].setZ(9);
//	
//		cloud[4].setX(4);
//		cloud[4].setY(4);
//		cloud[4].setZ(4);
//	
//		
//		Scene scene = new Scene(cloud);
//		
//		// Bild ist 3*3 pixel
//		Camera cam = new Camera();
//		cam.setScene(scene);
//		cam.setImageSize(3, 3);
//		cam.setView(0, 0, 6, 9);
//		
//		// Setze view auf 9*9 => dann sollte auflösung jeweils 3 sein
//		
//		
//		System.out.println("Res hori: " + cam.get_resolution_horizontal());
//		System.out.println("Res verti: " + cam.get_resolution_vertical());
//		
//		System.out.print(res);
//		
//		System.out.println(cam.get_projection_img_pixel_to_view_x(0));
//		System.out.println(cam.get_projection_img_pixel_to_view_y(1));
		
	}
}
