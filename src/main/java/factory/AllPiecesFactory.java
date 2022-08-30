package factory;

import model.Color;
import model.Piece;
import model.PieceType;

import java.util.ArrayList;
import java.util.List;

import static model.Color.BLACK;
import static model.Color.WHITE;

public class AllPiecesFactory {

    public static List<Piece> getAllDefaultPieces() {
        List<Piece> pieces = getAllDefaultPiecesForColor(WHITE);
        pieces.addAll(getAllDefaultPiecesForColor(BLACK));
        return pieces;
    }

    public static List<Piece> getAllDefaultPiecesForColor(Color color) {

        List<Piece> pieces = new ArrayList<>();
        pieces.add(PieceFactory.getPiece(PieceType.KING, color));
        pieces.add(PieceFactory.getPiece(PieceType.QUEEN, color));
        for (int i = 0; i < 8; i++) {
            if (i < 2) {
                pieces.add(PieceFactory.getPiece(PieceType.BISHOP, color));
                pieces.add(PieceFactory.getPiece(PieceType.ROOK, color));
                pieces.add(PieceFactory.getPiece(PieceType.KNIGHT, color));
            }
            pieces.add(PieceFactory.getPiece(PieceType.PAWN, color));
        }
        return pieces;
    }
}
