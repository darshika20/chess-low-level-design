package dto;

import strategy.MoveStrategy;

public class Pawn extends Piece{

    public Pawn(Location location, MoveStrategy moveStrategy, String color) {
        super(location, "Pawn", moveStrategy, color);
    }

}
