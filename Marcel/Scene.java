public class Scene{
	
	private Point3D[] cloud;
	
	public Scene(Point3D[] cloud) {
		this.cloud = cloud;
	}
	
	public Point3D getPoint(int i) {
		return this.cloud[i];
	}
	
	public int getSize() {
		return this.cloud.length;
	}
}