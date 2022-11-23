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

	public void checkForWin()
	{

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
		try
		{
			return puzzle[x][y];
		}
		catch (IndexOutOfBoundsException exception)
		{
			return null;
		}

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
	}

	@FXML
	public void start()
	{
		System.out.println("start");
		main.getChildren().remove(image);
		main.getChildren().remove(startButton);
		makeGame();
	}
}
