package strategies;

import Game.Node;

import java.util.ArrayList;

public class GreedySearch implements Strategy {

    int i;
    ArrayList<Node> queue;


    //Constructor
    public GreedySearch(int heuristic) {
        queue = new ArrayList<>();
        i = heuristic;
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
