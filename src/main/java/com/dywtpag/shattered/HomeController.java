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
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class HomeController
{
	@FXML
	public Button Uploader;

	@FXML Button gallery;
	Scene scene;
	Stage stage;
	@FXML
	private Pane anchor;
	@FXML
	public Rectangle rectangle;
	@FXML
	private Label welcomeText;

	@FXML
	public void Falling() {


		KeyValue start = new KeyValue(rectangle.translateYProperty(),200);
		KeyValue end = new KeyValue(rectangle.translateYProperty(), 700);
		KeyValue bounceStart = new KeyValue(rectangle.translateYProperty(), 300);
		KeyValue v4 = new KeyValue(rectangle.translateYProperty(), 400);

		KeyFrame frame = new KeyFrame(Duration.millis(1000), start, end);
		KeyFrame upFrame = new KeyFrame(Duration.millis(500), end, bounceStart);
		KeyFrame downFrame = new KeyFrame(Duration.millis(400),bounceStart, end);
		KeyFrame k4 = new KeyFrame(Duration.millis(300),v4);
		KeyFrame k5 = new KeyFrame(Duration.millis(200),end);

		Timeline timeline = new Timeline(frame);
		Timeline timeline1 = new Timeline(upFrame);
		Timeline timeline2 = new Timeline(downFrame);
		Timeline timeline3 = new Timeline(k4);
		Timeline timeline4 = new Timeline(k5);

		SequentialTransition sequence = new SequentialTransition(timeline, timeline1, timeline2, timeline3, timeline4);
		 sequence.play();
	}

	@FXML
	public void movementAnimation(){
		KeyValue start = new KeyValue(Uploader.translateYProperty(), 100);
		KeyValue end = new KeyValue(Uploader.translateYProperty(), -100);

		KeyFrame kf1 = new KeyFrame(Duration.seconds(3), start, end);

		Timeline timeline1 = new Timeline(kf1);
		 SequentialTransition sequence = new SequentialTransition(timeline1);
		 sequence.play();
	}

	private  void fadeOut(){
		FadeTransition fadeTransition =new FadeTransition();
		fadeTransition.setDuration(Duration.millis(2000));
		fadeTransition.setNode(anchor);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();
	}

	@FXML
	protected void toUploader(ActionEvent event) throws IOException {
		fadeOut();
		Parent uploader = FXMLLoader.load(getClass().getResource("file-upload.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(uploader);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	protected void toGallery(ActionEvent event) throws IOException {
		fadeOut();
		Parent gallery = FXMLLoader.load(getClass().getResource("gallery-view.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(gallery);
		stage.setScene(scene);
		stage.show();
	}

}