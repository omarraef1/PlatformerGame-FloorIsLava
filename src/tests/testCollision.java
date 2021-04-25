package tests;
import exacutable.*;
import javafx.application.Application;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCollision {

	@Test
	public void testIsCollision() {
		Application.launch(dummyApp.class);
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(125,180,90,1);
		Rectangle rect = new Rectangle(125,180,125,20); 
		controller.addFloor(rect);
		assertTrue(controller.isCollision());
		controller.getP1().setX(-1);
		assertTrue(controller.isCollision());
		controller.getP1().setX(1300);
		assertTrue(controller.isCollision());
		controller.getP1().setX(10);
		rect = new Rectangle(400,180,125,20);
		Circle circ = new Circle(0,0,0);
		controller.addFloor(circ);
		controller.addFloor(rect);
		rect = new Rectangle(200, 260,10,10);
		controller.addFloor(rect);
		assertFalse(controller.isCollision());
		
	}
	
	@Test
	public void testBringToFloor() {
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(10,250,90,1);
		controller.bringToFloor();
		assertTrue(controller.getP1().getY() == controller.getPlatformFloor());
		controller.getP1().setY(controller.getPlatformFloor() -1);
		controller.bringToFloor();
		assertFalse(controller.getP1().getY() == controller.getPlatformFloor());
		Rectangle rect = new Rectangle(125,180,200,20); 
		controller.addObstacle(rect);
		controller.getP1().setX(126);
		controller.getP1().setY(180);
		controller.bringToFloor();
		
	}
	
	@Test
	public void testAboveLava() {
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(126,180,90,1);
		Rectangle rect = new Rectangle(125,180,200,20); 
		Circle circ = new Circle(0,0,0);
		controller.addObstacle(circ);
		controller.addObstacle(rect);
		assertTrue(controller.aboveLava());
		controller.getP1().setX(500);
		assertFalse(controller.aboveLava());
		controller.getP1().setX(10);
		assertFalse(controller.aboveLava());
	}
	
	@Test
	public void testLand() {
		int player_height = 49;
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(126,180,90,1);
		Rectangle rect = new Rectangle(125,180,50,50); 
		Shape s = new Circle();
		controller.addFloor(s);
		controller.addFloor(rect);
		controller.land();
		assertTrue(controller.getP1().getY() == (rect.getY() - player_height));
		controller.getP1().setX(500);
		controller.getP1().setY(300);
		controller.land();
		assertFalse(controller.getP1().getY() == (rect.getY() - player_height));	
		controller.getP1().setX(126);
		controller.getP1().setY(200);
		controller.land();
		
	}
	
	@Test
	public void testOnFloor() {
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(126,200,90,1);
		Rectangle rect = new Rectangle(125,180,50,50); 
		controller.addFloor(rect);
		Shape s = new Circle();
		controller.addFloor(s);
		assertTrue(controller.onFloor());
	}
	
	@Test
	public void testOnFloor2() {
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(10,10,90,1);
		Rectangle rect = new Rectangle(125,180,50,50); 
		controller.addFloor(rect);
		Shape s = new Circle();
		controller.addFloor(s);
		assertFalse(controller.onFloor());
	}
	
	@Test
	public void testNoMovement() {
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(126,200,90,1);
		assertTrue(controller.noMovement());
		controller.getP1().setMovingRight(true);
		controller.getP1().setMovingLeft(false);
		assertFalse(controller.noMovement());
		controller.getP1().setMovingLeft(true);
		assertFalse(controller.noMovement());
		controller.getP1().setMovingLeft(true);
		controller.getP1().setMovingRight(false);
		assertFalse(controller.noMovement());
	}
	
	@Test
	public void testCheckForDeath() {
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(126,200,90,1);
		Rectangle rect = new Rectangle(125,180,50,50); 
		Shape s = new Circle();
		controller.addObstacle(s);
		controller.addObstacle(rect);
		controller.checkForDeath();
		assertTrue(controller.isGameOver());
		
	}
	
	@Test
	public void testCheckForNotDeath() {
		PuzzlePlatController controller = new PuzzlePlatController();
		PuzzlePlatModel model = new PuzzlePlatModel();
		controller.createPlayerOne(500,200,90,1);
		Rectangle rect = new Rectangle(125,180,50,50); 
		Shape s = new Circle();
		controller.addObstacle(s);
		controller.addObstacle(rect);
		controller.checkForDeath();
		assertFalse(controller.isGameOver());
		controller.getP1().setX(1400);
		assertTrue(controller.isGameOver());
	}
	
	

}
