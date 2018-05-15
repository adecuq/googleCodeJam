package algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import common.graph.Edge;
import common.graph.Graph;

public class MinimunSpanningTree {

   public static Iterable<Edge> solve(Graph g) {
      PriorityQueue<Edge> edges = g.edges();
      boolean[] marked = new boolean[g.V() + 1];
      List<Edge> mst = new LinkedList<Edge>();

      while (!edges.isEmpty()) {
         Edge e = edges.poll();
         if (!marked[e.first()] || !marked[e.second()]) {
            mst.add(e);
            marked[e.first()] = true;
            marked[e.second()] = true;
         }
      }

      return mst;
   }
}
