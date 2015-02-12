package edu.da.codin.game.entities;

import edu.da.codin.game.grid.Coord;

/**
 * Created by davida on 11.2.2015.
 */
public class Wall extends AbstractEntity {

    private final boolean vertical;
    private final Player player;
    private final boolean isAdjacent;

    public Wall(Player belongsTo, boolean vertical) {
        this.vertical = vertical;
        this.player = belongsTo;
        this.isAdjacent = false;
    }

    private Wall(Player belongsTo, boolean vertical, boolean isAdjacent) {
        this.vertical = vertical;
        this.player = belongsTo;
        this.isAdjacent = isAdjacent;
    }

    @Override
    public String getMarker() {
        return vertical ? "[" : "¯";
    }

    public Wall getAdjacentWall() {
        Wall adjacent = new Wall(this.player, this.vertical, true);
        Coord c = new Coord();
        c.x = vertical ? this.getCoordinates().x : this.getCoordinates().x + 1;
        c.y = vertical ? this.getCoordinates().y + 1 : this.getCoordinates().y;
        adjacent.setCoordinates(c);
        return adjacent;
    }

    public boolean isVertical() {
        return vertical;
    }

    public boolean isAdjacent() {
        return isAdjacent;
    }
}
