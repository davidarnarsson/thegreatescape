package edu.da.codin.ai.mdp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davida on 13.2.2015.
 */
public class MarkovDecisionProcess {

    private final List<State> states;
    private final List<Action> actions;
    private final List<StateActionPair> transitions;
    private final double discount;

    private Map<State, Map<Integer, Double>> memo = new HashMap<>();

    public MarkovDecisionProcess(List<State> states, List<Action> actions, double discount) {
        this.states = states;
        this.actions = actions;
        this.discount = discount;
        transitions = new ArrayList<>();
    }

    public MarkovDecisionProcess transition(State fromState, State toState, Action action, double probability) {
        transitions.add(new StateActionPair(fromState, toState, action,probability));
        return this;
    }

    public double value(State state, int iteration) {
        assert iteration > 0;

        if (iteration == 1) {
            return state.getReward();
        }
        double sum =
            transitions.stream()
                       .filter(p -> p.getFromState() == state)
                       .mapToDouble(p -> p.getProbability() * value(p.getToState(), iteration - 1))
                       .sum();

        return state.getReward() + (discount * sum);
    }

    public double valueMemoized(State state, int iteration) {
        if (!memo.containsKey(state)) {
            memo.put(state, new HashMap<>());
        }

        Map<Integer, Double> iterations = memo.get(state);
        if(!iterations.containsKey(iteration)) {
            double v = value(state, iteration);
            iterations.put(iteration, v);
        }

        return iterations.get(iteration);
    }


}
