package model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {

    @Getter
    private final Cell[][] matrix;

    public static Board board;

    private Board(int n) {
        matrix = new Cell[n][n];
        boolean white = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Color color = Color.BLACK;
                if (white) {
                    color = Color.WHITE;
                }
                matrix[i][j] = new Cell(color, i, j);
                white = !white;
            }
        }
    }

    public static Board getInstance(int capacity) {

        if (board == null) {
            board = new Board(capacity);
            System.out.println("New board created with capacity " + capacity);
        }
        return board;
    }


}
