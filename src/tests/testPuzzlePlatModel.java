package tests;
import exacutable.*;
import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class testPuzzlePlatModel {

	@Test
	public void AAAAtestCharacters() {
		Application.launch(dummyApp.class);
		PuzzlePlatModel model = new PuzzlePlatModel();
		PlayerOne p = new PlayerOne(1, 1);
		model.setP(p);
		assertTrue(model.getP() instanceof PlayerOne);
		assertTrue(model.getCharacters().get(0) instanceof PlayerOne );
	}
	
	@Test
	public void testImageNum() {
		PuzzlePlatModel model = new PuzzlePlatModel();
		PlayerOne p = new PlayerOne(1, 1);
		model.setP(p);
		model.setImgNumber(1);
		assertTrue(model.getImgNumber() == 1);
	}
	
	@Test
	public void testFloor() {
		PuzzlePlatModel model = new PuzzlePlatModel();
		model.addFloor(new Rectangle());
		assertTrue(model.getFloors().get(0) instanceof Shape);
	}
	
	@Test
	public void testObsticals() {
		PuzzlePlatModel model = new PuzzlePlatModel();
		model.addObstacle(new Rectangle());
		assertTrue(model.getObstacles().get(0) instanceof Shape);
		
		model.setAllObstacles(new ArrayList<Shape>());
	}
	
	@Test
	public void testButtons() {
		PuzzlePlatModel model = new PuzzlePlatModel();
		model.addButton(new Rectangle());
		assertTrue(model.getButtons().get(0) instanceof Shape);
	}
	
	@Test
	public void testUpdate() {
		PuzzlePlatModel model = new PuzzlePlatModel();
		model.update();
	}
	
	
	@Test
	public void testPlatform() {
		PuzzlePlatModel model = new PuzzlePlatModel();
		model.setPlatformFloorY(1);
		assertTrue(model.getPlatformFloorY() == 1);
	}

}
