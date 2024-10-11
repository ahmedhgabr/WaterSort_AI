package strategies;

import Game.Node;

import java.util.ArrayList;

public class IterativeDeepeningSearch implements Strategy {
    ArrayList<Node> queue;

    public IterativeDeepeningSearch() {
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
