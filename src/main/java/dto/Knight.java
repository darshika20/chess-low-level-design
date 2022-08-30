package dto;

import strategy.MoveStrategy;

public class Knight extends Piece{

    public Knight(Location location, MoveStrategy moveStrategy, String color) {
        super(location, "Knight", moveStrategy, color);
    }

}
