package strategy;

import dto.Board;
import dto.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftHorizontalMoveStrategy implements MoveStrategy{

    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        Board board = getBoard();
        Cell[] row = board.getMatrix()[cell.getRow()];
        return new ArrayList<>(Arrays.asList(row).subList(0, cell.getCol()));
    }
}
