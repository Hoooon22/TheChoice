package com.mygdx.the_choice.map;

import com.badlogic.gdx.math.MathUtils;

public class MapGenerator {
    private int[][] mapTiles;
    private int tileSize = 20;

    public MapGenerator() {
        int numRows = 10;
        int numCols = 10;
        mapTiles = new int[numRows][numCols];

        // Initialize map tiles
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                mapTiles[row][col] = 0; // Set all tiles to 0 initially
            }
        }

        // Randomly place obstacles on the map
        int numObstacles = tileSize;
        for (int i = 0; i < numObstacles; i++) {
            int row = MathUtils.random(numRows - 1);
            int col = MathUtils.random(numCols - 1);
            mapTiles[row][col] = 1; // Set random tile to an obstacle
        }

        // Randomize the tile positions
        for (int i = 0; i < 100; i++) {
            int row1 = MathUtils.random(numRows - 1);
            int col1 = MathUtils.random(numCols - 1);
            int row2 = MathUtils.random(numRows - 1);
            int col2 = MathUtils.random(numCols - 1);
            int temp = mapTiles[row1][col1];
            mapTiles[row1][col1] = mapTiles[row2][col2];
            mapTiles[row2][col2] = temp;
        }
    }

    public int[][] getMapTiles() {
        return mapTiles;
    }

    public int getTileSize() {
        return tileSize;
    }
}