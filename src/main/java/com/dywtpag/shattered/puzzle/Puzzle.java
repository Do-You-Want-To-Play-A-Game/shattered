package com.dywtpag.shattered.puzzle;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Puzzle implements PuzzleCreator {

    public List<BufferedImage> createPuzzle(BufferedImage image, int rows, int columns) {
        List<BufferedImage> pieces = new ArrayList<>();
        int height = image.getHeight();
        int width = image.getWidth();

        int puzzleHeight = height / columns;
        int puzzleWidth = width / rows;

        for (int x = 0; x < width; x += puzzleWidth) {
            for (int y = 0; y < height; y += puzzleHeight) {
                BufferedImage subImage = image.getSubimage(x, y, puzzleWidth, puzzleHeight);
                pieces.add(subImage);
            }
        }
        return pieces;
    }
}
