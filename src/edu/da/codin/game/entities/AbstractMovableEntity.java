package edu.da.codin.game.entities;

import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.movement.Direction;
import edu.da.codin.game.action.Action;
import edu.da.codin.game.action.MoveAction;
import edu.da.codin.game.movement.MovementCalculator;

/**
 * Created by davida on 11.2.2015.
 */
public abstract class AbstractMovableEntity extends AbstractEntity {

    public Action moveLeft() {
     return makeMove(MovementCalculator.move(getCoordinates(), Direction.WEST), Direction.WEST);
    }

    public Action moveUp() {
        return makeMove(MovementCalculator.move(getCoordinates(), Direction.NORTH), Direction.NORTH);
    }

    public Action moveRight() {
        return makeMove(MovementCalculator.move(getCoordinates(), Direction.EAST), Direction.EAST);
    }

    public Action moveDown() {
        return makeMove(MovementCalculator.move(getCoordinates(), Direction.SOUTH), Direction.SOUTH);
    }

    private Action makeMove(Coord nc, Direction d) {
        return new MoveAction(this.getCoordinates(), nc, d);
    }
}
