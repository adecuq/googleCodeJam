package common.graph;

public interface Graph {

   void resize(int v);

   /* Number of vertices */
   int V();

   /* Number of edges */
   int E();

   /* Add edge v-w to this graph */
   void addEdge(int v, int w);

   /* vertices adjacent to v  */
   Iterable<Integer> adj(int v);

   /* String representation */
   String toString();
}
