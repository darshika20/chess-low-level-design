package strategy;

import commons.ChessUtils;
import model.Cell;

import java.util.List;

public class KingMoveStrategy implements MoveStrategy{
    @Override
    public List<Cell> getAllPossibleMoves(Cell cell) {
        int[][] directions = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        return ChessUtils.getMovesForDirections(directions, cell);
    }
}
