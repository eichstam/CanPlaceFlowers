/**
 * 
605. Can Place Flowers

Suppose you have a long flowerbed in which some of the plots are planted
and some are not. However, flowers cannot be planted in adjacent
plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0
means empty and 1 means not empty), and a number n, return if n new
flowers can be planted in it without violating the no-adjacent-flowers
rule.

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: True

Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: False

Note:

    The input array won't violate no-adjacent-flowers rule.
    The input array size is in the range of [1, 20000].
    n is a non-negative integer which won't exceed the input array size.
 */


public class Solution {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int length = flowerbed.length;
    int current = 0;
    boolean rc = false;

    if(n == 0) return true;
    if((length == 1) && (flowerbed[0] == 0) && (n == 1)) return true;
    while((n > 0) && (current < length)) {
      // check if current position is available for plant
      if(((current == 0) && (flowerbed[current] == 0) && (current + 1 < length) && (flowerbed[current+1] == 0))  // left edge
      || ((current == length-1) && (current-1 >= 0) && (flowerbed[current] == 0) && (flowerbed[current-1] ==0)) // right edge
      || ((flowerbed[current] == 0) && (current > 0) && (flowerbed[current-1] == 0) && (current < length-1) && (flowerbed[current+1]) == 0)) {
        n--;
        flowerbed[current] = 1;
      }
      current++;
    }
    if(n == 0) {
      rc = true;
    } else {
      rc = false;
    }
    return rc;
  }
  
  public static void main(String[] args) {
    int[] flowerbed1 = {1,0,0,0,1};
    int[] flowerbed2 = {1,0,0,0,0,1};
    int[] flowerbed3 = {0};
    boolean rc = false;
    Solution s = new Solution();

//    rc = s.canPlaceFlowers(flowerbed1, 1);
//    System.out.println("rc: " + rc);
//    rc = s.canPlaceFlowers(flowerbed1, 2);
//    System.out.println("rc: " + rc);
//    rc = s.canPlaceFlowers(flowerbed2, 2);
//    System.out.println("rc: " + rc);
    rc = s.canPlaceFlowers(flowerbed3, 1);
   System.out.println("rc: " + rc);
  }
}
