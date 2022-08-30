package dto;

import strategy.MoveStrategy;

public class Queen extends Piece{

    public Queen(Location location, MoveStrategy moveStrategy, String color) {
        super(location, "Queen", moveStrategy, color);
    }

}
