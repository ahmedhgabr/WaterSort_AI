import java.util.ArrayList;

public class GenericSearch {

    //Todo: GenericSearch, which has the generic implementation of a search problem (as defined in Lecture 2).

    ArrayList<Node> nodes = new ArrayList<Node>();
    public String solve(String initialState, String strategy, Boolean visualize) {
        State state = new State(initialState);
        nodes.add(new Node(state, null, null, 0, 0));
        while (!nodes.isEmpty()) {
            Node node = nodes.remove(0);
            if (node.isGoal()) {
                return node.getPathCost() + "";
            }
            nodes.addAll(expand(node));
        }

        return "NOSOLUTION: You have entered an invalid strategy";
    }

    private ArrayList<Node> expand(Node node) {
        ArrayList<Node> expandedNodes = new ArrayList<Node>();
        for (int i = 0; i < node.getNumberOfBottles(); i++) {
            Bottle bottle1 = node.state.getBottle(i);
            for (int j = 0; j < node.getNumberOfBottles(); j++) {
                if (i != j ) {
                    Bottle bottle2 = node.state.getBottle(j);
                    if(node.state.getBottle(j).hasSpace() && !node.state.getBottle(i).isEmpty()
                    && (bottle1.getTopColor()==bottle2.getTopColor() || bottle2.isEmpty())){
                        //Pour from bottle i to bottle j
                        State newState = node.state.pour(i, j);
                        Node newNode = new Node(newState, node, "Pour from bottle " + i + " to bottle " + j, node.getDepth() + 1, node.getPathCost() + 1);
                        expandedNodes.add(newNode);
                    }
                }
            }
        }
        return expandedNodes;
    }


}
