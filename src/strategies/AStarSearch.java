package strategies;

public class AStarSearch implements Solver {

    int i;
    //Constructor
    public AStarSearch(int heuristic) {
        i = heuristic;
    }
    @Override
    public String solve(String initialState, Boolean visualize) {
        return "plan;pathCost;nodesExpanded";
    }

}
