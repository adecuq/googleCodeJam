package algorithm;

import static algorithm.MstHelper.assertMST;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class PrimTest {

   private Prim prim;

   @Before
   public void setup() {
      prim = new Prim();
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph1() throws FileNotFoundException {
      assertMST("weightedGraph1", 4, prim);
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph2() throws FileNotFoundException {
      assertMST("weightedGraph2", 5, prim);
   }

   @Test
   public void it_should_compute_mst_correctly_for_graph3() throws FileNotFoundException {
      assertMST("weightedGraph3", 4, prim);
   }
}