package com.dywtpag.shattered;

import com.dywtpag.shattered.puzzle.PuzzleCreator;
import com.dywtpag.shattered.puzzle.PuzzleNode;
import javafx.fxml.FXML;
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

	public void makeGame()
	{
		PuzzleNode[][] puzzle = PuzzleCreator.createPuzzle(FileUploadController.getImgToChop(), 10, 5);
		//todo I think the rows and columns are backwards (its making 10 col 5 rows instead of 10 rows 5 col) fix
		// this later

		//todo let rows and columns be changed (with difficulty selection)

		for (int i = 0; i < puzzle.length; i++)
		{
			grid.addColumn(i);
			PuzzleNode[] puzzleNodeRow = puzzle[i];

			for (int j = 0; j < puzzleNodeRow.length; j++)
			{
				PuzzleNode puzzleNode = puzzleNodeRow[j];

				grid.addRow(j);
				grid.add(puzzleNode, i, j);

//				main.getChildren().add(puzzleNode);
			}
		}
	}

	@FXML
	public void initialize() throws IOException
	{
		makeGame();
	}
}
