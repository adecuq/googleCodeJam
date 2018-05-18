package common.graph;

import java.util.PriorityQueue;

public interface Graph {

   /*** Setter ***/

   void resize(int v);

   void addEdge(int x, int y, int weight);

   /*** Getter ***/

   /* number of vertices */
   int V();

   /* number of edges */
   int E();

   Iterable<Edge> adj(int v);

   PriorityQueue<Edge> edges();

   String toString();
}
