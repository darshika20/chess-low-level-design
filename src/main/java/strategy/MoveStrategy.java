package strategy;

import model.Cell;

import java.util.List;

public interface MoveStrategy {

    List<Cell> getAllPossibleMoves(Cell cell);
}
