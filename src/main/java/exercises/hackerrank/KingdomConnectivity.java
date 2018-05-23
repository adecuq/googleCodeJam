package exercises.hackerrank;

import static java.util.AbstractMap.SimpleEntry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class KingdomConnectivity {
   private static boolean[] stack;
   private static List<Integer>[] graph;
   private static long[] mem;
   private static int N;
   private static boolean[] marked;
   private static boolean[] marked2;
   private static List<SimpleEntry<Integer,Integer>> EdgesToRemove;

   /*** Reachability in digraphs ***      time complexity = O(M) */
   private static void dfs(int i) {
      marked2[i] = true;
      for(Integer j: graph[i])
         if(!marked2[j]) dfs(j);
   }

   private static boolean isWarfareCapitalReachable(int prev, int i) {
      marked2 = new boolean[N+1];
      dfs(i);

      // remove unnecessary cycle if N not reachable
      if(!marked2[N])
         EdgesToRemove.add(new SimpleEntry<>(prev, i));

      return marked2[N];
   }

   /*** Finding a directed cycle ***      time complexity = O(M) */
   private static boolean hasCycleToReachN(int i, int prev) {
      if(i == N) return false;
      if(stack[i]) return isWarfareCapitalReachable(prev,i);
      if(marked[i]) return false;

      stack[i] = true;
      marked[i] = true;
      for(Integer j : graph[i]) {
         if(hasCycleToReachN(j,i))
            return true;
      }
      stack[i] = false;
      return false;
   }

   /*** Memoization ***      time complexity = O(M) */
   private static long depthFirstPathsToN(int i) {
      if(i==N) return 1;
      if(mem[i] > 0) return mem[i];
      if(mem[i] < 0) return -1;

      mem[i] = -1;
      long cnt = 0;
      for(Integer j : graph[i]) {
         long res = depthFirstPathsToN(j);
         if(res > 0)
            cnt += res;
      }

      if(cnt > 0)
         mem[i] = cnt %1000000000L;
      return mem[i];
   }

   private static void cleanUpCycle() {
      for(SimpleEntry<Integer,Integer> p : EdgesToRemove) {
         graph[p.getKey()].remove(p.getValue());
      }
   }

   public static void main(String[] args) {
      // Read input from STDIN.
      Scanner scan = new Scanner(System.in);
      N = scan.nextInt();
      final int m = scan.nextInt();
      graph = new ArrayList[N+1];   // adjacency list structure
      stack = new boolean[N+1];
      for(int i=0; i<=N; i++) {
         graph[i] = new ArrayList<>();
      }
      for(int i = 0; i< m; i++) {
         int from = scan.nextInt();
         int to = scan.nextInt();
         graph[from].add(to);
      }
      marked = new boolean[N+1];
      EdgesToRemove = new LinkedList<>();

      // Enter your code here. Print output to STDOUT.
      if(hasCycleToReachN(1,1))
         System.out.println("INFINITE PATHS");
      else {
         cleanUpCycle();
         mem = new long[N+1];
         System.out.println(depthFirstPathsToN(1));
      }
   }
}
