# Water Sort Puzzle Solver

This project implements a search agent to solve the Water Sort puzzle using various search algorithms. The puzzle involves sorting liquids of different colors into bottles, ensuring that each bottle contains only one color.

## Features

- **Search Algorithms:**
  - Breadth-First Search (BFS)
  - Depth-First Search (DFS)
  - Iterative Deepening Search (IDS)
  - Uniform Cost Search (UCS)
  - Greedy Search (two heuristics)
  - A* Search (two admissible heuristics)
- **Optimization Metrics:**
  - Minimized liquid transfer
  - Comparison of runtime, memory, and CPU utilization
- **Visualization:** Console-based step-by-step state display (optional).

## Input Format

The initial state is defined as:
```
<numberOfBottles>;<bottleCapacity>;<bottle0Layers>;<bottle1Layers>;...
```
Example:
```
5;4;b,y,r,b;b,y,r,r;y,r,b,y;e,e,e,e;e,e,e,e;
```

## Output Format

Results are returned as:
```
<plan>;<pathCost>;<nodesExpanded>
```
Example:
```
pour_0_3,pour_0_4,pour_1_3,pour_1_4,pour_0_1;10;7493
```

## How to Use

1. **Setup:**
   - Clone the repository.
   - Ensure you have Java installed.

2. **Run the Solver:**
   - Use the `solve` method with the initial state, search strategy, and visualization preference:
     ```java
     solve(initialState, strategy, visualize);
     ```
   - Strategies: `BF`, `DF`, `ID`, `UC`, `GR1`, `GR2`, `AS1`, `AS2`.

3. **Test Cases:**
   - Include your test cases in the `tests` package.

## Class Structure

- **GenericSearch:** Generic implementation of a search problem.
- **WaterSortSearch:** Problem-specific search logic.
- **Node:** Search tree node implementation.
