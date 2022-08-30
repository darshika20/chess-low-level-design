package dto;

import lombok.Getter;
import lombok.Setter;
import strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public abstract class Piece {

    private final String name;

    @Setter
    private Cell cell;
    private final List<MoveStrategy> moveStrategy;

    private final Color color;

    @Setter
    private boolean killed;

    public Piece(Cell cell, String name, List<MoveStrategy> moveStrategy, Color color) {
        this.cell = cell;
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.color = color;
    }

    private List<Cell> getAllPossibleMoves() {
        List<Cell> possibleMoves = new ArrayList<>();
        for (MoveStrategy moveStrategy : this.moveStrategy) {
            possibleMoves.addAll(moveStrategy.getAllPossibleMoves(cell));
        }
        return possibleMoves;
    }

    public Set<Cell> getAllValidMoves() {
        Set<Cell> validMoves = new HashSet<>();
        List<Cell> locations = getAllPossibleMoves();
        for (Cell loc : locations) {
            if (!isKillingItsOwnPiece(loc)) {
                validMoves.add(loc);
            }
        }
        return validMoves;
    }

    private boolean isKillingItsOwnPiece(Cell cell) {
        return cell.getPiece() != null && cell.getPiece().getColor() == color;
    }

    public void move(Cell cell) {
        if (getAllValidMoves().contains(cell)) {
            if (cell.getPiece() != null) {
                killPiece(cell.getPiece());
            }
            cell.setPiece(this);
            this.cell = cell;
        } else {
            throw new RuntimeException("This move (" + cell.getRow() + "," + cell.getCol() + ") is not valid");
        }
    }

    private void killPiece(Piece piece) {
        piece.setKilled(true);
        piece.setCell(null);
    }

}
