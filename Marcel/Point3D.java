class Point3D{
	
	private double x, y, z;
	
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point3D() {
		
	}

	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;		
	}
	public void setZ(double z) {
		this.z = z;
	}
	

	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getZ() {
		return this.z;
	}
}