package dto;

import strategy.MoveStrategy;

public class King extends Piece{

    public King(Location location, MoveStrategy moveStrategy, String color) {
        super(location, "King", moveStrategy, color);
    }

}
