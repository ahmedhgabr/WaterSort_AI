package strategies;

import Game.Node;

import java.util.Stack;

public class DepthLimitedSearch implements Strategy {

    int depth;
    Stack<Node> stack;

    //todo: check if input order in stack makes a difference

    //Constructor
    public DepthLimitedSearch() {
        stack = new Stack<>();
        this.depth = 0;
    }

    public void setDepth(int depth){
        this.depth = depth;
    }

    @Override
    public void add(Node node) {
        if(node.getDepth() <= depth){
            stack.add(node);
        }
    }

    @Override
    public Node remove() {
        return stack.pop();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
