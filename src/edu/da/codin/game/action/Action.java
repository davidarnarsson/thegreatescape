package edu.da.codin.game.action;

import edu.da.codin.game.grid.Grid;
import edu.da.codin.game.entities.Player;

/**
 * Created by davida on 12.2.2015.
 */
public interface Action {
    public enum ActionType {
        Move,
        PlaceWall
    }

    public ActionType getActionType();

    public void apply(Grid g, Player p);

}
