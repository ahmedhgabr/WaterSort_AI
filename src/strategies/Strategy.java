package strategies;
import Game.Node;

import java.util.Collection;

public interface Strategy {

    void add(Node node);
    Node remove();

    boolean isEmpty();
}
