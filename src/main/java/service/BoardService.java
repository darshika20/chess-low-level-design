package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {

    private Board board;

    public BoardService(Board board) {
        this.board = board;
    }

    public void initializeBoard(Map<PieceType, List<Piece>> whitePieces, Map<PieceType, List<Piece>> blackPieces) {

        if (!validateAllPieces(whitePieces, Color.WHITE) || !validateAllPieces(blackPieces, Color.BLACK)) {
            throw new RuntimeException("Board cannot be initialized as pieces are not valid");
        } else {
            initializeBoardWithPiecesInForwardDirection(whitePieces);
            initializeBoardWithPiecesInBackwardDirection(blackPieces);
        }
    }

    private boolean validateAllPieces(Map<PieceType, List<Piece>> pieceTypeListMap, Color color) {

        for (PieceType pieceType : pieceTypeListMap.keySet()) {
            if (pieceType.equals(PieceType.ROOK) || pieceType.equals(PieceType.BISHOP) ||
                    pieceType.equals(PieceType.KNIGHT)) {
                if (invalidatePieces(pieceTypeListMap.get(pieceType), pieceType, 2, color)) {
                    return false;
                }
            } else if (pieceType.equals(PieceType.QUEEN) || pieceType.equals(PieceType.KING)) {
                if (invalidatePieces(pieceTypeListMap.get(pieceType), pieceType, 1, color)) {
                    return false;
                }
            } else if (pieceType.equals(PieceType.PAWN)) {
                if (invalidatePieces(pieceTypeListMap.get(pieceType), pieceType, 8, color)) {
                    return false;
                }
            } else {
                throw new RuntimeException("Invalid Piece!");
            }
        }

        return true;
    }

    private boolean invalidatePieces(List<Piece> pieces, PieceType pieceType, int size, Color color) {

        if (pieces.size() != size) {
            return true;
        }
        for (Piece piece : pieces) {
            if (!piece.getName().equals(pieceType)  || piece.getColor() != color) {
                return true;
            }
        }
        return false;
    }

    private void initializeBoardWithPiecesInForwardDirection(Map<PieceType, List<Piece>> pieceTypeListMap) {

        Cell[][] matrix = board.getMatrix();

        List<Piece> piecesInOrder = getPiecesOrder(pieceTypeListMap);
        for (int i = 0; i < matrix.length; i++) {
            matrix[0][i].setPiece(piecesInOrder.get(i));
            piecesInOrder.get(i).setCell(matrix[0][i]);
            matrix[1][i].setPiece(pieceTypeListMap.get(PieceType.PAWN).get(i));
            pieceTypeListMap.get(PieceType.PAWN).get(i).setCell(matrix[1][i]);
        }

    }

    private void initializeBoardWithPiecesInBackwardDirection(Map<PieceType, List<Piece>> pieceTypeListMap) {

        Cell[][] matrix = board.getMatrix();

        List<Piece> piecesInOrder = getPiecesOrder(pieceTypeListMap);
        int capacity = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            matrix[capacity-1][i].setPiece(piecesInOrder.get(i));
            piecesInOrder.get(i).setCell(matrix[capacity-1][i]);
            matrix[capacity - 2][i].setPiece(pieceTypeListMap.get(PieceType.PAWN).get(i));
            pieceTypeListMap.get(PieceType.PAWN).get(i).setCell(matrix[capacity - 2][i]);
        }

    }

    private List<Piece> getPiecesOrder(Map<PieceType, List<Piece>> pieceTypeListMap) {

        List<Piece> piecesInOrder = new ArrayList<>();
        piecesInOrder.add(pieceTypeListMap.get(PieceType.ROOK).get(0));
        piecesInOrder.add(pieceTypeListMap.get(PieceType.KNIGHT).get(0));
        piecesInOrder.add(pieceTypeListMap.get(PieceType.BISHOP).get(0));
        piecesInOrder.add(pieceTypeListMap.get(PieceType.KING).get(0));
        piecesInOrder.add(pieceTypeListMap.get(PieceType.QUEEN).get(0));
        piecesInOrder.add(pieceTypeListMap.get(PieceType.BISHOP).get(1));
        piecesInOrder.add(pieceTypeListMap.get(PieceType.KNIGHT).get(1));
        piecesInOrder.add(pieceTypeListMap.get(PieceType.ROOK).get(1));
        return piecesInOrder;
    }

    public void displayBoard() {

        for (int i = 0; i < board.getMatrix().length; i++) {
            for (int j=0; j < board.getMatrix().length; j++) {
                System.out.print(board.getMatrix()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
