package algorithm;

import static common.graph.Helper.populateWeigthedGraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import common.graph.Edge;
import common.graph.UndirectedAdjacencyMatrix;

public class MinimunSpanningTreeTest {

   @Test
   public void it_should_compute_mst_correctly() throws FileNotFoundException {
      assertMST("weightedGraph1", 4);

      assertMST("weightedGraph2", 5);
   }

   private void assertMST(String fileName, int expectedWeight) throws FileNotFoundException {
      File initialFile = new File("src/test/resources/" + fileName);
      InputStream inputStream = new FileInputStream(initialFile);
      UndirectedAdjacencyMatrix graph = new UndirectedAdjacencyMatrix();

      populateWeigthedGraph(inputStream, graph);

      Iterable<Edge> edges = MinimunSpanningTree.solve(graph);
      int mstWeight = 0;
      for (Edge edge : edges) {
         mstWeight += edge.weight();
      }

      Assertions.assertThat(mstWeight).isEqualTo(expectedWeight);
   }
}