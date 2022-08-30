package strategy;

import commons.ChessUtils;
import model.Board;
import model.Cell;

import java.util.ArrayList;
import java.util.List;

public class PawnForwardMoveStrategy implements MoveStrategy{

    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = ChessUtils.getBoard();
        List<Cell> moves = new ArrayList<>();
        for (int j = cell.getRow()+1; j <= cell.getRow()+2; j++) {
            moves.add(board.getMatrix()[j][cell.getCol()]);
        }
        if(cell.getRow() < board.getMatrix().length-1 && cell.getCol() < board.getMatrix().length-1) {
            moves.add(board.getMatrix()[cell.getRow()+1][cell.getCol()+1]);
        }
        return moves;
    }
}
