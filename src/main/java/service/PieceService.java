package service;

import model.Cell;
import model.Color;
import model.Piece;
import strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PieceService {

    private List<Cell> getAllPossibleMoves(Piece piece) {
        Cell cell = piece.getCell();
        List<Cell> possibleMoves = new ArrayList<>();
        for (MoveStrategy moveStrategy : piece.getMoveStrategy()) {
            possibleMoves.addAll(moveStrategy.getAllPossibleMoves(cell));
        }
        return possibleMoves;
    }

    public Set<Cell> getAllValidMoves(Piece piece) {
        Set<Cell> validMoves = new HashSet<>();
        List<Cell> locations = getAllPossibleMoves(piece);
        for (Cell loc : locations) {
            if (!isKillingItsOwnPiece(loc, piece)) {
                validMoves.add(loc);
            }
        }
        return validMoves;
    }

    private boolean isKillingItsOwnPiece(Cell cell, Piece sourcePiece) {
        Color color = sourcePiece.getColor();
        return cell.getPiece() != null && cell.getPiece().getColor() == color;
    }

    public void move(Cell cell, Piece piece) {
        if (getAllValidMoves(piece).contains(cell)) {
            if (cell.getPiece() != null) {
                killPiece(cell.getPiece());
            }
            piece.getCell().setPiece(null);
            cell.setPiece(piece);
            piece.setCell(cell);
        } else {
            throw new RuntimeException("This move (" + cell.getRow() + "," + cell.getCol() + ") is not valid");
        }
    }

    private void killPiece(Piece piece) {
        piece.setKilled(true);
        piece.setCell(null);
    }
}
