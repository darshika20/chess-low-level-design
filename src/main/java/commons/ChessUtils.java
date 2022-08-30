package commons;

import model.Board;
import model.Cell;

import java.util.ArrayList;
import java.util.List;

public class ChessUtils {

    public static List<Cell> getMovesForDirections(int[][] directions, Cell cell) {
        Board board = getBoard();
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

    public static Board getBoard() {
        return Board.getInstance(8);
    }

}
