package model;

import strategy.MoveStrategy;

import java.util.List;

public class Knight extends Piece{

    public Knight(List<MoveStrategy> moveStrategy, Color color) {
        super(PieceType.KNIGHT, moveStrategy, color);
    }

}
