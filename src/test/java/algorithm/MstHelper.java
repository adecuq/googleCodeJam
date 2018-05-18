package algorithm;

import static common.graph.Helper.populateWeigthedGraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.assertj.core.api.Assertions;

import common.graph.Edge;
import common.graph.UndirectedAdjacencyMatrix;

class MstHelper {

   static void assertMST(String fileName, int expectedWeight, MinimumSpanningTree mst) throws FileNotFoundException {
      File initialFile = new File("src/test/resources/" + fileName);
      InputStream inputStream = new FileInputStream(initialFile);
      UndirectedAdjacencyMatrix graph = new UndirectedAdjacencyMatrix();

      populateWeigthedGraph(inputStream, graph);

      Iterable<Edge> edges = mst.solve(graph);

      int mstWeight = 0;
      for (Edge edge : edges) {
         mstWeight += edge.weight();
      }

      Assertions.assertThat(mstWeight).isEqualTo(expectedWeight);
   }
}
