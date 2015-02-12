package edu.da.codin.game.grid;

import edu.da.codin.game.entities.Entity;
import edu.da.codin.game.entities.Wall;

import java.util.ArrayList;

/**
 * Created by davida on 11.2.2015.
 */
class Cell extends ArrayList<Entity> {

    public Wall getWall() {
        return (Wall)this.stream().filter(x -> x instanceof Wall).findFirst().orElse(null);
    }
}
