package edu.da.codin.game;

import edu.da.codin.game.action.Action;
import edu.da.codin.game.action.validators.ActionValidator;
import edu.da.codin.game.action.validators.ValidatorFactory;
import edu.da.codin.game.entities.Player;
import edu.da.codin.game.entities.PlayerStrategy;
import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.grid.Grid;
import edu.da.codin.game.grid.GridState;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by davida on 11.2.2015.
 */
class Game {



    private final Queue<Player> players = new ArrayDeque<>();
    private final Grid grid = new Grid();
    private final Map<Player, Coord> initialPositions = new HashMap<>();
    private final Map<Player, Coord> endPositions = new HashMap<>();

    public Game() {

    }

    /* TODO: refactor the creation of the player out of this function plzkthxbai */
    public void addPlayer(String marker, Coord initialPos, Coord endPos, PlayerStrategy action) {
        Player p = new Player(marker, action);
        p.setCoordinates(initialPos);

        initialPositions.put(p, initialPos);
        endPositions.put(p, endPos);

        grid.addEntity(p);
        players.add(p);
    }

    public void play() {
        do {
            System.out.println(grid.toString());
            Player current = players.poll();

            System.out.println("Current player: " + current.getMarker());
            GridState state = grid.getGridStateForPlayer(current);

            Action a = current.getStrategy().getAction(state);

            if (!hasLost(current, state, a)) {
                a.apply(grid, current);
                players.add(current);
            } else {
                grid.removeEntity(current);
                System.out.println("Player " + current.getMarker() + " loses!");
            }

            if (hasWon(current, state, a)) {
                System.out.println("Player " + current.getMarker() + " wins!");
                break;
            }


        } while (true);
    }

    public boolean hasWon(Player p, GridState state, Action a) {
        Coord initialPos = initialPositions.get(p);
        Coord endPos = endPositions.get(p);
        boolean horizontal = Math.abs(initialPos.x - endPos.x) == 8;

        return horizontal ? p.getCoordinates().x == endPos.x : p.getCoordinates().y == endPos.y;
    }

    public boolean hasLost(Player p, GridState state, Action a) {
        ActionValidator validator = ValidatorFactory.getValidator(a);
        return !validator.validate(p, state, a);
    }
}
