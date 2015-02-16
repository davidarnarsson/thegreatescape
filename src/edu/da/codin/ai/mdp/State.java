package edu.da.codin.ai.mdp;

/**
 * Created by davida on 13.2.2015.
 */
public class State {

    private String name;
    private double reward;

    public State(String name, double reward) {
        this.name = name;
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public double getReward() {
        return reward;
    }
}
