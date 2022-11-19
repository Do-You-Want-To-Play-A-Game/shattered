package com.dywtpag.shattered.puzzle;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public interface PuzzleCreator {
	List<BufferedImage> createPuzzle(BufferedImage image, int rows, int columns) throws IOException;
}
