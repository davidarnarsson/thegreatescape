package edu.da.codin.ai.mdp.abstracts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davida on 12.2.2015.
 */
public abstract class StateNode {
    private String stateName;
    private List<StateActionPair> actions = new ArrayList<>();

    public StateNode(String stateName) {
        this.stateName = stateName;
    }

    public List<StateActionPair> getActions() {
        return actions;
    }

    public String getStateName() {
        return stateName;
    }
}
