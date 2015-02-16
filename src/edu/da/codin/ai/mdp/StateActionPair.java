package edu.da.codin.ai.mdp;

/**
 * Created by davida on 13.2.2015.
 */
public class StateActionPair {
    private State fromState;
    private State toState;
    private Action action;
    private double probability;

    public StateActionPair(State fromState, State toState, Action action, double probability) {
        this.fromState = fromState;
        this.toState = toState;
        this.action = action;
        this.probability = probability;
    }

    public State getToState() {
        return toState;
    }

    public State getFromState() {
        return fromState;
    }

    public Action getAction() {
        return action;
    }

    public double getProbability() {
        return probability;
    }
}
