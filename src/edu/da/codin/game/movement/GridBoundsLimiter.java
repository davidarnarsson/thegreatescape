package edu.da.codin.game.movement;

import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.grid.Grid;
import edu.da.codin.game.grid.GridState;

/**
 * Created by davida on 11.2.2015.
 */
public class GridBoundsLimiter {
    private final int size;

    public GridBoundsLimiter(Grid g) {
        this.size = g.getSize();
    }

    public GridBoundsLimiter(GridState gs) {
        this.size = gs.getState().length;
    }

    public boolean canMove(Coord c) {


        return !(c.x >= size || c.x < 0 || c.y >= size || c.y < 0);
    }
}
