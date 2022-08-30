package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
public class Player {

    private final String name;

    private final String email;

    private final List<Piece> pieces;

    @Setter
    private Color color;

    public Player(String name, String email, Color color, List<Piece> pieces) {
        this.name = name;
        this.email = email;
        this.color = color;
        this.pieces = pieces;
    }

}
