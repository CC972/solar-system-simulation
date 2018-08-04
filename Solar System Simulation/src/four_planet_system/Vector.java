package four_planet_system;

//Vector (x, y, z) class 
public class Vector {

	// member variables
	private double x = 0;
	private double y = 0;
	private double z = 0;

	// Constructors
	public Vector() {}
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	double magnitude() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	Vector unitVector() {
		double magnitude = this.magnitude();
		return new Vector(this.x/magnitude, this.y/magnitude, this.z/magnitude);
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ", " + this.z + ")";
	}

	//////////////////////// Static versions of methods //////////////////////////
	
	static double scalarProduct(Vector v1, Vector v2) {
		return (v1.x * v2.x) + (v1.y * v2.y) + (v1.z * v2.z);
	}

	static Vector vectorProduct(Vector v1, Vector v2) {
		return new Vector(v1.y * v2.z - v1.z * v2.y,
						  v1.z * v2.x - v1.x * v2.z, 
						  v1.x * v2.y - v1.y * v2.x);
	}

	static Vector add(Vector v1, Vector v2) {
		return new Vector(v1.x + v2.x,
						  v1.y + v2.y,
				          v1.z + v2.z);
	}
	
	static Vector subtract(Vector v1, Vector v2) {
		return new Vector(v1.x - v2.x,
						  v1.y - v2.y,
				          v1.z - v2.z);
	}

	static double angle(Vector v1, Vector v2) { // radians
		double dotProduct = Vector.scalarProduct(v1, v2);
		return Math.acos(dotProduct / (v1.magnitude() * v2.magnitude()));
	}

	//////////////////////// Non-static versions of methods //////////////////////////

	double scalarProduct(Vector v) {
		return scalarProduct(this, v);
	}

	Vector vectorProduct(Vector v) {
		return vectorProduct(this, v);
	}

	Vector add(Vector v) {
		return add(this, v);
	}
	
	Vector subtract(Vector v) {
		return subtract(this, v);
	}

	double angle(Vector v) {
		return angle(this, v);
	}
	
	//////////////////////// Getter and setter methods //////////////////////////
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	
}