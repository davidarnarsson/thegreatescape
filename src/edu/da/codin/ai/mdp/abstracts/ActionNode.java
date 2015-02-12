package edu.da.codin.ai.mdp.abstracts;

/**
 * Created by davida on 12.2.2015.
 */
public abstract class ActionNode {
    private String actionName;

    public ActionNode(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }
}
