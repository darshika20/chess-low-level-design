package model;

import lombok.Getter;
import lombok.Setter;
import strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public abstract class Piece {

    private final PieceType name;

    @Setter
    private Cell cell;
    private final List<MoveStrategy> moveStrategy;

    private final Color color;

    @Setter
    private boolean killed;

    public Piece(PieceType name, List<MoveStrategy> moveStrategy, Color color) {
        this.cell = cell;
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.color = color;
    }



}
