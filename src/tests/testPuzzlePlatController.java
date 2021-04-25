package tests;
import exacutable.*;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import static org.junit.Assert.*;

import org.junit.Test;

public class testPuzzlePlatController {

	@Test
	public void testStage1FloorsAndObstacles() {
		PuzzlePlatController control = new PuzzlePlatController();
		control.makeStageOneFloors();
		control.makeRain(0, 1);
		control.makeStageOneObstacles();
		
		assertEquals(201,control.getPlatformFloor()); //floors
		
	}
	
	@Test
	public void testStage2FloorsAndObstacles() {
		PuzzlePlatController control = new PuzzlePlatController();
		control.makeStageTwoFloors();
		control.makeRain(0, 1);
		control.makeStageTwoObstacles();
		control.makeStageTwoButtons();
		
		assertTrue(control.getButtons().get(0) instanceof Shape);
		
		assertEquals(201,control.getPlatformFloor()); //floors
	
	}
	
	@Test
	public void testStage3FloorsAndObstacles() {
		PuzzlePlatController control = new PuzzlePlatController();
		control.makeStageThreeFloors();
		control.makeRain(0, 1);
		control.makeStageThreeObstacles();
		control.createPlayerOne(30.0, 200.0, 100, 3);
		control.start();
		assertEquals(201,control.getPlatformFloor()); //floors
		myCircle circ = new myCircle(control.randomNum(100, 1100), 0, 5, control.randomNum(1,2));
		control.getObstacles().add(circ);
		myCircle circ2 = new myCircle(control.randomNum(100, 1100), 0, 5, control.randomNum(1,2));
		control.getObstacles().add(circ2);
		myCircle circ3 = null;
		control.moveRain();
		control.endRain(circ3);
		control.endRain(circ2);
		control.endRain(circ);
	}
	
	@Test
	public void testRain() {
		PuzzlePlatController control = new PuzzlePlatController();
		control.makeStageThreeFloors();
		control.makeStageThreeObstacles();
		control.makeRain(0, 1);
		control.createPlayerOne(30.0, 200.0, 100, 3);
	}
	
	@Test
	public void testButtonClick() { //TODO Partial coverage (1/2 branches missed for checkButtonClick())
		PuzzlePlatController control = new PuzzlePlatController();
		control.start();
		control.makeStageTwoFloors();
		control.makeRain(0, 1);
		control.makeStageTwoObstacles();
		control.makeStageTwoButtons();
		
		control.createPlayerOne(550.0, 240.0, 100, 3);
		assertFalse(control.checkButtonClick());
		control.getP1().incrementX();
		control.getP1().incrementX();
		control.getP1().incrementX();
		control.getP1().incrementX();
		assertTrue(control.checkButtonClick());
		control.getP1().incrementX();
		control.getP1().incrementX();
		control.getP1().incrementX();
		control.getP1().incrementX();
		assertFalse(control.checkButtonClick());
		control.getP1().incrementX();
		control.getP1().incrementX();
		assertFalse(control.checkButtonClick());
		control.stop();
	
	}
	
	@Test
	public void testObserver() {
		PuzzlePlatController control = new PuzzlePlatController();

		PuzzlePlatView view = new PuzzlePlatView();
		control.addObserver(view);	
	}
	
	@Test
	public void testPlayerMovements() {
		PuzzlePlatController control = new PuzzlePlatController();
		control.makeStageOneFloors();
		control.makeStageOneObstacles();
		control.createPlayerOne(30.0, 200.0, 100, 3);
		control.getP1().incrementX();
		control.setCanMoveRight(true);
		control.movePlayer();
		control.moveLeft();
		control.moveRight();
		assertTrue(control.getP1().isCanMoveRight());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		assertEquals(16, control.getP1().getPlayerImgNumber());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.moveRight();
		assertFalse(control.isCollision());
		control.setCanMoveRight(false);
		assertFalse(control.getP1().isCanMoveRight());
		control.setCanMoveLeft(true);
		assertTrue(control.getP1().isCanMoveLeft());
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		control.moveLeft();
		assertEquals(1, control.getP1().getPlayerImgNumber());
		control.setCanJump(true);
		control.playerJump();
		control.setCancelJump(true);
		assertTrue(control.getP1().isCancelJump());
		control.cancelJump();
		assertTrue(control.getP1().isCanJump());
		assertTrue(control.getP1().isCanJumpAgain());
		control.setCancelJump(false);
		assertTrue(control.getP1().isCanJumpAgain());
		control.getP1().setCanJumpAgain(true);
		control.setCancelJump(true);
		control.cancelJump();
		assertFalse(control.isCollision());
		control.getP1().setX(-1);
		assertTrue(control.isCollision());
		control.getP1().setX(20.0);
		control.getP1().setY(200.0);
		control.setCanJump(true);
		control.playerJump();
		control.bringToFloor();
		assertFalse(control.isCollision());
		control.getP1().setY(control.getPlatformFloor()+30);
		control.getP1().setCanJumpAgain(true);
		control.cancelJump();
		
		PuzzlePlatController controller = new PuzzlePlatController();
		controller.createPlayerOne(125,180,90,1);
		Rectangle rect = new Rectangle(125,180,125,20); 
		controller.addFloor(rect);
		assertTrue(controller.isCollision());
	}
	
	@Test
	public void testNameVacancies() {
		PuzzlePlatController control = new PuzzlePlatController();
		assertFalse(control.isNameVacant("omar1"));
		assertTrue(control.isNameVacant("oooooooooopppp"));
	}

}
