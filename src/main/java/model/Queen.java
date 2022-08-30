package model;

import strategy.MoveStrategy;

import java.util.List;

public class Queen extends Piece{

    public Queen(List<MoveStrategy> moveStrategy, Color color) {
        super(PieceType.QUEEN, moveStrategy, color);
    }

}
