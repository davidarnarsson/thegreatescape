package edu.da.codin.ai.mdp.abstracts;

/**
 * Created by davida on 12.2.2015.
 */
public class StateActionPair {

    private ActionNode action;
    private StateNode endState;
    private double probability;
    private double reward;

    public StateActionPair(ActionNode action, StateNode endState, double probability, double reward) {
        this.action = action;
        this.endState = endState;
        this.probability = probability;
        this.reward = reward;
    }

    public ActionNode getAction() {
        return action;
    }

    public StateNode getEndState() {
        return endState;
    }

    public double getProbability() {
        return probability;
    }

    public double getReward() {
        return reward;
    }
}
