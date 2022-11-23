package com.dywtpag.shattered.puzzle;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class PuzzleCreator
{
	public static PuzzleNode[][] createPuzzle(BufferedImage image, int rows, int columns)
	{
		PuzzleNode[][] pieces = new PuzzleNode[rows][columns];


		int height = image.getHeight();
		int width = image.getWidth();

		int puzzleHeight = (height / columns);
		int puzzleWidth = (width / rows);



		PuzzleNode.setHeight(puzzleHeight);
		PuzzleNode.setWidth(puzzleWidth);

		for (int x = 0; x < width; x += puzzleWidth)
		{
			for (int y = 0; y < height; y += puzzleHeight)
			{
				//TODO cut off excess if error
				BufferedImage subImage = image.getSubimage(x, y, puzzleWidth, puzzleHeight);

				PuzzleNode puzzleNode = new PuzzleNode(subImage, x / puzzleWidth, y / puzzleHeight);
				pieces[x / puzzleWidth][y / puzzleHeight] = puzzleNode;
			}
		}

		return pieces;
	}
  
}
