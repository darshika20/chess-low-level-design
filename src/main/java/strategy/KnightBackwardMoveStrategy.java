package strategy;

import commons.ChessUtils;
import model.Cell;

import java.util.List;

public class KnightBackwardMoveStrategy implements MoveStrategy {
    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        int[][] directions = {{-2,-1},{-1,-2},{-2,1},{-1,2}};
        return ChessUtils.getMovesForDirections(directions, cell);
    }
}
