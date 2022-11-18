package com.dywtpag.shattered.puzzle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PuzzleCreator
{
	public static void createPuzzle(BufferedImage image, int rows, int columns) throws IOException
	{
		int height = image.getHeight();
		int width = image.getWidth();

		int puzzleHeight = height / columns;
		int puzzleWidth = width / rows;

		for (int x = 0; x < width; x += puzzleWidth)
		{
			for (int y = 0; y < height; y += puzzleHeight)
			{
				BufferedImage subImage = image.getSubimage(x, y, puzzleWidth, puzzleHeight);
//				ImageIO.write(subImage, "bmp", new File("result" + x + "-" + y + ".jpg"));
//				System.out.println("x range:" + x + " - " + (x + puzzleWidth));
//				System.out.println("y range: " + y + " - " + (y + puzzleHeight));
//				System.out.println();
			}
		}
	}
}
