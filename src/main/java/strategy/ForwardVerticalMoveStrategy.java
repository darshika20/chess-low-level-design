package strategy;

import dto.Board;
import dto.Cell;

import java.util.ArrayList;
import java.util.List;

public class ForwardVerticalMoveStrategy implements MoveStrategy{
    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = getBoard();
        List<Cell> moves = new ArrayList<>();
        for (int j = cell.getRow(); j < board.getMatrix().length; j++) {
            moves.add(board.getMatrix()[j][cell.getCol()]);
        }
        return moves;
    }
}
