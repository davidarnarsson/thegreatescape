package edu.da.codin.game.action.validators;

import edu.da.codin.game.action.MoveAction;
import edu.da.codin.game.entities.Wall;
import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.grid.GridState;
import edu.da.codin.game.action.Action;
import edu.da.codin.game.entities.Player;
import edu.da.codin.game.grid.ReadOnlyCell;
import edu.da.codin.game.movement.Direction;

/**
 * Created by davida on 12.2.2015.
 *
 * 1 1 V: PLAYER PUTS A WALL BLOCKING PASSAGE FROM (1,1) TO (0,1) & FROM (1,2) TO (0,2)
 *
 */
public class MoveActionValidator implements ActionValidator {
    @Override
    public boolean validate(Player player, GridState state, Action action) {
        MoveAction ma = (MoveAction) action;

        Coord from = ma.getFrom();
        Coord to = ma.getTo();

        // validate vertical walls
        Wall wall = null;
        if (ma.getDirection() == Direction.EAST) {
            wall = state.getWallForCell(to.x, to.y);
        }
        else if (ma.getDirection() == Direction.WEST) {
            wall = state.getWallForCell(from.x, from.y);
        }

        if (wall != null && wall.isVertical()) {
            return false;
        }

        // validate horizontal walls
        if (ma.getDirection() == Direction.NORTH) {
            wall = state.getWallForCell(from.x,from.y);
        }
        else if (ma.getDirection() == Direction.SOUTH) {
            wall = state.getWallForCell(to.x, to.y);
        }

        if (wall != null && !wall.isVertical()) {
            return false;
        }

        return true;
    }
}
