package common.graph;

import java.util.ArrayList;

public class UndirectedAdjacencyMatrix implements Graph {

   public int[][] matrix;

   UndirectedAdjacencyMatrix() {
      matrix = new int[0][0];
   }

   public void resize(int v) {
      v = v + 1; //to avoid conflict in start indices (0 or 1)
      matrix = new int[v][v];
   }

   public int V() {
      return matrix[0].length - 1;
   }

   public int E() {
      int cnt = 0;
      for(int i=0;i<=V();i++) {
         for(int j=0;j<=V();j++) {
            if(matrix[i][j]==1)
               cnt++;
         }
      }
      return cnt/2;
   }

   public void addEdge(int v, int w) {
      matrix[v][w] = 1;
      matrix[w][v] = 1;
   }

   public Iterable<Integer> adj(int v) {
      ArrayList<Integer> res = new ArrayList<Integer>();
      for(int i=0;i<=V();i++) {
         if(matrix[v][i] == 1) {
            res.add(i);
         }
      }
      return res;
   }
}
