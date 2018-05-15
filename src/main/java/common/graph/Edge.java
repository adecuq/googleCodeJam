package common.graph;

public class Edge implements Comparable<Edge> {
   private int vertex1;
   private int vertex2;
   private int weight;

   public Edge(int vertex1, int vertex2) {
      this.vertex1 = vertex1;
      this.vertex2 = vertex2;
      this.weight = 1;
   }

   Edge(int vertex1, int vertex2, int weigth) {
      this.vertex1 = vertex1;
      this.vertex2 = vertex2;
      this.weight = weigth;
   }

   public int first() {
      return vertex1;
   }

   public int second() {
      return vertex2;
   }

   public int weight() {
      return weight;
   }

   public int compareTo(Edge o) {
      if (o.equals(this)) {
         return 0;
      }
      return this.weight() < o.weight() ? -1 : 1;
   }

   @Override
   public boolean equals(Object other) {
      if (other == null) return false;

      if(!(other instanceof Edge)) return false;

      Edge o = (Edge)other;

      return (o.first() == first() && o.second() == second())
            || (o.first() == second() && o.second() == first())
            && o.weight() == weight;
   }
}
