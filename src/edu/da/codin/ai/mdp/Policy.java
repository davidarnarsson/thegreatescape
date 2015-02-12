package edu.da.codin.ai.mdp;

import edu.da.codin.game.action.Action;
import edu.da.codin.game.grid.GridState;

/**
 * Created by davida on 12.2.2015.
 */
public interface Policy {
    double evaluate(GridState state, Action action);
}
