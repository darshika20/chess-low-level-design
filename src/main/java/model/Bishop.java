package model;

import strategy.MoveStrategy;

import java.util.List;

public class Bishop extends Piece{

    public Bishop(List<MoveStrategy> moveStrategy, Color color) {
        super(PieceType.BISHOP, moveStrategy, color);
    }

}
