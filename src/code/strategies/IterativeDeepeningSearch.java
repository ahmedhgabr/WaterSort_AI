package code.strategies;

import code.Game.Node;

import java.util.ArrayList;

public class IterativeDeepeningSearch implements Strategy {
    ArrayList<Node> queue;
    int n ;

    public IterativeDeepeningSearch( int n) {
        queue = new ArrayList<>();
        this.n = n;
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
