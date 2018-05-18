package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import common.graph.Edge;
import common.graph.Graph;

public class Prim implements MinimumSpanningTree {
   private PriorityQueue<Edge> edges;
   private boolean[] marked;

   public Iterable<Edge> solve(Graph g) {
      edges = new PriorityQueue<Edge>();
      marked = new boolean[g.V() + 1];
      List<Edge> mst = new LinkedList<Edge>();

      visit(g,1);

      while (!edges.isEmpty()) {
         Edge e = edges.poll();
         if (marked[e.first()] && marked[e.second()]) continue;

         mst.add(e);
         if(!marked[e.first()]) visit(g,e.first());
         if(!marked[e.second()]) visit(g,e.second());
      }

      return mst;
   }

   private void visit(Graph g, int v) {
      marked[v] = true;
      for(Edge e : g.adj(v)) {
         if(!marked[e.other(v)])
            edges.add(e);
      }
   }
}
