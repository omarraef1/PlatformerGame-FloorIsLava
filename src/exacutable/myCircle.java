package exacutable;

/**
 * this class does everything circle does but adds a field to hold movement speed.
 */
import javafx.scene.shape.Circle;

public class myCircle extends Circle{
	private int moveSpeed; //number of Y spaces skipped per clock tick
	
	public myCircle(double centerX, double centerY, double radius, int moveSpeed) {
		super(centerX, centerY, radius);
		this.moveSpeed = moveSpeed;
	}
	
	/**
	 * getter for movement speed
	 * @return the number of Y spaces skipped per clock tick
	 */
	public int getMoveSpeed() {
		return moveSpeed;
	}

}
