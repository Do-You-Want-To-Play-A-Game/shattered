package com.dywtpag.shattered.puzzle;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public class PuzzleNode extends ImageView
{
	private double mouseX;
	private double mouseY;

	private int originalX;
	private int originalY;

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
	}
}
