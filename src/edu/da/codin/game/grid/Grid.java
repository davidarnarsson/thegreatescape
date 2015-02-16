package edu.da.codin.game.grid;



import edu.da.codin.game.entities.Entity;
import edu.da.codin.game.entities.Player;
import edu.da.codin.game.movement.GridBoundsLimiter;

/**
 * Created by davida on 11.2.2015.
 */
public class Grid {

    public int getSize() {
        return size;
    }


    interface GridIterator<T> {
        void cell(int x, int y, Cell c);
    }

    private final int size;
    private final Cell[] grid;

    public Grid() {
        this.grid = new Cell[9 * 9];
        this.size = 9;

        for (int y = 0; y < this.size; ++y) {
            for (int x = 0; x < this.size; ++x) {
                this.grid[y * this.size + x] = new Cell();
            }
        }
    }

    private Cell getCell(int x, int y) {
        return grid[y * this.size + x];
    }

    private Cell getCell(Entity e) {
        return getCell(e.getCoordinates().x, e.getCoordinates().y);
    }

    private Cell getCell(Coord c) {
        return getCell(c.x, c.y);
    }

    public void addEntity(Entity e) {
        e.setGrid(this);
        getCell(e).add(e);
    }

    public void removeEntity(Entity e) {
        getCell(e).remove(e);
    }

    private void iterate(GridIterator it) {
        for (int y = 0; y < this.size; ++y) {
            for (int x = 0; x < this.size; ++x) {
                it.cell(x,y, getCell(x, y));
            }
        }
    }

    public void moveEntity(Entity e, Coord nc) {
        getCell(e).remove(e);
        getCell(nc).add(e);
        e.setCoordinates(nc);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        final int[] maxCellSize = {1};

        iterate((x, y, c) -> maxCellSize[0] = Math.max(maxCellSize[0], c.size() * 2 - 1));

        iterate((x, y, c) -> {
            if (x == 0) {
                builder.append("\n");
            }

            String cellContent = c.stream()
                    .map(Object::toString)
                    .reduce((acc,b) -> acc + "," + b)
                    .orElse("");

            if (maxCellSize[0] > 0) {
                cellContent = padLeft(cellContent, maxCellSize[0]);
            }

            builder.append(cellContent).append("|");
        });

        return builder.toString();
    }

    public GridState getGridStateForPlayer(Player p) {
        ReadOnlyCell[][] state = new ReadOnlyCell[this.size][this.size];

        for(int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                state[i][j] = new ReadOnlyCell(getCell(i,j));
            }
        }

        return new GridState(state);
    }

    private static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }
}
