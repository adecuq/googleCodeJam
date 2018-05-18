package algorithm;

import common.graph.Edge;
import common.graph.Graph;

public interface MinimumSpanningTree {

   /** Graph can be 0 or 1-indexed **/
   Iterable<Edge> solve(Graph g);

}

