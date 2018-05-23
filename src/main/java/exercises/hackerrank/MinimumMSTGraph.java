package exercises.hackerrank;

import java.util.Scanner;

public class MinimumMSTGraph {
   private static final Scanner scanner = new Scanner(System.in);

   private static long averageStrategy(long edgesWithAvgCost, long edgesWithHigherCost, long n, long s) {
      long avgCost = s / (n - 1);
      long remaining = s % (n - 1);

      if (remaining == 0) {
         return (edgesWithAvgCost + edgesWithHigherCost) * avgCost;
      } else {
         long cost1 = edgesWithAvgCost * avgCost + edgesWithHigherCost * (avgCost + remaining);

         long maxEdgesToSecondLastVertex = n - 3;
         long verticesToPromote = remaining - 1;
         long edgesToPromote = binomialCoefficientTwo(maxEdgesToSecondLastVertex) - binomialCoefficientTwo(maxEdgesToSecondLastVertex - verticesToPromote);
         edgesWithAvgCost -= edgesToPromote;
         edgesWithHigherCost += edgesToPromote;

         long cost2 = edgesWithAvgCost * avgCost + edgesWithHigherCost * (avgCost + 1);

         return Math.min(cost1, cost2);
      }
   }

   private static long highestStrategy(long numberOfEdgesOnOtherVertex, long numberOfEdgesOnLastVertex, long highestCost) {
      return numberOfEdgesOnOtherVertex * 1 + numberOfEdgesOnLastVertex * highestCost;
   }

   public static void main(String[] args) {
      int g = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int gItr = 0; gItr < g; gItr++) {
         String[] nms = scanner.nextLine().split(" ");
         long n = Long.parseLong(nms[0]);
         long m = Long.parseLong(nms[1]);
         long s = Long.parseLong(nms[2]);

         long edgesToLastVertex = getNumberOfExtraEdgesOnLastVertex(n, m);
         long mstEdges = n - 1;
         long edgesToOtherVertices = m - mstEdges - edgesToLastVertex;

         long cost1 = averageStrategy(edgesToOtherVertices, edgesToLastVertex, n, s);

         long highestCost = s - (mstEdges - 1);

         long cost2 = highestStrategy(edgesToOtherVertices, edgesToLastVertex, highestCost);

         System.out.println(Math.min(cost1, cost2) + s);
      }
      scanner.close();
   }

   private static long getNumberOfExtraEdgesOnLastVertex(long n, long m) {
      long notTakenEdges = binomialCoefficientTwo(n - 1) - m;
      return notTakenEdges > n - 2 ? 0 : (n - 2) - notTakenEdges;
   }

   private static long binomialCoefficientTwo(long n) {
      return n * (n + 1) / 2;
   }
}
