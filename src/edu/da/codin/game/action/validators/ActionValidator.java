package edu.da.codin.game.action.validators;

import edu.da.codin.game.grid.GridState;
import edu.da.codin.game.action.Action;
import edu.da.codin.game.entities.Player;

/**
 * Created by davida on 12.2.2015.
 */
public interface ActionValidator {
    public boolean validate(Player player, GridState state, Action action);
}
