package edu.da.codin.game.entities;

import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.action.PlaceWallAction;

/**
 * Created by davida on 11.2.2015.
 */
public class Player extends AbstractMovableEntity {

    private final String marker;
    private final PlayerStrategy action;
    private int wallCount;

    public Player(String marker, PlayerStrategy action) {
        this.marker = marker;
        this.action = action;

        /*TODO: IF you refactor that other thing, this shit won't be needed. */
        this.action.setSelf(this);
    }
    @Override
    public String getMarker() {
        return marker;
    }

    public PlaceWallAction placeWall(Coord c, boolean vertical) {
        return new PlaceWallAction(createWall(vertical, c));
    }

    private Wall createWall(boolean vertical, Coord c) {
        Wall wall = new Wall(this, vertical);
        wall.setCoordinates(c);
        return wall;
    }

    public void incrementWallCount() {
        wallCount++;
    }

    public void decrementWallCount() {
        wallCount--;
    }

    public int getWallCount() {
        return wallCount;
    }

    public PlayerStrategy getStrategy() {
        return action;
    }
}
