package edu.da.codin.game.movement;

import edu.da.codin.game.grid.Coord;

/**
 * Created by davida on 11.2.2015.
 */
public class MovementCalculator {

    public static Coord move(Coord c, Direction d) {
        Coord n = new Coord();
        switch (d) {
            case NORTH: n.x = c.x; n.y = c.y - 1; break;
            case SOUTH: n.x = c.x; n.y = c.y + 1; break;
            case EAST: n.x = c.x + 1; n.y = c.y; break;
            case WEST: n.x = c.x -1; n.y = c.y; break;
        }

        return n;
    }
}
