package algorithm;

import static algorithm.MstHelper.assertMST;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class KruskalTest {

   private Kruskal kruskal;

   @Before
   public void setup() {
      kruskal = new Kruskal();
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph1() throws FileNotFoundException {
      assertMST("weightedGraph1", 4, kruskal);
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph2() throws FileNotFoundException {
      assertMST("weightedGraph2", 5, kruskal);
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph3() throws FileNotFoundException {
      assertMST("weightedGraph3", 4, kruskal);
   }
}