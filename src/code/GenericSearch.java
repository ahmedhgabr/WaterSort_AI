package code;

import code.Game.Node;
import code.Game.State;
import code.strategies.Strategy;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

import java.util.ArrayList;
import java.util.HashSet;

public class GenericSearch {

    //Todo: code.GenericSearch, which has the generic implementation of a search problem (as defined in Lecture 2).

    ArrayList<Node> nodes = new ArrayList<Node>();

    public static String genericSolve(String initialState, Strategy strategy, Boolean visualize) {
        int nodesExpanded = 0;
        HashSet<String> visitedNodes = new HashSet<>(); //"bottles" array content stored as String
        State state = new State(initialState);
        // Get the OperatingSystemMXBean instance
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        strategy.add(new Node(state, null, "", 0, 0));
        while (!strategy.isEmpty()) {
            Node node = strategy.remove();
            if(visualize){
                System.out.println(node.getState());
            }
            if (node.isGoal()) {
                if(visualize) {
                    System.out.println("Strategy: " + strategy.getClass().getSimpleName());
                    System.out.println("Memeroy used in Megabytes=" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1000 * 1000) + "M");
                    //print CPU usage here
                    System.out.println("Max CPU utilization=" + osBean.getProcessCpuLoad() * 100 + "%");
                }
                return node.getPlan() + ";" + node.getPathCost() + ";" + nodesExpanded;
            }
            for (Node n : node.expand(visitedNodes)) {
                strategy.add(n);
            }
            nodesExpanded++;
        }
        return "NOSOLUTION";
    }




}
