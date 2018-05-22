package Exercises.leetcode;

import static exercises.leetcode.MedianOfTwoSortedArrays.findMedian;
import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

   /**
    * 4 even cases
    */

   @Test
   public void it_should_find_median_when_both_arrays_have_length_of_2_case4() {
      int[] A = { 2, 4 };
      int[] B = { 1, 3 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(2.5);
   }

   @Test
   public void it_should_find_median_when_both_arrays_have_length_of_2_case6() {
      int[] A = { 2, 3 };
      int[] B = { 1, 4 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(2.5);
   }

   @Test
   public void it_should_find_median_when_both_arrays_have_length_of_2_case3() {
      int[] A = { 3, 4 };
      int[] B = { 1, 2 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(2.5);
   }

   @Test
   public void it_should_find_median_when_both_arrays_have_length_of_2_case2() {
      int[] A = { 1, 2 };
      int[] B = { 3, 4 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(2.5);
   }

   /**
    * 5 odd cases
    */

   @Test
   public void it_should_find_median_when_one_array_have_length_of_3_case1() {
      int[] A = { 2, 4 };
      int[] B = { 1, 3, 5 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(3.0);
   }

   @Test
   public void it_should_find_median_when_one_array_have_length_of_3_case2() {
      int[] A = { 2, 3 };
      int[] B = { 1, 4, 5 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(3.0);
   }

   @Test
   public void it_should_find_median_when_one_array_have_length_of_3_case3() {
      int[] A = { 3, 4 };
      int[] B = { 1, 2, 5 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(3.0);
   }

   @Test
   public void it_should_find_median_when_one_array_have_length_of_3_case4() {
      int[] A = { 1, 2 };
      int[] B = { 3, 4, 5 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(3.0);
   }

   @Test
   public void it_should_find_median_when_one_array_have_length_of_3_case5() {
      int[] A = { 4, 5 };
      int[] B = { 1, 2, 3 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(3.0);
   }

   /**
    * Extra large cases
    */

   @Test
   public void it_should_find_median_when_complex_case1() {
      int[] A = { 2, 4, 6, 8 };
      int[] B = { 1, 3, 5, 7, 9 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(5.0);
   }

   @Test
   public void it_should_find_median_when_complex_case2() {
      int[] A = { 1, 4, 5, 6, 9, 15, 16, 17, 18 };
      int[] B = { 2, 3, 7, 8, 10, 11, 12, 13, 14 };
      Assertions.assertThat(findMedian(A, B)).isEqualTo(9.5);
   }
}