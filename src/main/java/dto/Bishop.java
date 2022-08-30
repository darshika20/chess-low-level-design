package dto;

import strategy.MoveStrategy;

public class Bishop extends Piece{

    public Bishop(Location location, MoveStrategy moveStrategy, String color) {
        super(location, "Bishop", moveStrategy, color);
    }

}
