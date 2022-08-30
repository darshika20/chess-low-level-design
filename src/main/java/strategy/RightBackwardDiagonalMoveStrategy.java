package strategy;

import commons.ChessUtils;
import model.Board;
import model.Cell;

import java.util.ArrayList;
import java.util.List;

public class RightBackwardDiagonalMoveStrategy implements MoveStrategy{
    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = ChessUtils.getBoard();
        List<Cell> moves = new ArrayList<>();
        for (int i = cell.getRow()-1, j = cell.getCol()+1; i >= 0 && j < board.getMatrix().length; i--, j++) {
            moves.add(board.getMatrix()[i][j]);
        }
        return moves;
    }
}
