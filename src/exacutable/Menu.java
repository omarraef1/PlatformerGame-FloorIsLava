package exacutable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import javafx.application.Application;
	import javafx.application.Platform;
	import javafx.beans.value.ChangeListener;
	import javafx.beans.value.ObservableValue;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
	import javafx.scene.Scene;
	import javafx.scene.control.Alert;
	import javafx.scene.control.Alert.AlertType;
	import javafx.scene.control.Button;
	import javafx.scene.control.ButtonBar.ButtonData;
	import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.DialogPane;
	import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.RadioButton;
	import javafx.scene.control.TextField;
	import javafx.scene.control.Toggle;
	import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.TilePane;
	import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
	import javafx.stage.Stage;

	
public class Menu extends Application {
		
		private String player;
		private String level;
		private Stage dummyStage;
		private static boolean enter;
	

		public void start(Stage primaryStage) throws Exception {
			/**
			 * Creates the GUI interface for the menu window which
			 * allows the user to select a level, start the game, or a load a game.
			 * 
			 * @param primaryStage is a Stage Object that the dialog uses
			 */
			Stage dialog = new Stage();
			enter = false;
			dialog.setTitle("Start Menu");
		
			TilePane pane = new TilePane(); 
			
			pane.setStyle("-fx-background-color: #021B19;");
		     
	    	VBox vbox = new VBox();
			  
		    ToggleGroup toggle = new ToggleGroup(); 
		  
		        
		    Label label = new Label("Choose Players: ");
		    label.setTextFill(Color.BEIGE);
		        
		    RadioButton p1Button = new RadioButton("One Player"); 
		    p1Button.setSelected(true);
		    p1Button.setTextFill(Color.LIGHTPINK);
		   
		    
		    
		    Image image6 = new Image(getClass().getResourceAsStream("/imgs/User-512.png"));
		    p1Button.setGraphic(new ImageView(image6));
		    
		    
		    Image image7 = new Image(getClass().getResourceAsStream("/imgs/people.png"));
		    
		        
		    label.setPadding(new Insets(8,8,8,8));
		    p1Button.setPadding(new Insets(8,8,8,8));
		   
		    p1Button.setToggleGroup(toggle); 
		    
		    HBox group1 = new HBox();
		    group1.setPadding(new Insets(8,8,8,8));
		    group1.getChildren().add(label);
		    group1.getChildren().add(p1Button); 
		        
		    
		    ToggleGroup toggle2 = new ToggleGroup(); 
		  	 
		    Label label2 = new Label("Level: ");
		    label2.setTextFill(Color.LIGHTBLUE);
		    RadioButton tutorialButton = new RadioButton("Tutorial"); 
		    tutorialButton.setTextFill(Color.LIGHTGREEN);
		    
		    Image image3 = new Image(getClass().getResourceAsStream("/imgs/Mod_Add-On_1-35-512.png"));
		    tutorialButton.setGraphic(new ImageView(image3));
		    
		    tutorialButton.setSelected(true);
		    RadioButton l1Button = new RadioButton("Level 1");
		    l1Button.setTextFill(Color.ORANGE);
		    
		    Image image4 = new Image(getClass().getResourceAsStream("/imgs/twoStars.png"));
		    l1Button.setGraphic(new ImageView(image4));
		    
		    RadioButton l2Button = new RadioButton("Level 2"); 
		    l2Button.setTextFill(Color.DARKRED);
		    
		    Image image5 = new Image(getClass().getResourceAsStream("/imgs/threeStars.png"));
		    l2Button.setGraphic(new ImageView(image5));
			  
		  
		    label2.setPadding(new Insets(8,8,8,8));
		    tutorialButton.setPadding(new Insets(8,8,8,8));
		    l1Button.setPadding(new Insets(8,8,8,8));
		    l2Button.setPadding(new Insets(8,8,8,8));
		        
		        
		    tutorialButton.setToggleGroup(toggle2); 
		    l1Button.setToggleGroup(toggle2); 
		    l2Button.setToggleGroup(toggle2);
		        
		    HBox group2 = new HBox();
		    group2.setPadding(new Insets(8,8,8,8));
		    group2.getChildren().add(label2);
		    group2.getChildren().add(tutorialButton); 
		    group2.getChildren().add(l1Button); 
		    group2.getChildren().add(l2Button); 
		       
		   
		    HBox group3 = new HBox();
		    group3.setPadding(new Insets(8,8,8,8));
		        
		        
		    Button game = new Button("Play Game");
		    game.setStyle("-fx-background-color: #021917; -fx-font-size: 20px;");
		    game.setTextFill(Color.CORNFLOWERBLUE);
		    Button loadGame = new Button("Load Game");
		    loadGame.setStyle("-fx-background-color: #021917; -fx-font-size: 20px;");
		    loadGame.setTextFill(Color.PURPLE);
		    Button cancel = new Button("Exit");
		    cancel.setStyle("-fx-background-color: #021917; -fx-font-size: 20px;");
		    cancel.setTextFill(Color.BROWN);
		    
		    Image image1 = new Image(getClass().getResourceAsStream("/imgs/Games-512.png"));
		    game.setGraphic(new ImageView(image1));
		    
		    Image loadImage = new Image(getClass().getResourceAsStream("/imgs/loadImg.png"));
		    loadGame.setGraphic(new ImageView(loadImage));
		    
		    
		    Image image2 = new Image(getClass().getResourceAsStream("/imgs/010_x-3-512.png"));
		    cancel.setGraphic(new ImageView(image2));
		    
		    cancel.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					dialog.close();
				}
		    	
		    });
		    
		    loadGame.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					ArrayList<String[]> gamesInfo = new ArrayList<>();
					
					try {
						BufferedReader reader = new BufferedReader(new FileReader("src/SavedGames.txt"));
						String lineTokens[] = null;
						String line = null;
						while((line = reader.readLine()) != null) {
							lineTokens = line.split(" ");
							gamesInfo.add(lineTokens);
						//	System.out.println(lineTokens);
						}
						reader.close();
//						for(int i = 0; i < gamesInfo.size(); i++) {
//							System.out.println(gamesInfo.get(i)[0]);
//						}
						
						ArrayList<String> choices = new ArrayList<>();
						for(int i = 0; i < gamesInfo.size(); i++) {
							choices.add(gamesInfo.get(i)[0]);
							
						}
						ChoiceDialog<String> loadDialog = new ChoiceDialog<>("-Choices-", choices);
						loadDialog.setTitle("Choice Dialog");
						loadDialog.setHeaderText("Saved Games Results");
						loadDialog.setContentText("Choose Your Game");
						
						Optional<String> result = loadDialog.showAndWait();
						if(result.isPresent()) {
							System.out.println(result.get().toString());
							
							for(int i = 0 ; i < gamesInfo.size(); i++) {
								if(gamesInfo.get(i)[0].equals(result.get().toString())) {
									
									PuzzlePlatView newGame = new PuzzlePlatView();
									if(gamesInfo.get(i)[1].toString().equals("level")) {
										newGame.setLevel(gamesInfo.get(i)[1].toString() + " " + gamesInfo.get(i)[2].toString());
										newGame.setxPosLoaded(Double.valueOf(gamesInfo.get(i)[3]));
										newGame.setyPosLoaded(Double.valueOf(gamesInfo.get(i)[4]));
							        	newGame.setHealthLoaded(Integer.valueOf(gamesInfo.get(i)[5]));
							        	newGame.setLivesLoaded(Integer.valueOf(gamesInfo.get(i)[6]));
									}
									else {
										newGame.setLevel(gamesInfo.get(i)[1].toString());
										newGame.setxPosLoaded(Double.valueOf(gamesInfo.get(i)[2]));
										newGame.setyPosLoaded(Double.valueOf(gamesInfo.get(i)[3]));
							        	newGame.setHealthLoaded(Integer.valueOf(gamesInfo.get(i)[4]));
							        	newGame.setLivesLoaded(Integer.valueOf(gamesInfo.get(i)[5]));
									}
						        	
						        	
						        	try {
										newGame.start(new Stage());
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
									break;
								}
							}
				        	dialog.close();
						}
						dialog.close();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
		    	
		    });
		    
		    game.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					level = ((RadioButton)toggle2.getSelectedToggle()).getText();
		        	player = ((RadioButton)toggle.getSelectedToggle()).getText();
		        	PuzzlePlatView newGame = new PuzzlePlatView();
		        	newGame.setLevel(level);
		        	
		        	Stage start = new Stage();
		        	try {
		        		newGame.setStage(start);
						newGame.start(start);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        	
		        	//dialog.close();

				}
		    	
		    });
		 
		    HBox group = new HBox();
		    group.setSpacing(15);
		    group.setPadding(new Insets(8,8,8,8));
		       
		    group.getChildren().addAll(game, loadGame, cancel);

		    vbox.getChildren().add(group1);
		    vbox.getChildren().add(group2);
		    vbox.getChildren().add(group3);
		    vbox.getChildren().add(group);
		    group.setAlignment(Pos.CENTER);
		    group1.setAlignment(Pos.CENTER);
		    group2.setAlignment(Pos.CENTER);
		    group3.setAlignment(Pos.CENTER);
		    
		    pane.getChildren().add(vbox);
		  
			Scene scene = new Scene(pane, 600, 200);
			
			dialog.setScene(scene);

			dialog.initOwner(primaryStage);
			dialog.initModality(Modality.APPLICATION_MODAL); 
			dialog.showAndWait();
			
		}
		
		public String getLevelNum() {
			/**
			 * get the level the user selected from the menu
			 * 
			 * @return String that is the name of the level
			 */
			return this.level;
		}
		
		
		public String getPlayerNum() {
			/**
			 * get the number of players in a game : currently can only be one
			 * 
			 * @return String for the number of players
			 */
			return this.player;
		}
		
		public static boolean getSubmitted() {
			/**
			 * get the value for if the user has submitted a response
			 * 
			 * @return boolean 
			 */
			return enter;
		}
		
		public static void main(String args[]) {
			Application.launch(Menu.class);
		}

}
