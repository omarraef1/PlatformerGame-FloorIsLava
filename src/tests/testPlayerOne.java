package tests;
import exacutable.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class testPlayerOne {

	@Test
	public void testLocation() {
		PlayerOne p = new PlayerOne(2,2);
		p.setX(1);
		p.setY(1);
		p.incrementX();
		p.decrementX();
		assertTrue(p.getX() == 1);
		assertTrue(p.getY() == 1);
	}
	
	@Test
	public void testMoveFalse() {
		PlayerOne p = new PlayerOne(1,1);
		assertFalse(p.movingDown());
		assertFalse(p.movingUp());
		assertFalse(p.movingLeft());
		assertFalse(p.movingRight());
	}
	
	@Test
	public void testMoveTrue() {
		PlayerOne p = new PlayerOne(1,1);
		p.setMovingDown(true);
		p.setMovingRight(true);
		p.setMovingLeft(true);
		p.setMovingUp(true);
		assertTrue(p.movingDown());
		assertTrue(p.movingUp());
		assertTrue(p.movingLeft());
		assertTrue(p.movingRight());
	}
	
	@Test
	public void testCanMoveTrue() {
		PlayerOne p = new PlayerOne(1,1);
		p.setCanJump(true);
		p.setCanJumpAgain(true);
		p.setCanMoveLeft(true);
		p.setCanMoveRight(true);
		p.setCancelJump(true);
		assertTrue(p.isCanJump());
		assertTrue(p.isCancelJump());
		assertTrue(p.isCanJumpAgain());
		assertTrue(p.isCanMoveLeft());
		assertTrue(p.isCanMoveRight());
	}
	
	
	@Test
	public void testGetImages() {
		PlayerOne p = new PlayerOne(1,1);
		p.getPpL1();
		p.getPpL2();
		p.getPpL3();
		p.getPpL4();
		p.getPpL5();
		p.getPpR1();
		p.getPpR2();
		p.getPlayerImg();
		p.getPpR3();
		p.getPpR4();
		p.getPpR5();
		p.setPpR1(null);
		p.SetPlayerImg(null);
		p.setPlayerImgNumber(1);
		p.getRightGroup();
	}
	
	@Test
	public void testLava() {
		PlayerOne p = new PlayerOne(1,1);
		p.setInLava(true);
		assertTrue(p.inLava());
	}
	
	@Test
	public void testVelocity() {
		PlayerOne p = new PlayerOne(1,1);
		p.setVelX(1);
		p.setVelY(1);
		assertTrue(p.getVelX() == 1);
		assertTrue(p.getVelY() == 1);
	}
	
	@Test
	public void testMovement() {
		PlayerOne p = new PlayerOne(1,1);
		p.getLastMove();
		p.getWeight();
		p.getSpeed();
		p.getHealth();
		p.getLives();
		p.lostHealth();
		p.lostLife();
		p.setJumpStrength(1);
		assertTrue(p.getJumpStrength() == 1);
	}
	

}
