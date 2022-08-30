package factory;

import model.*;
import strategy.MoveStrategy;

import java.util.List;

public class PieceFactory {

    public static Piece getPiece(PieceType pieceType, Color color) {

        List<MoveStrategy> moveStrategies = MovesFactory.getMovesForPieceWithColor(pieceType, color);
        if (pieceType.equals(PieceType.ROOK)) {
            return new Rook(moveStrategies, color);
        } else if (pieceType.equals(PieceType.BISHOP)) {
            return new Bishop(moveStrategies, color);
        } else if (pieceType.equals(PieceType.KING)) {
            return new King(moveStrategies, color);
        }else if (pieceType.equals(PieceType.KNIGHT)) {
            return new Knight(moveStrategies, color);
        }else if (pieceType.equals(PieceType.PAWN)) {
            return new Pawn(moveStrategies, color);
        }else if (pieceType.equals(PieceType.QUEEN)) {
            return new Queen(moveStrategies, color);
        } else {
            throw new RuntimeException("Invalid piece type!");
        }
    }
}
