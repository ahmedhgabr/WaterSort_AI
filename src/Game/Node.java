package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Node {

    //Todo: Game.Node, which implements a search-tree node (as defined in Lecture 2).

    State state;
    Node parent;
    String operator;
    int depth;
    int pathCost;

    int heuristic1;
    int heuristic2;

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

    public int getHeuristic1() {
        return heuristic1;
    }

    public int getHeuristic2() {
        return heuristic2;
    }


    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return depth != 0;
    }

    public boolean isGoal() {
        return state.isGoal();
    }


    public ArrayList<Node> expand(HashSet<String> visitedNodes) {
        ArrayList<Node> expandedNodes = new ArrayList<Node>();
        for (int i = 0; i < getNumberOfBottles(); i++) {
            for (int j = 0; j < getNumberOfBottles(); j++) {
                if (i != j) {
                    State newState = new State(getNumberOfBottles(), getBottleCapacity(), getState().getBottles());
                    Bottle bottle1 = newState.getBottle(i);
                    Bottle bottle2 = newState.getBottle(j);
                    if(bottle2.hasSpace() && !bottle1.isEmpty()
                            && (bottle1.getTopColor()==bottle2.getTopColor() || bottle2.isEmpty())){
                        //Pour from bottle i to bottle j
                        int pourA = newState.pour(i,j);
                        if(!visitedNodes.contains((newState.toString()))){
                            Node newNode = new Node(newState, this, "pour_" + i + "_" + j, getDepth() + 1, getPathCost() + pourA);
                            expandedNodes.add(newNode);
                            visitedNodes.add(newState.toString());
                        }
                    }
                }
            }
        }
        return expandedNodes;
    }

    public String getPlan() {
        Node node = this;
        String plan = operator;
        for (int i = depth; i > 1; i--) {
            node = node.parent;
            plan = node.operator + "," + plan;
        }
        return plan;
    }


    public String pathToString() {
        Node node = this;
        String path = state.toString();
        for (int i = depth; i > 0; i--) {
            node = node.parent;
            path = node.state.toString() + "\n" + path;
        }
        return path;
    }

    public String toString(){
        return "[" + depth + " , " + pathCost +"]";
    }



    public void setHeuristic1() {
        // the total of changes in color in each bottle
        int h = 0;
        for (int i = 0; i < getNumberOfBottles(); i++) {
            Bottle bottle = getState().getBottle(i);
//            if (bottle.isEmpty()){
//                h++;
//                continue;
//            }
            for (int j = 0; j < getBottleCapacity()-1; j++) {
                if ( bottle.getColors()[j] != 'e' && bottle.getColors()[j] != bottle.getColors()[j+1] ) {
                    h++;
                }
            }
        }
        this.heuristic1 = h;
    }


    public void setHeuristic2() {
        // the number of unresolved bottles
        int h = 0;
        for (int i = 0; i < getNumberOfBottles(); i++) {
            if (!state.getBottle(i).isSorted()) {
                h++;
            }
        }
        this.heuristic2 = h;
    }

}
