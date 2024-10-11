package strategies;

import Game.Node;

import java.util.ArrayList;

public class AStarSearch implements Strategy {

    int i;
    ArrayList<Node> queue;
    //Constructor

    public AStarSearch(int heuristic) {
        i = heuristic;
        queue = new ArrayList<>();
    }
    @Override
    public void add(Node node) {
        queue.add(node);
    }

    @Override
    public Node remove() {
        return queue.removeFirst();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
