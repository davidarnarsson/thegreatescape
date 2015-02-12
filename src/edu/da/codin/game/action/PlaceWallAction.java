package edu.da.codin.game.action;

import edu.da.codin.game.grid.Grid;
import edu.da.codin.game.entities.Player;
import edu.da.codin.game.entities.Wall;

/**
 * Created by davida on 12.2.2015.
 */
public class PlaceWallAction implements Action {

    private final Wall wall;

    public PlaceWallAction(Wall w) {
        this.wall = w;
    }
    
    public ActionType getActionType() {
        return ActionType.PlaceWall;
    }

    @Override
    public void apply(Grid g, Player p) {
        g.addEntity(wall);
        g.addEntity(wall.getAdjacentWall());
    }

    public final Wall getWall() {
        return wall;
    }
}
