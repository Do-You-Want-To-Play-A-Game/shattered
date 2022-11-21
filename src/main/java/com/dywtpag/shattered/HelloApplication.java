package com.dywtpag.shattered;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application
{

	@Override
	public void start(Stage stage) throws IOException
	{
		
		Image icon = new Image(HelloApplication.class.getResource("testIcon.jpeg").toString());
		HelloController helloController = new HelloController();
		
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
		Scene scene = new Scene(fxmlLoader.load(),1000,1000);
		stage.getIcons().add(icon);
//		helloController.movementAnimation();
		stage.setTitle("Shattered!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch();
	}
}