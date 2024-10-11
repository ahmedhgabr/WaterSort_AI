package strategies;
import Game.Node;

import java.util.Collection;

public interface Strategy {

    public void add(Node node);
    public Node remove();

    public boolean isEmpty();
}
