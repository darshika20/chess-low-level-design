package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
public class Player {

    private final String name;

    private final String email;

    @Setter
    private Color color;

    public Player(String name, String email, Color color) {
        this.name = name;
        this.email = email;
        this.color = color;
    }
}
