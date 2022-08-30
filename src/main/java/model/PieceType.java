package model;

import lombok.Getter;

public enum PieceType {


    BISHOP("B"), KING("KI"), KNIGHT("KN"), PAWN("P"), QUEEN("Q"), ROOK("R");
    @Getter
    private final String code;
    PieceType(String code) {
        this.code = code;
    }
}
