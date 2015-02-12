import edu.da.codin.ai.mdp.abstracts.ActionNode;
import edu.da.codin.ai.mdp.abstracts.MarkovChain;
import edu.da.codin.ai.mdp.abstracts.StateActionPair;
import edu.da.codin.ai.mdp.abstracts.StateNode;
import org.junit.Test;

/**
 * Created by davida on 12.2.2015.
 */
public class TestMarkovGraph {

    @Test
    public void testMarkovSimulation() {
        /*double alpha = 0.75;
        double beta = 0.90;
        double rWait = 1;
        double rSearch = 3;
        double rRecharge = 0;

        StateNode highState = new StateNode("High");
        StateNode lowState = new StateNode("Low");

        ActionNode waitAction = new ActionNode("wait");
        ActionNode searchAction = new ActionNode("wait");
        ActionNode rechargeAction = new ActionNode("wait");

        highState.getActions().add(new StateActionPair(waitAction, highState,1, rWait));
        highState.getActions().add(new StateActionPair(searchAction, highState, alpha, rSearch));
        highState.getActions().add(new StateActionPair(searchAction, lowState, 1-alpha, rSearch));

        lowState.getActions().add(new StateActionPair(rechargeAction, highState, 1, rRecharge));
        lowState.getActions().add(new StateActionPair(searchAction, lowState, beta, rSearch));
        lowState.getActions().add(new StateActionPair(searchAction, highState,1 - beta, -rSearch));
        lowState.getActions().add(new StateActionPair(searchAction, lowState,1, rWait));


        MarkovChain grp = new MarkovChain(highState);

*/
    }
}
