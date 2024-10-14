package strategies;

import Game.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GreedySearch implements Strategy {

    int i;
    PriorityQueue<Node> priorityQueue;

    //Constructor
    public GreedySearch(int heuristic) {
        i = heuristic;
        if(i == 1){
            priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.getHeuristic1() ));
        } else {
            priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.getHeuristic2()));
        }
    }

    @Override
    public void add(Node node) {
        if (i == 1) {
            node.setHeuristic1();
        } else {
            node.setHeuristic2();
        }
        priorityQueue.add(node);
    }

    @Override
    public Node remove() {
        return priorityQueue.remove();
    }
    public boolean isEmpty(){
        return priorityQueue.isEmpty();
    }


}
