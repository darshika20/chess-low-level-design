package model;

import strategy.MoveStrategy;

import java.util.List;

public class King extends Piece{

    public King(List<MoveStrategy> moveStrategy, Color color) {
        super(PieceType.KING, moveStrategy, color);
    }

}
