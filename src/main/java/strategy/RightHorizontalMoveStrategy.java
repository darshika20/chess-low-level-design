package strategy;

import commons.ChessUtils;
import model.Board;
import model.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightHorizontalMoveStrategy implements MoveStrategy{
    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = ChessUtils.getBoard();
        Cell[] row = board.getMatrix()[cell.getRow()];
        return new ArrayList<>(Arrays.asList(row).subList(cell.getCol(), row.length));
    }
}
