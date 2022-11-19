package com.dywtpag.shattered.puzzle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PuzzleCreator
{
	public static ArrayList<BufferedImage> createPuzzle(BufferedImage image, int rows, int columns) throws IOException
	{
		ArrayList<BufferedImage> pieces = new ArrayList<>();

		int height = image.getHeight();
		int width = image.getWidth();

		int puzzleHeight = height / columns;
		int puzzleWidth = width / rows;

		for (int x = 0; x < width; x += puzzleWidth)
		{
			for (int y = 0; y < height; y += puzzleHeight)
			{
				BufferedImage subImage = image.getSubimage(x, y, puzzleWidth, puzzleHeight);
				pieces.add(subImage);
//				ImageIO.write(subImage, "bmp", new File("result" + x + "-" + y + ".jpg"));
//				System.out.println("x range:" + x + " - " + (x + puzzleWidth));
//				System.out.println("y range: " + y + " - " + (y + puzzleHeight));
//				System.out.println();
			}
		}

		return pieces;
	}
}

