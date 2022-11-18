package com.dywtpag.shattered;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application
{

	@Override
	public void start(Stage stage) throws IOException
	{


		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
		stage.setTitle("Shattered!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch();
	}
}