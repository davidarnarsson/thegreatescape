package edu.da.codin.game.grid;

import edu.da.codin.game.entities.Entity;
import edu.da.codin.game.entities.Wall;

/**
 * Created by davida on 11.2.2015.
 */
public class ReadOnlyCell {

    private final Cell cell;

    public ReadOnlyCell(Cell c) {
        this.cell = c;
    }

    public Entity[] getContents() {
        return (Entity[]) cell.toArray();
    }

    public Wall getWall() {
        return cell.getWall();
    }

    public int size() {
        return this.cell.size();
    }
}
