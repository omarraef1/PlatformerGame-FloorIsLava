package tests;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class dummyApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Platform.exit();
		
	}

}
