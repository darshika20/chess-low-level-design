package model;

import strategy.MoveStrategy;

import java.util.List;

public class Rook extends Piece{

    public Rook(List<MoveStrategy> moveStrategy, Color color) {
        super(PieceType.ROOK, moveStrategy, color);
    }

}
