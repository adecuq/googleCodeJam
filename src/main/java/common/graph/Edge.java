package common.graph;

public class Edge implements Comparable<Edge> {
   private int first;
   private int second;
   private int weight;

   Edge(int v1, int v2, int weight) {
      this.first = v1;
      this.second = v2;
      this.weight = weight;
   }

   public int first() {
      return first;
   }

   public int second() {
      return second;
   }

   public int weight() {
      return weight;
   }

   public int other(int v) {
      return v == first ? second : first;
   }

   public int compareTo(Edge o) {
      if (o.equals(this)) {
         return 0;
      }
      return this.weight() < o.weight() ? -1 : 1;
   }

   @Override
   public boolean equals(Object other) {
      if (other == null) {
         return false;
      }

      if (!(other instanceof Edge)) {
         return false;
      }

      Edge o = (Edge) other;

      return (o.first() == first() && o.second() == second())
            || (o.first() == second() && o.second() == first())
            && o.weight() == weight;
   }
}
