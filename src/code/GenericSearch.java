package code;

import Game.Node;
import Game.State;
import strategies.Strategy;

import java.util.ArrayList;
import java.util.HashSet;

public class GenericSearch {

    //Todo: code.GenericSearch, which has the generic implementation of a search problem (as defined in Lecture 2).

    ArrayList<Node> nodes = new ArrayList<Node>();

    public static String genericSolve(String initialState, Strategy strategy, Boolean visualize) {
        int nodesExpanded = 0;
        HashSet<String> visitedNodes = new HashSet<>(); //"bottles" array content stored as String
        State state = new State(initialState);

        strategy.add(new Node(state, null, "", 0, 0));
        while (!strategy.isEmpty()) {
            Node node = strategy.remove();
            if(visualize){
                System.out.println(node.getState());
            }
            if (node.isGoal()) {
                return node.getPlan() + ";" + node.getPathCost() + ";" + nodesExpanded;
            }
            for (Node n : node.expand(visitedNodes)) {
                strategy.add(n);
            }
            nodesExpanded++;
        }
        return "NOSOLUTION";
    }




}
