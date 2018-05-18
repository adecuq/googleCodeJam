package algorithm;

import static common.graph.Helper.populateWeigthedGraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import common.graph.Edge;
import common.graph.UndirectedAdjacencyMatrix;

public class PrimTest {

   private Prim prim;

   @Before
   public void setup() {
      prim = new Prim();
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph1() throws FileNotFoundException {
      assertMST("weightedGraph1", 4);
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph2() throws FileNotFoundException {
      assertMST("weightedGraph2", 5);
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph3() throws FileNotFoundException {
      assertMST("weightedGraph3", 4);
   }

   private void assertMST(String fileName, int expectedWeight) throws FileNotFoundException {
      File initialFile = new File("src/test/resources/" + fileName);
      InputStream inputStream = new FileInputStream(initialFile);
      UndirectedAdjacencyMatrix graph = new UndirectedAdjacencyMatrix();

      populateWeigthedGraph(inputStream, graph);

      Iterable<Edge> edges = prim.solve(graph);

      int mstWeight = 0;
      for (Edge edge : edges) {
         mstWeight += edge.weight();
      }

      Assertions.assertThat(mstWeight).isEqualTo(expectedWeight);
   }
}