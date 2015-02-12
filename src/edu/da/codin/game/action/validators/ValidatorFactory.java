package edu.da.codin.game.action.validators;

import edu.da.codin.game.action.Action;
import edu.da.codin.game.action.MoveAction;
import edu.da.codin.game.action.PlaceWallAction;

/**
 * Created by davida on 12.2.2015.
 */
public class ValidatorFactory {

    public static ActionValidator getValidator(Action a) {
        if (a instanceof MoveAction) {
            return new MoveActionValidator();
        }

        if (a instanceof PlaceWallAction) {
            return new PlaceWallActionValidator();
        }

        throw new IllegalArgumentException("Unknown action type!");
    }
}

