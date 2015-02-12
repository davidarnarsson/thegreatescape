package edu.da.codin.game.action;

import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.grid.Grid;
import edu.da.codin.game.entities.Player;
import edu.da.codin.game.movement.Direction;

/**
 * Created by davida on 12.2.2015.
 */
public class MoveAction implements Action {

    private final Coord from;
    private final Coord to;
    private final Direction direction;

    public MoveAction(Coord from, Coord to, Direction d) {
        this.from = from;
        this.to = to;
        this.direction = d;
    }

    @Override
    public ActionType getActionType() {
        return ActionType.Move;
    }

    @Override
    public void apply(Grid g, Player p) {
        g.moveEntity(p,this.to);
    }

    public Coord getFrom() {
        return from;
    }

    public Coord getTo() {
        return to;
    }

    public Direction getDirection() {
        return direction;
    }
}
