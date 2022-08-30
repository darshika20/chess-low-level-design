package factory;

import model.Color;
import model.PieceType;
import strategy.MoveStrategy;

import java.util.List;

public class MovesFactory {

    public static List<MoveStrategy> getMovesForPieceWithColor(PieceType pieceType, Color color) {

        if (color.equals(Color.WHITE)) {
            return WhitePieceMovesFactory.getMovesForPiece(pieceType);
        } else if (color.equals(Color.BLACK)) {
            return BlackPieceMovesFactory.getMovesForPiece(pieceType);
        } else {
            throw new RuntimeException("Invalid Color");
        }
    }
}
