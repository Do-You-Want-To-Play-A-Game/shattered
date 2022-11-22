package com.dywtpag.shattered;

import com.dywtpag.shattered.puzzle.PuzzleCreator;
import com.dywtpag.shattered.puzzle.PuzzleNode;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameController
{

	@FXML
	public AnchorPane main;

	@FXML
	public GridPane grid;

	@FXML
	public Button startButton;

	@FXML
	public ImageView image;

	private PuzzleNode[][] puzzle;

	public AnchorPane anchor;
	public TextField timeBox;
	public ImageView volume;

	public void makeGame()
	{
		int rows = 10;
		int cols = 5;
		puzzle = PuzzleCreator.createPuzzle(FileUploadController.getImgToChop(), rows, cols);
		shuffle2dArray(puzzle);


		for (int i = 0; i < puzzle.length; i++)
		{
//			grid.addColumn(i);
			PuzzleNode[] puzzleNodeRow = puzzle[i];

			for (int j = 0; j < puzzleNodeRow.length; j++)
			{
				PuzzleNode puzzleNode = puzzleNodeRow[j];

				puzzleNode.setGridContainer(grid);
				puzzleNode.setMainContainer(main);
				puzzleNode.setController(this);

				grid.add(puzzleNode, i, j);

//				grid.addRow(j);

//				main.getChildren().add(puzzleNode);
			}
		}
	}

	private void shuffle2dArray(PuzzleNode[][] puzzle)
	{
		PuzzleNode[] flattenedArray = new PuzzleNode[puzzle.length * puzzle[0].length];

		int count = 0;
		for (PuzzleNode[] puzzleNodes : puzzle)
		{
			for (int j = 0; j < puzzle[0].length; j++)
			{
				flattenedArray[count] = puzzleNodes[j];
				count++;
			}
		}

		List<PuzzleNode> puzzleNodeList = Arrays.asList(flattenedArray);
		Collections.shuffle(puzzleNodeList);

		puzzleNodeList.toArray(flattenedArray);

		count = 0;
		for (int i = 0; i < puzzle.length; i++)
		{
			for (int j = 0; j < puzzle[0].length; j++)
			{
				puzzle[i][j] = flattenedArray[count];
				count++;
			}
		}

	}

	public PuzzleNode getNode(int x, int y)
	{
		return puzzle[x][y];
	}

	public void swap(int x1, int y1, int x2, int y2)
	{
		PuzzleNode node1 = puzzle[x1][y1];
		PuzzleNode node2 = puzzle[x2][y2];

		puzzle[x1][y1] = node2;
		puzzle[x2][y2] = node1;
	}

	@FXML
	public void initialize()
	{
		image.setImage(SwingFXUtils.toFXImage(FileUploadController.getImgToChop(), null));
		image.setFitWidth(grid.getWidth());
		image.setFitHeight(grid.getHeight());
		startButton.setOnMouseClicked(event -> start());

		Image background = new Image(HelloApplication.class.getResource("tableTop.jpeg").toString());

		//allows the image to be scaled by the window size
		BackgroundImage bgImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));

		//sets the background of the root pane to the background image
		main.setBackground(new Background(bgImage));

		//Initial image set for the background music. this carries over from the home menu
		Image muted = new Image(HelloApplication.class.getResource("muted-volume.png").toString());
		Image Full = new Image(HelloApplication.class.getResource("volume-on.png").toString());

		if (HelloController.volumeOn)
		{
			volume.setImage(Full);
		}
		else if (!HelloController.volumeOn)
		{
			volume.setImage(muted);
		}
	}

	@FXML
	public void start()
	{
		System.out.println("start");
		main.getChildren().remove(image);
		main.getChildren().remove(startButton);
		makeGame();
		timer.start();
	}

	@FXML
	protected void backToHome(ActionEvent event) throws IOException
	{
		Parent home_page = FXMLLoader.load(getClass().getResource("home.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(home_page);
		stage.setScene(scene);
		stage.show();
	}

	//Puzzle timer section

	int elapsedTime = 0;
	int seconds = 0;
	int minuets = 0;
	int hours = 0;
	Timer timer = new Timer(1000, new ActionListener()
	{
		public void actionPerformed(java.awt.event.ActionEvent e)
		{
			elapsedTime += 1000;
			seconds = (elapsedTime / 1000) % 60;
			minuets = (elapsedTime / 60000) % 60;
			hours = (elapsedTime / 36000000);

			timeBox.setText(hours + ":" + minuets + ":" + seconds);
		}
	});

	public void mute()
	{
		Image muted = new Image(HelloApplication.class.getResource("muted-volume.png").toString());
		Image Full = new Image(HelloApplication.class.getResource("volume-on.png").toString());

		if (HelloController.volumeOn)
		{
			volume.setImage(muted);
			HelloController.volumeOn = false;
		}
		else if (!HelloController.volumeOn)
		{
			volume.setImage(Full);
			HelloController.volumeOn = true;
		}

	}
}

