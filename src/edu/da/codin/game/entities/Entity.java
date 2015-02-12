package edu.da.codin.game.entities;

import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.grid.Grid;

/**
 * Created by davida on 11.2.2015.
 */
public interface Entity {
    Coord getCoordinates();
    void setCoordinates(Coord c);
    void setGrid(Grid g);

    String getMarker();
}
