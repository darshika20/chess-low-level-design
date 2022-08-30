package dto;

import strategy.MoveStrategy;

public class Rook extends Piece{

    public Rook(Location location, MoveStrategy moveStrategy, String color) {
        super(location, "Rook", moveStrategy, color);
    }

}
