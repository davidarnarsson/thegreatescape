package edu.da.codin.ai.players;

import edu.da.codin.game.action.Action;
import edu.da.codin.game.entities.Player;
import edu.da.codin.game.entities.PlayerStrategy;
import edu.da.codin.game.grid.Coord;
import edu.da.codin.game.grid.GridState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by davida on 12.2.2015.
 */
public class HumanPlayer implements PlayerStrategy {
    private Player player;

    @Override
    public Action getAction(GridState state) {
        String input = "";
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        boolean outerAcceptable = false;
        Action action = null;
        do {
            try {
                input = reader.readLine();

                switch (input.replace(System.lineSeparator(), "")) {
                    case "left":
                        action = player.moveLeft();
                        break;
                    case "up":
                        action = player.moveUp();
                        break;
                    case "down":
                        action = player.moveDown();
                        break;
                    case "right":
                        action = player.moveRight();
                        break;
                    case "wall": {
                        boolean acceptable = false;
                        do {
                            System.out.println("Describe the wall: [h/v] [x] [y]");
                            String[] description = reader.readLine().split(" ");
                            if (description.length == 3) {
                                boolean vertical = !description[0].startsWith("h");

                                int x = Integer.parseInt(description[1]);
                                int y = Integer.parseInt(description[2]);
                                acceptable = true;
                                action = player.placeWall(new Coord(x, y), vertical);
                            }
                        } while (!acceptable);
                        break;
                    }
                    case "quit":
                        break;
                    default:
                        System.out.println(input + " is invalid as input, take one of (up, down, left, right, quit).");
                        continue;
                }
                break;
            } catch (IOException e) {
                System.out.println("Invalid input, please try again");
            }
        } while (!outerAcceptable);
        return action;
    }

    @Override
    public void playerLost(Player p) {

    }

    @Override
    public void playerWon(Player p) {

    }

    @Override
    public void setSelf(Player self) {
        this.player = self;
    }
}
