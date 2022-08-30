package strategy;

import dto.Board;
import dto.Cell;

import java.util.ArrayList;
import java.util.List;

public class KnightForwardMoveStrategy implements MoveStrategy{
    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = getBoard();
        int[][] directions = {{2,1},{1,2},{2,-1},{1,-2}};
        List<Cell> moves = new ArrayList<>();
        for (int[] direction : directions) {
            int newrow = cell.getRow()+direction[0];
            int newcol = cell.getCol()+direction[1];
            if (newrow >= 0 && newrow < board.getMatrix().length && newcol >= 0 && newcol < board.getMatrix().length) {
                moves.add(board.getMatrix()[newrow][newcol]);
            }
        }
        return moves;
    }
}
