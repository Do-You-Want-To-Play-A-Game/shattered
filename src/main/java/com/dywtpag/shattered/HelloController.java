package com.dywtpag.shattered;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

public class HelloController
{
	public Button Uploader;
	public Button Gallery;
	public ImageView volume;
	Scene scene;
	Stage stage;
	@FXML
	private Pane anchor;
	@FXML
	public Rectangle rectangle;
	@FXML
	private Label welcomeText;

	boolean volumeOn = true;


	@FXML
	public void initialize(){
		//animation for buttons
		movementAnimation(Uploader);
		movementAnimation(Gallery);

		//grabs the background image
		Image image = new Image(HelloApplication.class.getResource("homeMountain.jpeg").toString());

		//allows the image to be scaled by the window size
		BackgroundImage bgImage = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0,1.0,true, true, false,false));

		//sets the background of the root pane to the background image
		anchor.setBackground(new Background(bgImage));
	}
	@FXML
	public static void movementAnimation(Node node){
		KeyValue start = new KeyValue(node.translateYProperty(), 10);
		KeyValue end = new KeyValue(node.translateYProperty(), -10);

		KeyFrame kf1 = new KeyFrame(Duration.seconds(3), start);
		KeyFrame kf2 = new KeyFrame(Duration.seconds(3), end);

		Timeline timeline1 = new Timeline(kf1, kf2);
		Timeline timeline2 = new Timeline(kf2, kf1);

		 SequentialTransition sequence = new SequentialTransition(timeline1, timeline2);
		 sequence.setCycleCount(Animation.INDEFINITE);
		 sequence.setAutoReverse(true);
		 sequence.play();
	}

	@FXML
	public  void fadeOut(){
		FadeTransition fadeTransition =new FadeTransition(new Duration(2000), anchor);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
	}

	@FXML
	protected void toUploader(ActionEvent event) throws IOException {

		fadeOut();
		Parent uploader = FXMLLoader.load(getClass().getResource("file-upload.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();

		// gets the width and height of the device the app is loaded on
		GraphicsDevice gd  = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth() - 700;
		int height = gd.getDisplayMode().getHeight() - 400;
		scene = new Scene(uploader,width,height);
		stage.setScene(scene);
		stage.show();
	}

	public void mute(){
		Image muted = new Image(HelloApplication.class.getResource("muted-volume.png").toString());
		Image Full = new Image(HelloApplication.class.getResource("volume-on.png").toString());

		if(volumeOn){
			volume.setImage(Full);
			volumeOn = false;
		} else if (!volumeOn) {
			volume.setImage(muted);
			volumeOn = true;
		}
	}

}