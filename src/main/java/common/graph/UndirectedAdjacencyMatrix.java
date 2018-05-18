package common.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class UndirectedAdjacencyMatrix implements Graph {

   public int[][] matrix;

   public UndirectedAdjacencyMatrix() {
      matrix = new int[0][0];
   }

   public void resize(int v) {
      v = v + 1; //to avoid conflict in start indices (0 or 1)
      matrix = new int[v][v];
   }

   public void addEdge(int x, int y, int weight) {
      matrix[x][y] = weight;
      matrix[y][x] = weight;
   }

   public int V() {
      return matrix[0].length - 1;
   }

   public int E() {
      int cnt = 0;
      for (int i = 0; i <= V(); i++) {
         for (int j = 0; j <= V(); j++) {
            if (matrix[i][j] >= 1) {
               cnt++;
            }
         }
      }
      return cnt / 2;
   }

   public Iterable<Edge> adj(int v) {
      ArrayList<Edge> res = new ArrayList<Edge>();
      for (int i = 0; i <= V(); i++) {
         if (matrix[v][i] >= 1) {
            Edge e = new Edge(v, i, matrix[v][i]);
            res.add(e);
         }
      }
      return res;
   }

   public PriorityQueue<Edge> edges() {
      PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
      for (int i = 0; i <= V(); i++) {
         for (int j = 0; j <= V(); j++) {
            if (matrix[i][j] >= 1) {
               Edge e = new Edge(i, j, matrix[i][j]);
               if (!edges.contains(e)) {
                  edges.add(e);
               }
            }
         }
      }
      return edges;
   }
}
