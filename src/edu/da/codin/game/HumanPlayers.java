package edu.da.codin.game;

import edu.da.codin.ai.players.HumanPlayer;
import edu.da.codin.game.entities.PlayerStrategy;
import edu.da.codin.game.grid.Coord;

/**
 * Created by davida on 11.2.2015.
 */
public class HumanPlayers {

    public static void main(String[] args) {
        PlayerStrategy human = new HumanPlayer();
        PlayerStrategy human2 = new HumanPlayer();
        PlayerStrategy human3 = new HumanPlayer();

        Game game = new Game();

        game.addPlayer("1", new Coord(0,5), new Coord(8,5), human);
        game.addPlayer("2", new Coord(8,4), new Coord(0,4), human2);
        game.addPlayer("3", new Coord(5,0), new Coord(5,8), human3);

        game.play();
    }
}
