package factory;

import model.PieceType;
import strategy.*;

import java.util.ArrayList;
import java.util.List;

public class WhitePieceMovesFactory {

    public static List<MoveStrategy> getMovesForPiece(PieceType pieceType) {
        List<MoveStrategy> moveStrategies = new ArrayList<>();
        if (pieceType.equals(PieceType.BISHOP)) {
            moveStrategies.add(new LeftForwardDiagonalMoveStrategy());
            moveStrategies.add(new RightForwardDiagonalMoveStrategy());
        } else if (pieceType.equals(PieceType.KING)) {
            moveStrategies.add(new KnightForwardMoveStrategy());
        } else if (pieceType.equals(PieceType.KNIGHT)) {
            moveStrategies.add(new KnightForwardMoveStrategy());
        } else if (pieceType.equals(PieceType.PAWN)) {
            moveStrategies.add(new PawnForwardMoveStrategy());
        } else if (pieceType.equals(PieceType.QUEEN)) {
            moveStrategies.add(new BackwardVerticalMoveStrategy());
            moveStrategies.add(new ForwardVerticalMoveStrategy());
            moveStrategies.add(new LeftBackwardDiagonalMoveStrategy());
            moveStrategies.add(new RightBackwardDiagonalMoveStrategy());
            moveStrategies.add(new LeftForwardDiagonalMoveStrategy());
            moveStrategies.add(new RightForwardDiagonalMoveStrategy());
            moveStrategies.add(new RightHorizontalMoveStrategy());
            moveStrategies.add(new LeftHorizontalMoveStrategy());
        } else if (pieceType.equals(PieceType.ROOK)) {
            moveStrategies.add(new BackwardVerticalMoveStrategy());
            moveStrategies.add(new ForwardVerticalMoveStrategy());
            moveStrategies.add(new RightHorizontalMoveStrategy());
            moveStrategies.add(new LeftHorizontalMoveStrategy());
        } else {
            throw new RuntimeException("Invalid Piece!");
        }
        return moveStrategies;
    }
}
