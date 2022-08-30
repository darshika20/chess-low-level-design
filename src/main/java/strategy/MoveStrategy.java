package strategy;

import dto.Board;
import dto.Cell;

import java.util.List;

public interface MoveStrategy {

    default Board getBoard() {
        return Board.getInstance(8);
    }

    List<Cell> getAllPossibleMoves(Cell cell);
}
