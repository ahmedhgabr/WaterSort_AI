package strategies;

import Game.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UniformCostSearch implements Strategy {

    PriorityQueue<Node> priorityQueue;

    public UniformCostSearch() {
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.getPathCost()));
    }

    @Override
    public void add(Node node) {
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
