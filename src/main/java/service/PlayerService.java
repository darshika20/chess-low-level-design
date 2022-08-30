package service;

import model.Color;
import model.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerService {

    private final Map<Color, Player> colorPlayerMap;

    public PlayerService() {
        colorPlayerMap = new HashMap<>();
    }

    public void  registerPlayer(String name, String email, Color color) {

        if (colorPlayerMap.containsKey(color)) {
            throw new RuntimeException("Another player is already registered with this color");
        }
        Player player = new Player(name, email, color);
        colorPlayerMap.put(color, player);
    }
}
