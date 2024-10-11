package strategies;

import Game.Node;

import java.util.ArrayList;
import java.util.Queue;

public class BreadthFirstSearch implements Strategy {

    ArrayList<Node> queue;

    public BreadthFirstSearch() {
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
