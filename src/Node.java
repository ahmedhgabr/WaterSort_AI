public class Node {

    //Todo: Node, which implements a search-tree node (as defined in Lecture 2).

    State state;
    Node parent;
    String operator;
    int depth;
    int pathCost;


    public Node(State state, Node parent, String operator, int depth, int pathCost) {
        this.state = state;
        this.parent = parent;
        this.operator = operator;
        this.depth = depth;
        this.pathCost = pathCost;
    }

    public State getState() {
        return state;
    }

    public int getNumberOfBottles() {
        return state.getNumberOfBottles();
    }

    public int getBottleCapacity() {
        return state.getBottleCapacity();
    }



    public Node getParent() {
        return parent;
    }

    public String getOperator() {
        return operator;
    }

    public int getDepth() {
        return depth;
    }

    public int getPathCost() {
        return pathCost;
    }



    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return depth == 0;
    }

    public boolean isGoal() {
        return state.isGoal();
    }


    public String[] path() {
        String[] path = new String[depth + 1];
        Node node = this;
        for (int i = depth; i >= 0; i--) {
            path[i] = node.operator + " " + node.state;
            node = node.parent;
        }
        return path;
    }

}
