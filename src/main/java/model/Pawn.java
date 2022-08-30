package model;

import strategy.MoveStrategy;

import java.util.List;

public class Pawn extends Piece{

    public Pawn(List<MoveStrategy> moveStrategy, Color color) {
        super(PieceType.PAWN, moveStrategy, color);
    }

}
