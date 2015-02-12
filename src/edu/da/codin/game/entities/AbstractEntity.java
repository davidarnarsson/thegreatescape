package edu.da.codin.game.entities;

import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.grid.Grid;

/**
 * Created by davida on 11.2.2015.
 */
public abstract class AbstractEntity implements Entity {
    private Coord coordinates;
    private String marker;
    private Grid grid;

    @Override
    public void setCoordinates(Coord c) {
        this.coordinates = c;
    }

    Grid getGrid() {
        return this.grid;
    }

    @Override
    public void setGrid(Grid g) {
        this.grid = g;
    }

    @Override
    public Coord getCoordinates() {
        return this.coordinates;
    }

    @Override
    public abstract String getMarker();

    @Override
    public String toString() {
        return getMarker();
    }

}
