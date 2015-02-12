package edu.da.codin.ai.mdp;

import edu.da.codin.game.action.Action;
import edu.da.codin.game.grid.GridState;

/**
 * Created by davida on 12.2.2015.
 */
public class RandomPolicy implements Policy {
    @Override
    public double evaluate(GridState state, Action action) {
        return Math.random();
    }
}
