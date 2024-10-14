package code.strategies;
import code.Game.Node;

public interface Strategy {

    void add(Node node);
    Node remove();

    boolean isEmpty();
}
