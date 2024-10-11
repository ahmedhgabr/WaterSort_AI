package Game;

import java.util.ArrayList;

public class Node {

    //Todo: Game.Node, which implements a search-tree node (as defined in Lecture 2).

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


    public ArrayList<Node> expand() {
        ArrayList<Node> expandedNodes = new ArrayList<Node>();
        for (int i = 0; i < getNumberOfBottles(); i++) {
            Bottle bottle1 = state.getBottle(i);
            for (int j = 0; j < getNumberOfBottles(); j++) {
                if (i != j ) {
                    Bottle bottle2 = state.getBottle(j);
                    if(state.getBottle(j).hasSpace() && !state.getBottle(i).isEmpty()
                            && (bottle1.getTopColor()==bottle2.getTopColor() || bottle2.isEmpty())){
                        //Pour from bottle i to bottle j
                        State newState = state.pour(i, j);
                        Node newNode = new Node(newState, this, "Pour from bottle " + i + " to bottle " + j, getDepth() + 1, getPathCost() + 1);
                        expandedNodes.add(newNode);
                    }
                }
            }
        }
        return expandedNodes;
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
