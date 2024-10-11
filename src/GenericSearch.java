import Game.Node;
import Game.State;
import strategies.Strategy;

import java.util.ArrayList;

public class GenericSearch {

    //Todo: GenericSearch, which has the generic implementation of a search problem (as defined in Lecture 2).

    ArrayList<Node> nodes = new ArrayList<Node>();
    public static String genericSolve(String initialState, Strategy strategy, Boolean visualize) {
        State state = new State(initialState);

        strategy.add(new Node(state, null, null, 0, 0));
        while (!strategy.isEmpty()) {
            Node node = strategy.remove();
            if (node.isGoal()) {
//                return "pour_0_3,pour_0_4,pour_1_3,pour_1_4,pour_0_1,pour_0_3,pour_2_4,pour_2_1,pour_2_3,pour_2_4;6;2";
                return node.getState().toString();
            }
            for (Node n : node.expand()) {
                strategy.add(n);
            }
        }

        return "NOSOLUTION";
    }




}
