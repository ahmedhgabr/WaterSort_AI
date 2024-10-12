package code;

import strategies.*;

public class WaterSortSearch extends GenericSearch {

    //Todo:code.WaterSortSearch, which extends code.GenericSearch, implementing the “Water Sort” search problem.



    public static void main(String[] args) {

        String grid0 = "3;" +
                "4;" +
                "r,y,r,y;" +
                "y,r,y,r;" +
                "e,e,e,e;";
        String grid1 = "5;" +
                "4;" +
                "b,y,r,b;" +
                "b,y,r,r;" +
                "y,r,b,y;" +
                "e,e,e,e;" +
                "e,e,e,e;";
        String grid2 = "5;" +
                "4;" +
                "b,r,o,b;" +
                "b,r,o,o;" +
                "r,o,b,r;" +
                "e,e,e,e;" +
                "e,e,e,e;";
        String grid3 = "6;" +
                "4;" +
                "g,g,g,r;" +
                "g,y,r,o;" +
                "o,r,o,y;" +
                "y,o,y,b;" +
                "r,b,b,b;" +
                "e,e,e,e;";
        String grid4 = "6;" +
                "3;" +
                "r,r,y;" +
                "b,y,r;" +
                "y,b,g;" +
                "g,g,b;" +
                "e,e,e;" +
                "e,e,e;";
        System.out.println(code.WaterSortSearch.solve(grid1, "BF" , true));
//       System.out.println(code.WaterSortSearch.solve(grid1, "DF" , true));
//        System.out.println(code.WaterSortSearch.solve("3;4;b,b,b,r;e,e,e,e;r,r,r,b;", "ID" , true));
//        System.out.println(code.WaterSortSearch.solve("3;4;b,b,b,r;e,e,e,e;r,r,r,b;", "UC" , true));
//        System.out.println(code.WaterSortSearch.solve("3;4;b,b,b,r;e,e,e,e;r,r,r,b;", "GR1" , true));
//        System.out.println(code.WaterSortSearch.solve("3;4;b,b,b,r;e,e,e,e;r,r,r,b;", "GR2" , true));
//        System.out.println(code.WaterSortSearch.solve("3;4;b,b,b,r;e,e,e,e;r,r,r,b;", "AS1" , true));
//        System.out.println(code.WaterSortSearch.solve("3;4;b,b,b,r;e,e,e,e;r,r,r,b;", "AS2" , true));
    }

    /**
     * solve is a method that solves the “Water Sort” search problem.
     * @param initialState initialState a provided string that defines the parameters of the instance of
     *  the problem. It gives the initial content of each bottle. It is a string provided
     *  in the following format:
     *  numberOfBottles;bottleCapacity;color0,1, color0,2, ...color0,k;color1,1, color1,2, ...color1,k;
     * @param strategy  strategy is a string indicating the search strategy to be applied:
     *  ∗ BF for breadth-first search,
     *  ∗ DF for depth-first search,
     *  ∗ ID for iterative deepening search,
     *  ∗ UC for uniform cost search,
     *  ∗ GRi for greedy search, with i ∈ {1,2} distinguishing the two heuristics.
     *  ∗ ASi for A∗ search with i ∈ {1,2} distinguishing the two heuristics.
     * @param visualize  is a Boolean parameter which, when set to true, results in your
     *  program’s side-effecting displaying the state information as it undergoes the
     *  different steps of the discovered solution (if one was discovered). A GUI is not
     *  required, printing to the console would suffice. The main value of this part is
     *  to help you debug and understand.
     * @return a String of 3 elements, in the following format:
     *  plan;pathCost;nodesExpanded
     *  If there is no possible solution, the string ’NOSOLUTION’ should be returned.
     */
    public static String solve(String initialState,String strategy,Boolean visualize){

        Strategy solver = null;
        switch(strategy) {
            case "BF":
                solver = new BreadthFirstSearch();
                 break;
            case "DF":
                solver = new DepthFirstSearch();
                break;
            case "ID":
                solver = new IterativeDeepeningSearch();
                break;
            case "UC":
                solver = new UniformCostSearch();
                break;
            case "GR1":
                solver = new GreedySearch(1);
                break;
            case "GR2":
                solver = new GreedySearch(2);
                break;
            case "AS1":
                solver = new AStarSearch(1);
                break;
            case "AS2":
                solver = new AStarSearch(2);
                break;
            default:
                return strategy +" is an invalid strategy";
        }
        return genericSolve(initialState, solver, visualize);
    }




}