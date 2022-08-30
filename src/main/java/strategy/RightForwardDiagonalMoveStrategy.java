package strategy;

import dto.Board;
import dto.Cell;

import java.util.ArrayList;
import java.util.List;

public class RightForwardDiagonalMoveStrategy implements MoveStrategy{
    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = getBoard();
        List<Cell> moves = new ArrayList<>();
        for (int i = cell.getRow()+1, j = cell.getCol()+1; i < board.getMatrix().length && j < board.getMatrix().length;
             i++, j++) {
            moves.add(board.getMatrix()[i][j]);
        }
        return moves;
    }
}
