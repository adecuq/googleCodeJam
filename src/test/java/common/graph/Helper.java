package common.graph;

import java.io.InputStream;
import java.util.Scanner;

public class Helper {
   static void populateGraph(InputStream in, Graph g) {
      Scanner scan = new Scanner(in);
      int v, e;
      v = scan.nextInt();
      e = scan.nextInt();

      g.resize(v);

      for (int i = 0; i < e; i++) {
         int from = scan.nextInt();
         int to = scan.nextInt();
         g.addEdge(from, to);
      }
   }
}
