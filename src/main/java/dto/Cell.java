package dto;

import lombok.Getter;
import lombok.Setter;

public class Cell {

    private final Color color;

    @Getter
    @Setter
    private Piece piece;

    @Getter
    private final int row;

    @Getter
    private final int col;

    public Cell(Color color, int x, int y) {
        this.color = color;
        this.row = x;
        this.col = y;
    }

}
