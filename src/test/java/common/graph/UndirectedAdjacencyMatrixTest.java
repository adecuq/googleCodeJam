package common.graph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class UndirectedAdjacencyMatrixTest {

   private InputStream inputStream;

   @Before
   public void setUp() throws FileNotFoundException {
      File initialFile = new File("src/test/resources/local.in");
      inputStream = new FileInputStream(initialFile);
   }

   @Test
   public void
   V_should_return_the_number_of_vertices() {
      UndirectedAdjacencyMatrix matrix = new UndirectedAdjacencyMatrix();

      Helper.populateGraph(inputStream, matrix);

      Assertions.assertThat(matrix.V() == 3).isTrue();
   }

   @Test
   public void
   E_should_return_the_number_of_edges() {
      UndirectedAdjacencyMatrix matrix = new UndirectedAdjacencyMatrix();

      Helper.populateGraph(inputStream, matrix);

      Assertions.assertThat(matrix.E() == 2).isTrue();
   }

   @Test
   public void
   it_should_set_an_edge() {
      UndirectedAdjacencyMatrix matrix = new UndirectedAdjacencyMatrix();

      Helper.populateGraph(inputStream, matrix);

      Assertions.assertThat(matrix.matrix[1][2] == 1).isTrue();
   }

   @Test
   public void
   it_should_return_the_adjacent_vertex() {
      UndirectedAdjacencyMatrix matrix = new UndirectedAdjacencyMatrix();

      Helper.populateGraph(inputStream, matrix);

      Assertions.assertThat(matrix.adj(1).iterator().next()).isEqualTo(2);
   }
}
