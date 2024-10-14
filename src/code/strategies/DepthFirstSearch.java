package code.strategies;

import code.Game.Node;

import java.util.Stack;

public class DepthFirstSearch implements Strategy {
    Stack<Node> stack;

    //todo: check if input order in stack makes a difference

    //Constructor
    public DepthFirstSearch() {
        stack = new Stack<>();
    }

    @Override
    public void add(Node node) {
        stack.add(node);
    }

    @Override
    public Node remove() {
        return stack.pop();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
