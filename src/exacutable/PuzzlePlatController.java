package exacutable;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Optional;
import java.util.Random;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import java.awt.event.KeyListener;

public class PuzzlePlatController {
	
	private PuzzlePlatModel model = new PuzzlePlatModel();
	private AnimationTimer at;
	private boolean gameOver = false;
	
	/**
	 * make all the floors for level one
	 */
	public void makeStageOneFloors() {
		model.setPlatformFloorY(201); //base floor for testing character movement

	    
	    Image image1 = new Image(getClass().getResourceAsStream("../imgs/flatGround.png"));

	    Image image2 = new Image(getClass().getResourceAsStream("../imgs/longerGround.png"));
	    

	    Image image3 = new Image(getClass().getResourceAsStream("../imgs/shorterGround.png"));
	    Image image4 = new Image(getClass().getResourceAsStream("../imgs/shortestGround.png"));
	    Image image5 = new Image(getClass().getResourceAsStream("../imgs/stone.png"));
		 
	
		Rectangle rect = new Rectangle(0,250,300,50);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(400,250,100,50);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(600,250,400,50);
		rect.setFill(new ImagePattern(image2));
		model.addFloor(rect);
		
		rect = new Rectangle(1100,250,100,50);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(125,180,125,20); 
		rect.setFill(new ImagePattern(image5));
		model.addFloor(rect);
		
		//rect = new Rectangle(375,150,50,20);
		//rect.setFill(Color.DARKOLIVEGREEN);
		//model.addFloor(rect);
		
		rect = new Rectangle(400,70,100,20);
		rect.setFill(new ImagePattern(image5));
		model.addFloor(rect);
		
		rect = new Rectangle(600,70,100,20);
		rect.setFill(new ImagePattern(image5));
		model.addFloor(rect);
		
		rect = new Rectangle(750,70,100,20);
		rect.setFill(new ImagePattern(image5));
		model.addFloor(rect);
		
		rect = new Rectangle(900,70,100,20);
		rect.setFill(new ImagePattern(image5));
		model.addFloor(rect);
		
	}
	
	public void makeStageOneObstacles() {
		Image image1 = new Image(getClass().getResourceAsStream("../imgs/lava-png-clipart.png"));
		Rectangle rect = new Rectangle(300, 275, 100, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(500, 275, 100, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(1000, 275, 100, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
	}
	
	/**
	 * make all the floors for level two
	 */
	public void makeStageTwoFloors() {
		
		Image image1 = new Image(getClass().getResourceAsStream("../imgs/redbrick.png"));

		Image image2 = new Image(getClass().getResourceAsStream("../imgs/groupBricks.png"));
		

		Image image3 = new Image(getClass().getResourceAsStream("../imgs/bricks.png"));
		

		Image image4 = new Image(getClass().getResourceAsStream("../imgs/log.png"));
		

		Image image5 = new Image(getClass().getResourceAsStream("../imgs/platform.png"));
		

		Image image6 = new Image(getClass().getResourceAsStream("../imgs/groundPink.png"));
		

		Image image7 = new Image(getClass().getResourceAsStream("../imgs/groundPink5.png"));
		
		Image image8 = new Image(getClass().getResourceAsStream("../imgs/groundPinkMore.png"));
		
		
		model.setPlatformFloorY(201); //base floor for testing character movement
		
		Rectangle rect = new Rectangle(0,250,125,50);
		rect.setFill(new ImagePattern(image6));
		model.addFloor(rect);
		
		rect = new Rectangle(200,250,50,50);
		rect.setFill(new ImagePattern(image7));
		model.addFloor(rect);
		
		rect = new Rectangle(325,250,50,50);
		rect.setFill(new ImagePattern(image7));
		model.addFloor(rect);
		
		rect = new Rectangle(500,250,200,50);
		rect.setFill(new ImagePattern(image8));
		model.addFloor(rect);
		
		rect = new Rectangle(900,250,25,50);
		rect.setFill(new ImagePattern(image4));
		model.addFloor(rect);
		
		rect = new Rectangle(1000,250,200,50);
		rect.setFill(new ImagePattern(image8));
		model.addFloor(rect);
		
		rect = new Rectangle(100,50,30,25);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(170,50,80,25);
		rect.setFill(new ImagePattern(image2));
		model.addFloor(rect);
		
		rect = new Rectangle(275,50,25,25);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(325,50,50,25);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(500,100,200,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(800,100,100,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(1000,100,50,25);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
	}
	
	/**
	 * make obstacles for stage2
	 */
	public void makeStageTwoObstacles() {
		Image image1 = new Image(getClass().getResourceAsStream("../imgs/lava-png-clipart.png"));
		
		Rectangle rect = new Rectangle(125, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(250, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(375, 275, 125, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(700, 275, 200, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(925, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
	}
	/**
	 * make buttons for stage2
	 */
	public void makeStageTwoButtons() {

		Image image5 = new Image(getClass().getResourceAsStream("../imgs/button.png"));
		
		Rectangle rect = new Rectangle(600,240,20,10);
		rect.setFill(new ImagePattern(image5));
		model.addButton(rect);
	}
	
	/**
	 * make all the floors for level three
	 */
	public void makeStageThreeFloors() {
		model.setPlatformFloorY(201); //base floor for testing character movement
		
		Image image1 = new Image(getClass().getResourceAsStream("../imgs/stoneThing.png"));
		

		Image image2 = new Image(getClass().getResourceAsStream("../imgs/groundChunks.png"));
		

		Image image3 = new Image(getClass().getResourceAsStream("../imgs/elevatedBox.png"));
		
		Rectangle rect = new Rectangle(0,250,125,50);
		rect.setFill(new ImagePattern(image2));
		model.addFloor(rect);
		
		rect = new Rectangle(200,250,25,50);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(300,240,25,60);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(400,250,25,50);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(500,240,25,60);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(600,250,25,50);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(700,240,25,60);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(800,240,25,60);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(900,250,25,50);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(1000,240,25,60);
		rect.setFill(new ImagePattern(image1));
		model.addFloor(rect);
		
		rect = new Rectangle(1100,250,100,50);
		rect.setFill(new ImagePattern(image2));
		model.addFloor(rect);
		
		rect = new Rectangle(200,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(300,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(400,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(500,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(600,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(700,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(800,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(900,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
		rect = new Rectangle(1000,50,25,25);
		rect.setFill(new ImagePattern(image3));
		model.addFloor(rect);
		
	}
	
	public void makeStageThreeObstacles() {
		Rectangle rect = new Rectangle(125, 275, 75, 25);
		
		Image image1 = new Image(getClass().getResourceAsStream("../imgs/lava-png-clipart.png"));
		
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(225, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(325, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(425, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(525, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(625, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(725, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(825, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(925, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
		rect = new Rectangle(1025, 275, 75, 25);
		rect.setFill(new ImagePattern(image1));
		model.addObstacle(rect);
		
	}
	
	/**
	 * checks if a button has been clicked
	 * @return a boolean representing if the button has been clicked
	 */
	public boolean checkButtonClick() {
		for(PlayerOne x: model.getCharacters()) {
			for(Shape button: model.getButtons()) {
				//System.out.println(x.getY() + " " + ((Rectangle) button).getY());
				if(button instanceof Rectangle) {
					if(x.getX() >= (((Rectangle) button).getX()) - 30 
							&& x.getX()<= (((Rectangle) button).getX())){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * make all the rain
	 * @param min minimum number of rain drops
	 * @param max maximum number of rain drops
	 */
	public void makeRain(int min, int max) {
		myCircle circ;
		int numCircles = randomNum(min, max);
		
		for(int i = 0; i < numCircles; i++) {
			circ = new myCircle(randomNum(100, 1100), 0, 5, randomNum(1,2));
			circ.setFill(Color.DARKGREEN);
			model.addObstacle(circ);
		}
	}
	
	/**
	 * get a random number between min and max (inclusive)
	 * @param min minimum number
	 * @param max maximum number
	 * @return a random number between min and max
	 */
	public int randomNum(int min, int max) {
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
	
	/**
	 * add observer to observable
	 * @param o observer
	 */
	public void addObserver(Observer o) {
		model.addObserver(o);
	}
	
	/**
	 * getter for list of floors
	 * @return list of floors
	 */
	public ArrayList<Shape> getFloors() {
		return model.getFloors();
	}
	
	/**
	 * getter for list of obstacles
	 * @return list of obstacles
	 */
	public ArrayList<Shape> getObstacles() {
		return model.getObstacles();
	}
	
	/**
	 * getter for list of buttons
	 * @return list of buttons
	 */
	public ArrayList<Shape> getButtons() {
		return model.getButtons();
	}
	
	/**
	* Begins the game by setting up a timer that calls tick() 60 times per second.
	*/
	public void start() {
		int ticksPerFrame = 1;
		at = new AnimationTimer() {
		@Override
		public void handle(long now) {
			// perform ticksPerFrame ticks
			// by default this is 1
				for (int i = 0; i < ticksPerFrame; i++) {
					tick();
				}
			}
		};
		at.start();
	}
	
	/**
	* tick() performs one iteration of the game, and notifies observers to draw a
	* frame. This should be called 60 times per second by default.
	*/
	public void tick() {
		ArrayList<ArrayList<? extends Object>> state = new ArrayList<ArrayList<? extends Object>>();//state of the character, obstacles, and floor
		
		// If there's a collision, we should check what direction it was going last so
		// we can go a different direction.
		if (getP1().isCancelJump() && getP1().getLastMove().equals(KeyCode.UP)) {
			cancelJump();
		}
		land();
		if((getP1().getX() <= 0) || (getP1().getX() + getP1().getPlayerImg().getWidth()) >= 1250) {
			cancelJump();
		}
		if (isCollision()) {
			if (getP1().getLastMove().equals(KeyCode.RIGHT)) {
				if(model.getP().isCanMoveLeft()) { //&& !isCollision()) {
					movePlayer();
					moveRight();
				}
				if (model.getP().isCanJump()) {
					movePlayer();
					playerJump();
				}
			}
			else if (getP1().getLastMove().equals(KeyCode.LEFT)) {
				if(model.getP().isCanMoveRight()) { //&& !isCollision()) {
					movePlayer();
					moveRight();
				}
				if (model.getP().isCanJump()) {
					movePlayer();
					playerJump();
				}
			}
		}
		
		// If there aren't collisions, should be free to move anywhere
		else {
			movePlayer();
			if(model.getP().isCanMoveRight()) { //&& !isCollision()) {
				moveRight();
			}
			if(model.getP().isCanMoveLeft()) {
				moveLeft();
			}
			if(model.getP().isCanJump()) {
				playerJump();
			}
		}

		moveRain();
		checkForDeath();
		
		// Calling the onFloor() method has an issue since the sprite's height alternates between the moves
		// and the image is larger than the actual character.
		if (!onFloor() && !getP1().isCanJump()) {//!getP1().getLastMove().equals(KeyCode.UP)) {
			// The negative jump strength makes the second half of the jump start (falling)
			getP1().setJumpStrength(-11);
			bringToFloor();
		}
		state.add(model.getFloors());
		state.add(model.getObstacles());
		
		state.add(model.getCharacters());
		state.add(model.getButtons());
		
		model.update();
		model.notifyObservers(state);
	}
	
	/**
	 * updates player's position by velocity
	 */
	public void movePlayer() {
		model.getP().setX(model.getP().getX() + model.getP().getVelX());
		model.getP().setY(model.getP().getY() + model.getP().getVelY());
	}

	/**
	 * update location of the rain
	 */
	public void moveRain() {
		myCircle newCirc;
		ArrayList<Shape> newRain = new ArrayList<>();
		
		for(Shape shape: model.getObstacles()) {
			if(shape instanceof myCircle 
					&& ((Circle) shape).getCenterY() + ((Circle) shape).getRadius()< 275
					&& !endRain(shape)) {//limits amount of rain in game
				newCirc = new myCircle(((myCircle) shape).getCenterX(), 
						((myCircle) shape).getCenterY() + ((myCircle) shape).getMoveSpeed(), 
						((myCircle) shape).getRadius(), ((myCircle) shape).getMoveSpeed());
				newCirc.setFill(((myCircle) shape).getFill());
				newRain.add(newCirc);
			}else if(shape instanceof Rectangle) {//if its not rain then ignore
				newRain.add(shape);
			}
		}
		
		model.setAllObstacles(newRain);
		
	}
	
	/**
	 * checks if rain has hit a floor or if it hits a player
	 * @param shape rain
	 * @return boolean representing if rain is touching a floor
	 */
	public boolean endRain(Shape shape) {
		if(shape instanceof myCircle) {
			for(Shape floor: model.getFloors()) {
				if(floor instanceof Rectangle) {
					if(((myCircle) shape).getCenterY() == ((Rectangle) floor).getY()
							&& ((myCircle) shape).getCenterX() >= ((Rectangle) floor).getX() 
							&& ((myCircle) shape).getCenterX() <= ((Rectangle) floor).getX() 
							+ ((Rectangle) floor).getWidth()) {
						return true;
					}
				}
			}
			Collision rainCol = new Collision(model.getCharacters().get(0).getX(), //check if player is hit
					model.getCharacters().get(0).getY(),49, 
					model.getCharacters().get(0).getPlayerImg().getWidth(),
					((myCircle) shape).getCenterX() - .5,
					((myCircle) shape).getCenterY() - .5, 1, 1);
			if(rainCol.isCollision()) {
				model.getCharacters().get(0).lostHealth();
				//System.out.println(model.getCharacters().get(0).getHealth());
				if(model.getCharacters().get(0).getHealth() == 0) {
					gameOver = true;
				}
				return true;
			}
		
		}
		return false;
		
	}
	
	
	public boolean isNameVacant(String name){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/SavedGames.txt"));
			ArrayList<String[]> gamesInfo = new ArrayList<>();
			
			String lineTokens[] = null;
			String line = null;
			try {
				while((line = reader.readLine()) != null) {
					lineTokens = line.split(" ");
					gamesInfo.add(lineTokens);
				}
				reader.close();
				for(int i = 0; i < gamesInfo.size(); i++) {
					if(gamesInfo.get(i)[0].equals(name)) {
						return false;
					}
				}
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		return true;
	}
	
	
	/**
	 * Creates Player One and adds them to character Array
	 */
	public void createPlayerOne(double x, double y, int health, int lives) {
		PlayerOne p1 = new PlayerOne(x, y);
		p1.setLives(lives);
		p1.setHealth(health);
		model.setP(p1);
		model.characters.add(model.getP());
	}
	
	/**
	 * 
	 * @return player one
	 */
	public PlayerOne getP1() {
		return model.getP();
	}
	
	/**
	 * called every tick(), replaces rendered image
	 * with sprite frame every 5 ticks
	 * for right movements
	 */
	public void moveRight() {
		if(getP1().getPlayerImgNumber()<5) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpR1());
			getP1().setPlayerImgNumber(getP1().getPlayerImgNumber() + 1);
		}
		else if(getP1().getPlayerImgNumber()>=5 && getP1().getPlayerImgNumber()<10) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpR2());
			getP1().setPlayerImgNumber(getP1().getPlayerImgNumber() + 1);
		}
		else if(getP1().getPlayerImgNumber()>=10 && getP1().getPlayerImgNumber()<15) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpR3());
			getP1().setPlayerImgNumber(getP1().getPlayerImgNumber() + 1);
		}
		else if(getP1().getPlayerImgNumber()>=15 && getP1().getPlayerImgNumber()<20) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpR4());
			getP1().setPlayerImgNumber(getP1().getPlayerImgNumber() + 1);
		}
		else if(getP1().getPlayerImgNumber()>=20 && getP1().getPlayerImgNumber()<25) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpR5());
			getP1().setPlayerImgNumber(0);
		}
	}
	
	/**
	 * Determines if there is a collision between the player and obstacles. The floor is ignored
	 * here.
	 * @return whether or not there is a collision between player and an obstacle
	 */
	public boolean isCollision() {
		PlayerOne player = model.getCharacters().get(0);
		double player_width = player.getPlayerImg().getWidth();
		double player_height = 49;
		double player_x = player.getX();
		double player_y = player.getY();
		if((player_x < 0) || (player_x + player_width) > 1250) {
			return true;
		}
		ArrayList<Shape> obstacles = model.getFloors();
		for (Shape s: obstacles) {
			 if (s instanceof Rectangle) {
				 double height = ((Rectangle)s).getHeight();
				 double width = ((Rectangle)s).getWidth();
				 double x = ((Rectangle)s).getX();
				 double y = ((Rectangle)s).getY();
				 if (y < 250) {		 
					 Collision new_collision = new Collision(player_x,player_y,player_height, player_width, x,y,height,width);
					 if (new_collision.isCollision()) {
						 getP1().setCancelJump(true);
						 return true;
					 }
				 }	 
			 }
		}
		return false;
	}
	
	
	/**
	 * When the character is standing in the crack above the lava, we need to bring him down
	 * towards the lava.
	 * 
	 */
	public void bringToFloor() {
		PlayerOne player = getP1();
	
		getP1().setY(player.getY()-player.getJumpStrength());
		
		getP1().setJumpStrength(player.getJumpStrength() - player.getWeight());
		
		if(player.getY() >= this.model.getPlatformFloorY() && !aboveLava()) {
			player.setY(this.model.getPlatformFloorY());
			setCanJump(false);
			player.setJumpStrength(13);
		}
		
		
	}
	
	/**
	 * Determines if the character is above lava
	 * 
	 * @return a boolean that represents whether a player is above lava
	 */
	public boolean aboveLava() {
		double x = getP1().getX();
		double width = getP1().getPlayerImg().getWidth();
		for (Shape s: this.model.getObstacles()) {
			if (s instanceof Rectangle) {
				if (x > ((Rectangle)s).getX() && ((x+width) < (((Rectangle)s).getX()+  ((Rectangle)s).getWidth()))) {
					return true;
				}
			}
		}
		
		return false;
	}
	/**
	 * Determines if there is a conflict with the player and the floor.
	 * 
	 * @return true if there is a floor conflict, false otherwise
	 */
	public boolean onFloor() {
		PlayerOne player = getP1();
		for (Shape floor: model.getFloors()) {
			if (floor instanceof Rectangle) {
				Collision new_col = new Collision(player.getX(), player.getY(), 
						player.getPlayerImg().getHeight(),player.getPlayerImg().getWidth(),
						((Rectangle) floor).getX(),((Rectangle)floor).getY(),
						((Rectangle)floor).getHeight(),((Rectangle)floor).getWidth());
				if (new_col.isCollision()) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Tells if the character is still.
	 * @return boolean that tells us if the character is not moving
	 */
	public boolean noMovement() {
		return !getP1().movingRight() && !getP1().movingLeft();
	}
	
	
	/**
	 * Checks whether there is a collision between the character and a block of lava.
	 * This will then set variables to end the game.
	 */
	public void checkForDeath() {
		PlayerOne player = getP1();
		ArrayList<Shape> floors = getFloors();
		double player_width = player.getPlayerImg().getWidth();
		double player_height = player.getPlayerImg().getHeight();
		double player_x = player.getX();
		double player_y = player.getY();
		ArrayList<Shape> obstacles = getObstacles();
		for (Shape s: obstacles) {
			if (s instanceof Rectangle) {
				 double height = ((Rectangle)s).getHeight();
				 double width = ((Rectangle)s).getWidth();
				 double x = ((Rectangle)s).getX();
				 double y = ((Rectangle)s).getY();
				 Collision new_col = new Collision(player_x,player_y,player_height, player_width, x,y,height,width);
				 if (new_col.isCollision()) {
					 // Sets the player at a reasonable height, but causes a little jump when
					 // the game ends and the show window pops up
					 player.setY(y - 45);
					 player.setInLava(true);
					 gameOver = true;
				 }
			}
		}
	}
	
	
	/**
	 * Tells whether the game is over or not.
	 * @return boolean that is true if the game is over.
	 */
	public boolean isGameOver() {
		return gameOver || getP1().getX()+getP1().getPlayerImg().getWidth() > 1220;
	}
	
	/**
	 * called every tick(), replaces rendered image
	 * with sprite frame every 5 ticks
	 * for left movements
	 */
	public void moveLeft() {
		if(getP1().getPlayerImgNumber()<5) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpL1());
			getP1().setPlayerImgNumber(getP1().getPlayerImgNumber() + 1);
		}
		else if(getP1().getPlayerImgNumber()>=5 && getP1().getPlayerImgNumber()<10) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpL2());
			getP1().setPlayerImgNumber(getP1().getPlayerImgNumber() + 1);
		}
		else if(getP1().getPlayerImgNumber()>=10 && getP1().getPlayerImgNumber()<15) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpL3());
			getP1().setPlayerImgNumber(getP1().getPlayerImgNumber() + 1);
		}
		else if(getP1().getPlayerImgNumber()>=15 && getP1().getPlayerImgNumber()<20) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpL4());
			getP1().setPlayerImgNumber(getP1().getPlayerImgNumber() + 1);
		}
		else if(getP1().getPlayerImgNumber()>=20 && getP1().getPlayerImgNumber()<25) {
			model.characters.get(0).SetPlayerImg(model.getP().getPpL5());
			getP1().setPlayerImgNumber(0);
		}
	}

	/**
	 * sets flag on keyboard input
	 * @param canMove
	 */
	public void setCanMoveRight(boolean canMove) {
		this.model.getP().setCanMoveRight(canMove);
	}
	
	/**
	 * sets flag on keyboard input
	 * @param canMove
	 */
	public void setCanMoveLeft(boolean canMove) {
		this.model.getP().setCanMoveLeft(canMove);
	}
	
	
	/**
	 * called every tick() if jumpFlag is true.
	 * makes player jump
	 */
	public void playerJump() {
		getP1().setY(getP1().getY()-getP1().getJumpStrength());
		
		getP1().setJumpStrength(getP1().getJumpStrength() - getP1().getWeight());
				
		if(getP1().getY() >= this.model.getPlatformFloorY()) {
			// || collision with floor
			getP1().setY(this.model.getPlatformFloorY());
			setCanJump(false);
			getP1().setJumpStrength(13);
		}
	}
	
	/**
	 * Determines if there is a collision between the player and the floor
	 * @return A Collision object
	 */
	public Collision floorCollision() {
		PlayerOne player = getP1();
		ArrayList<Shape> floors = getFloors();
		double player_width = player.getPlayerImg().getWidth();
		// For some reason if you change this then the program crashes. I think its because 
		// there are several bits that are reliant on this part and it doesn't like it when 
		// the character is on the platform floor.
		double player_height = 49;
		double player_x = player.getX();
		double player_y = player.getY();
		Collision new_col;
		for (Shape s: floors) {
			if (s instanceof Rectangle) {
				 double height = ((Rectangle)s).getHeight();
				 double width = ((Rectangle)s).getWidth();
				 double x = ((Rectangle)s).getX();
				 double y = ((Rectangle)s).getY();
				 new_col = new Collision(player_x,player_y,player_height, player_width, x,y,height,width);
				 if (new_col.isCollision()) {
					 return new_col;
				 }
			}
		}
		return null;
	}

	
	/**
	 * Checks to see if the player should land on a floor. 
	 */
	public void land() {
		Collision new_col = floorCollision();
		if (new_col != null ) {
			if (new_col.getY1()+new_col.getHeight1() < new_col.getY2() + new_col.getHeight2()){
			
				getP1().setY(new_col.getY2() - new_col.getHeight1());
				
				// Not important but a NOTE: making setCanJump here lets you jump on top
				// like a trampoline
				setCanJump(false);
				
				setCancelJump(false);
				getP1().setCanJumpAgain(false);
				getP1().setJumpStrength(13);
				return;
			}
				
			
		}
	}
	
	/**
	 * Handles the collision that happens when the character's head hits the bottom of one of the obstacles
	 * 
	 */
	public void cancelJump() {
		if (!getP1().isCanJumpAgain()) {
			getP1().setJumpStrength(0);
		}
		
		getP1().setCanJumpAgain(true);
		
		getP1().setY(getP1().getY() - getP1().getJumpStrength());
		
		getP1().setJumpStrength(getP1().getJumpStrength() - getP1().getWeight());
		
		if(getP1().getY() >= this.model.getPlatformFloorY()) {
			getP1().setY(this.model.getPlatformFloorY());
			setCanJump(false);
			setCancelJump(false);
			getP1().setCanJumpAgain(false);
			getP1().setJumpStrength(13);
		}
		
	}
	
	/**
	 * Sets the cancelJump flag to b
	 * 
	 * @param b true if we need to cancel a jump
	 */
	public void setCancelJump(boolean b) {
		this.model.getP().setCancelJump(b);
	}
	
	
	/**
	 * sets character jump flag
	 * @param b
	 */
	public void setCanJump(boolean b) {
		this.model.getP().setCanJump(b);
	}
	/**
	 * returns the platform's base floor
	 * (for testing purposes)
	 * @return base floor
	 */
	public int getPlatformFloor() {
		return this.model.getPlatformFloorY();
	}


	/**
	 * Stops the animation from running. I did this because I couldn't produce the 
	 * show view without stopping the animation.
	 */
	public void stop() {
		at.stop();
		
	}
	
	/**
	 * add a new floor piece
	 * @param rect
	 */
	public void addFloor(Shape rect) {
		model.addFloor(rect);
	}
	
	/**
	 * add a new obstacle piece
	 * @param rect
	 */
	public void addObstacle(Shape rect) {
		model.addObstacle(rect);
	}

}
