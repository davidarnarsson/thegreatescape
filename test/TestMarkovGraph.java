import edu.da.codin.ai.mdp.Action;
import edu.da.codin.ai.mdp.MarkovDecisionProcess;
import edu.da.codin.ai.mdp.State;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by davida on 12.2.2015.
 */
public class TestMarkovGraph {

    @Test
    public void testMarkovSunSimulation() {
        State sun = new State("sun",4);
        State wind = new State("wind", 0);
        State hail = new State("hail", -8);

        Action transition = new Action("transition");

        List<State> states = new ArrayList<>();
        states.add(sun);
        states.add(wind);
        states.add(hail);

        List<Action> actions = new ArrayList<>();
        actions.add(transition);
        MarkovDecisionProcess mdp = new MarkovDecisionProcess(states,actions, 0.5);

        mdp .transition(sun, sun, transition, 0.3)
            .transition(sun,    wind, transition, 0.6)
            .transition(wind,   sun,  transition, 0.4)
            .transition(wind,   hail, transition, 0.3)
            .transition(hail,   hail, transition, 0.7)
            .transition(hail,   wind, transition, 0.5);

        System.out.println(mdp.valueMemoized(wind, 5));
        System.out.println(mdp.valueMemoized(wind, 10));
        System.out.println(mdp.valueMemoized(wind, 20));
        System.out.println(mdp.valueMemoized(wind, 50));
        System.out.println(mdp.valueMemoized(wind, 500));
        System.out.println(mdp.valueMemoized(wind, 1000));
        /*assertEquals("1st iteration value of sun", 4, mdp.value(sun, 1), 0.1);
        assertEquals("2st iteration value of sun", 5, mdp.value(sun, 2), 0.1);
        assertEquals("5th iteration value of sun", 4.88, mdp.valueMemoized(sun, 50), 0.1);*/
    }

    @Test
    public void testMarkovCompanySimulation() {
        List<State> states = new ArrayList<>();
        List<Action> actions = new ArrayList<>();

        State pu = new State("Poor & Unknown",0);
        State ru = new State("Rich & Unknown",10);
        State pf = new State("Poor & Famous",0);
        State rf = new State("Rich & Famous",10);
        Collections.addAll(states, pu, ru, pf, rf);

        Action saving = new Action("saving");
        Action advertising = new Action("advertising");
        Collections.addAll(actions, saving, advertising);

        MarkovDecisionProcess mdp = new MarkovDecisionProcess(states, actions, 0.9);

        mdp.transition(pu,pu, saving, 1);
        mdp.transition(pu,pu, advertising, 0.5);
        mdp.transition(pu,pf, advertising, 0.5);

        mdp.transition(pf,pf, advertising, 1);
        mdp.transition(pf,rf, saving, 0.5);
        mdp.transition(pf,pu, saving, 0.5);

        mdp.transition(rf,pf, advertising, 1);
        mdp.transition(rf,rf, saving, 0.5);
        mdp.transition(rf,ru, saving, 0.5);

        mdp.transition(ru,ru, saving, 0.5);
        mdp.transition(ru,pu, saving, 0.5);
        mdp.transition(ru,pu, advertising, 0.5);
        mdp.transition(ru,pf, advertising, 0.5);

        System.out.println(mdp.value(pu, 15));
    }
}
