package strategies;

public class GreedySearch implements Solver {

    int i;

    //Constructor
    public GreedySearch(int heuristic) {
        i = heuristic;
    }


    public String solve(String initialState, Boolean visualize) {
        return "plan;pathCost;nodesExpanded";
    }

}
