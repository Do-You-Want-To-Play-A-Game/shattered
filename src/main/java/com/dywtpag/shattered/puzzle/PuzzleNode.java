package com.dywtpag.shattered.puzzle;

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

	private int originalX;
	private int originalY;
	private static int width;
	private static int height;
	public PuzzleNode(BufferedImage image, int originalX, int originalY)
	{
		this.setImage(SwingFXUtils.toFXImage(image, null));
		this.originalX = originalX;
		this.originalY = originalY;

		this.setOnMousePressed(mouseEvent ->
		{
			mouseX = mouseEvent.getX();
			mouseY = mouseEvent.getY();
		});

		this.setOnMouseDragged(mouseEvent ->
		{
			this.setLayoutX(mouseEvent.getSceneX() - mouseX);
			this.setLayoutY(mouseEvent.getSceneY() - mouseY);
		});

		this.setOnMouseReleased(mouseEvent ->
		{
		});
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
}
