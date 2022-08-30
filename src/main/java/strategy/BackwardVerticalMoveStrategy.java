package strategy;

import dto.Board;
import dto.Cell;

import java.util.ArrayList;
import java.util.List;

public class BackwardVerticalMoveStrategy implements MoveStrategy{

    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = getBoard();
        List<Cell> moves = new ArrayList<>();
        for (int j = 0; j < cell.getRow(); j++) {
            moves.add(board.getMatrix()[j][cell.getCol()]);
        }
        return moves;
    }
}
