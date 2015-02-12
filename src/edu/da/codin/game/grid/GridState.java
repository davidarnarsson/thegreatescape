package edu.da.codin.game.grid;

import edu.da.codin.game.entities.Wall;
import edu.da.codin.game.movement.GridBoundsLimiter;

import java.io.OutputStream;

/**
 * Created by davida on 11.2.2015.
 */
public class GridState {
    private final ReadOnlyCell[][] state;
    public GridState(ReadOnlyCell[][] cells) {
        state = cells;
    }

    public void serialize(OutputStream stream) {


    }

    public Wall getWallForCell(int x, int y) {
        GridBoundsLimiter limiter = new GridBoundsLimiter(this);
        if (!limiter.canMove(new Coord(x,y))) return null;

        return getState()[x][y].getWall();
    }

    public ReadOnlyCell[][] getState() {
        return state;
    }
}
