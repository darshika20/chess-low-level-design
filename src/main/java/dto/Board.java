package dto;

import lombok.Getter;

public class Board {

    @Getter
    private final Cell[][] matrix;

    public static Board board;

    private Board(int n) {
        matrix = new Cell[n][n];
    }

    public static Board getInstance(int capacity) {

        if (board == null) {
            board = new Board(capacity);
            System.out.println("New board created with capacity " + capacity);
        }
        return board;
    }
}
