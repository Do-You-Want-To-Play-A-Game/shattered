package com.dywtpag.shattered;

import com.dywtpag.shattered.puzzle.PuzzleCreator;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HelloApplicationTest
{
	@Test
	public void test() throws IOException
	{
		File file = new File("test.bmp");
		BufferedImage image = ImageIO.read(file);

		PuzzleCreator.createPuzzle(image, 5, 5);
	}

}