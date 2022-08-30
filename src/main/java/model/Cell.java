package model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cell implements Comparable<Cell>{

    private final Color color;

    @Setter
    private Piece piece;

    private final int row;

    private final int col;

    public Cell(Color color, int x, int y) {
        this.color = color;
        this.row = x;
        this.col = y;
    }

    @Override
    public int compareTo(Cell o) {
        if (row == o.getRow() && col == o.getCol()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        if (piece != null) {
            return piece.getName().getCode()+((piece.getColor() == Color.WHITE) ? "-W" : "-B");
        } else {
            return "_";
        }
    }
}
