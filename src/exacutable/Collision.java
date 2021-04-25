package exacutable;

/**
 * Filename: Collision.java
 * @author dawsonheykoop
 * 
 * Purpose: An instantiation of this represents the relationship between two objects, and more particularly
 * their relative coordinates. It makes checking for a collision easier, so checking
 * multiple times is unnecessary.
 *
 */
public class Collision {
	
	// The coordinates of the character
	private double x1;
	private double y1;
	private double first_height;
	private double first_width;
	
	// The coordinates of the still object - obstacle or floor
	private double x2;
	private double y2;
	private double second_height;
	private double second_width;
	
	public Collision(double x1, double y1, double first_height, double first_width,
			double x2, double y2, double second_height, double second_width) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.first_height = first_height;
		this.first_width = first_width;
		this.second_height = second_height;
		this.second_width = second_width;
		
	}
	
	public double getX1() {
		return x1;
	}
	
	public double getX2() {
		return x2;
	}
	
	public double getY1() {
		return y1;
	}
	
	public double getY2() {
		return y2;
	}
	
	/**
	 * Determines if there is a collision between the two objects' coordinates.
	 * @return
	 */
	public boolean isCollision() {
		 if ((x1) < (x2 + second_width) && (x1 + first_width) > x2
				 && (y1) < (y2+second_height) && (y1 + first_height) > y2) {
			 return true;
		 }
		
		 return false;
	}

	public double getHeight1() {
		return first_height;
	}
	
	public double getHeight2() {
		return second_height;
	}
	
	

}
