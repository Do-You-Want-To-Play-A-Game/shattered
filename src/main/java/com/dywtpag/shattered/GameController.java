package com.dywtpag.shattered;

import com.dywtpag.shattered.puzzle.PuzzleCreator;
import com.dywtpag.shattered.puzzle.PuzzleNode;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

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

	public void makeGame()
	{
		int rows = 10;
		int cols = 5;
		puzzle = PuzzleCreator.createPuzzle(FileUploadController.getImgToChop(), rows, cols);
		//todo I think the rows and columns are backwards (its making 10 col 5 rows instead of 10 rows 5 col) fix
		// this later

		//todo let rows and columns be changed (with difficulty selection)



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

//				grid.addRow(j);
				grid.add(puzzleNode, i, j);

//				main.getChildren().add(puzzleNode);
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
	public void initialize() throws IOException
	{
		image.setImage(SwingFXUtils.toFXImage(FileUploadController.getImgToChop(), null));
		image.setFitWidth(grid.getWidth());
		image.setFitHeight(grid.getHeight());
		startButton.setOnMouseClicked(event -> start());
	}

	@FXML
	public void start()
	{
		System.out.println("start");
		main.getChildren().remove(image);
		makeGame();
	}
}
