package strategy;

import dto.Board;
import dto.Cell;

import java.util.ArrayList;
import java.util.List;

public class PawnBackwardMoveStrategy implements MoveStrategy{
    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = getBoard();
        List<Cell> moves = new ArrayList<>();
        for (int j = cell.getRow()-1; j >= cell.getRow()-2; j--) {
            moves.add(board.getMatrix()[j][cell.getCol()]);
        }
        if(cell.getRow() > 0 && cell.getCol() > 0) {
            moves.add(board.getMatrix()[cell.getRow()-1][cell.getCol()-1]);
        }
        return moves;
    }
}
