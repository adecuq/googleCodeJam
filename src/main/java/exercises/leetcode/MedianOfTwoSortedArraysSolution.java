package exercises.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArraysSolution {

   /**
    * The full solution can be found here: https://leetcode.com/submissions/detail/155236455/
    */
   public static double findMedian(int[] A, int[] B) {
      final int n = A.length;
      final int m = B.length;
      final int medianPosition = (n + m - 1) / 2;

      /*
        Find two elements of A as close as possible to desired medianPosition
       */
      int a1 = 0;
      int a2 = n - 1;
      int b1 = findPositionInB(B, A[a1]);
      int b2 = findPositionInB(B, A[a2]);
      int i, j;
      while (a1 + 1 < a2) {
         i = (a1 + a2) / 2;
         j = findPositionInB(B, A[i]);
         if (i + j > medianPosition) {
            a2 = i;
            b2 = j;
         } else {
            a1 = i;
            b1 = j;
         }
      }

      /*
        Compute the value depending on the case
       */
      if (a1 + b1 == medianPosition) {
         System.out.println("case 1");
         return (n + m) % 2 == 0 ? (A[a1] + Math.min(A[a2], B[b1])) / 2.0 : A[a1];
      } else if (a2 + b2 == medianPosition) {
         System.out.println("case 2");
         int nextA2 = a2 + 1 == n ? B[b2] : A[a2 + 1];
         return (n + m) % 2 == 0 ? (A[a2] + Math.min(nextA2, B[b2])) / 2.0 : A[a2];
      } else if (a2 + b2 > medianPosition) {
         if (a1 + b1 > medianPosition) {
            System.out.println("case 3");
            int nextBmed = medianPosition + 1 == m ? A[a1] : B[medianPosition + 1];
            return (n + m) % 2 == 0 ? (B[medianPosition] + Math.min(A[a1], nextBmed)) / 2.0 : B[medianPosition];
         } else {
            System.out.println("case 4");
            b1 += medianPosition - (a1 + b1 + 1);
            int nextB1 = b1 + 1 == m ? A[a2] : B[b1 + 1];
            return (n + m) % 2 == 0 ? (B[b1] + Math.min(A[a2], nextB1)) / 2.0 : Math.min(A[a2], B[b1]);
         }
      } else { //a2+b2 < medianPosition
         System.out.println("case 5");
         b2 += medianPosition - (a2 + b2 + 1);
         return (n + m) % 2 == 0 ? (B[b2] + B[b2 + 1]) / 2.0 : B[b2];
      }
   }

   private static int findPositionInB(int[] B, int a) {
      int j = Arrays.binarySearch(B, a);
      if (j < 0) {
         j = Math.abs(j + 1);
      }
      return j;
   }
}
