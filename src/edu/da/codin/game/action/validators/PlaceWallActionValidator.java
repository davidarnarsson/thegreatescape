package edu.da.codin.game.action.validators;

import edu.da.codin.game.action.PlaceWallAction;
import edu.da.codin.game.entities.Wall;
import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.grid.GridState;
import edu.da.codin.game.action.Action;
import edu.da.codin.game.entities.Player;

/**
 * Created by davida on 12.2.2015.
 *
 * Wall placement:
 * The player must indicate the cell on which he/she places a wall on its top left corner,
 * as well as the wall orientation (horizontal or vertical).
 *
 * A wall is two cells long.
 *
 * Walls cannot cross. If a player tries to put a wall atop another wall, he/she loses the game.
 *
 * But it is still possible to put a vertical wall in between two horizontal walls (--|--).
 *
 * A wall may not be placed if it cuts off the only remaining path of any player
 * to the side of the board it must reach.
 *
 * Walls may only be used to slow down an opponent's progress across the board.
 *
 * Each player may place a limited amount of walls: 10 each in a 2 player match and 6 each in a 3 player match.
 */
public class PlaceWallActionValidator implements ActionValidator {
    @Override
    public boolean validate(Player player, GridState state, Action action) {
        PlaceWallAction pwa = (PlaceWallAction) action;

        final Wall w = pwa.getWall();
        final Wall adjacentWall = w.getAdjacentWall();

        Coord wallPosition = w.getCoordinates();
        Coord adjPosition = adjacentWall.getCoordinates();

        // check crossing
        if (w.isVertical()) {
            Wall crossingWall = state.getWallForCell(wallPosition.x-1,wallPosition.y+1);
            if (crossingWall != null && !crossingWall.isAdjacent()) {
                return false;
            }

            // check area blocking off
            boolean onlyWalls = true;
            for(int x = 0; x < state.getState().length; ++x) {
                if (x == wallPosition.x || x == adjPosition.x) continue;

                onlyWalls &= state.getWallForCell(x, wallPosition.y) != null;
            }

            if (onlyWalls) {
                return false;
            }

        } else {
            Wall crossingWall = state.getWallForCell(wallPosition.x+1,wallPosition.y-1);
            if (crossingWall != null && !crossingWall.isAdjacent()) {
                return false;
            }

            // check area blocking off horizontally

            // check area blocking off
            boolean onlyWalls = true;
            for(int y = 0; y < state.getState().length; ++y) {
                if (y == wallPosition.y || y == adjPosition.y) continue;

                onlyWalls &= state.getWallForCell(wallPosition.x, y) != null;
            }

            if (onlyWalls) {
                return false;
            }
        }

        // check if intersecting
        Wall intersecting1 = state.getWallForCell(wallPosition.x, wallPosition.y);
        if (intersecting1 != null && intersecting1.isVertical() == w.isVertical()) {
            return false;
        }

        // intersecting adjacent wall
        Wall intersecting2 = state.getWallForCell(adjPosition.x, adjPosition.y);
        if( intersecting2 != null && intersecting2.isVertical() == w.isVertical()) {
            return false;
        }

        return true;
    }
}
