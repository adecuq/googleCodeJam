package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

import common.graph.Edge;
import common.graph.Graph;

public class Kruskal implements MinimumSpanningTree {

   public Iterable<Edge> solve(Graph g) {
      List<Edge> mst = new LinkedList<Edge>();
      PriorityQueue<Edge> pq = g.edges();
      UnionFind UN = new UnionFind(g.V());

      while (!pq.isEmpty() && mst.size() < g.V() - 1) {
         Edge e = pq.poll();

         int x = UN.find(e.first());
         int y = UN.find(e.second());

         if (!UN.isConnected(x, y)) {
            UN.union(x, y);
            mst.add(e);
         }
      }

      return mst;
   }

   private class UnionFind {
      List<TreeSet<Integer>> subsets;

      UnionFind(int v) {
         subsets = new LinkedList<TreeSet<Integer>>();

         for (int i = 0; i <= v; i++) {
            TreeSet<Integer> bst = new TreeSet<Integer>();
            bst.add(i);
            subsets.add(bst);
         }
      }

      int find(int v) {
         int cnt = 0;
         for (TreeSet<Integer> s : subsets) {
            if (s.contains(v)) {
               return cnt;
            }
            cnt++;
         }
         throw new RuntimeException("Error in find algorithm");
      }

      void union(int x, int y) {
         subsets.get(x).addAll(subsets.get(y));
         subsets.remove(y);
      }

      boolean isConnected(int x, int y) {
         return x == y;
      }
   }
}
