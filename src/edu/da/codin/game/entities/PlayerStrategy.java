package edu.da.codin.game.entities;

import edu.da.codin.game.action.Action;
import edu.da.codin.game.grid.GridState;

/**
 * Created by davida on 12.2.2015.
 */
public interface PlayerStrategy {
    Action getAction(final GridState state);
    void playerLost(Player p);
    void playerWon(Player p);

    void setSelf(Player self);
}
