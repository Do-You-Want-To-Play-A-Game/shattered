package com.dywtpag.shattered.puzzle;

import com.dywtpag.shattered.GameController;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.awt.image.BufferedImage;

public class PuzzleNode extends ImageView
{
	private double mouseX;
	private double mouseY;

	private final int originalX;
	private final int originalY;

	private int previousGridX;
	private int previousGridY;

	private static int width;
	private static int height;

	private GridPane gridContainer;
	private AnchorPane mainContainer;

	private GameController controller;

	public PuzzleNode(BufferedImage image, int originalX, int originalY)
	{
		this.setImage(SwingFXUtils.toFXImage(image, null));
		this.originalX = originalX;
		this.originalY = originalY;

		this.setOnMousePressed(mouseEvent ->
		{

			mouseX = mouseEvent.getX();
			mouseY = mouseEvent.getY();

			double x = this.getLayoutX();
			double y = this.getLayoutY();

			previousGridX = (int) Math.round(x / width);
			previousGridY = (int) Math.round(y / height);

			removeFromGrid();
		});

		this.setOnMouseDragged(mouseEvent ->
		{
			this.setLayoutX(mouseEvent.getSceneX() - mouseX);
			this.setLayoutY(mouseEvent.getSceneY() - mouseY);
		});

		this.setOnMouseReleased(mouseEvent ->
		{
			double x = this.getLayoutX();
			double y = this.getLayoutY();

			int gridX = (int) Math.round(x / width);
			int gridY = (int) Math.round(y / height);


			gridX = Math.min(gridContainer.getColumnCount() - 1, gridX);
			gridX = Math.max(0, gridX);
			gridY = Math.min(gridContainer.getRowCount() - 1, gridY);
			gridY = Math.max(0, gridY);


			PuzzleNode nodeToBeSwapped = controller.getNode(gridX, gridY);

			if (nodeToBeSwapped != null && !nodeToBeSwapped.equals(this))
			{
				controller.swap(gridX, gridY, previousGridX, previousGridY);
				int temp = GridPane.getRowIndex(this);
				GridPane.setRowIndex(this, GridPane.getRowIndex(nodeToBeSwapped));
				GridPane.setRowIndex(nodeToBeSwapped, temp);

				temp = GridPane.getColumnIndex(this);
				GridPane.setColumnIndex(this, GridPane.getColumnIndex(nodeToBeSwapped));
				GridPane.setColumnIndex(nodeToBeSwapped, temp); // TODO store puzzle pieces in 2d array to solve lookup
			}



			gridContainer.add(this, gridX, gridY);

			controller.checkForWin();
		});
	}

	public Boolean checkPosition()
	{
		double x = this.getLayoutX();
		double y = this.getLayoutY();

		int gridX = (int) Math.round(x / width);
		int gridY = (int) Math.round(y / height);

		boolean checkX = gridX == originalX;
		boolean checkY = gridY == originalY;

		return checkX && checkY;
	}

	public void removeFromGrid()
	{
		if (!gridContainer.getChildren().contains(this)) // if the grid doesn't contain the node then ignore this function
		{
			return;
		}

		double x = this.getLayoutX();
		double y = this.getLayoutY();

		int gridX = (int) Math.round(x / width);
		int gridY = (int) Math.round(y / height);

		gridContainer.getChildren().remove(this);
		mainContainer.getChildren().add(this);
	}

	public void setGridContainer(GridPane gridContainer)
	{
		this.gridContainer = gridContainer;
	}

	public void setMainContainer(AnchorPane mainContainer)
	{
		this.mainContainer = mainContainer;
	}

	public static int getWidth()
	{
		return width;
	}

	public static void setWidth(int width)
	{
		PuzzleNode.width = width;
	}

	public static int getHeight()
	{
		return height;
	}

	public static void setHeight(int height)
	{
		PuzzleNode.height = height;
	}

	public int getOriginalX()
	{
		return originalX;
	}

	public int getOriginalY()
	{
		return originalY;
	}

	public void setController(GameController controller)
	{
		this.controller = controller;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		PuzzleNode that = (PuzzleNode) o;

		if (originalX != that.originalX)
		{
			return false;
		}
		return originalY == that.originalY;
	}
}
