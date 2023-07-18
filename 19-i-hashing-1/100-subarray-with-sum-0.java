/*
Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [4, -1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The subarray [-1, 1] has sum 0.
*/

public class Solution {
    // Do not write code to include libraries, main() function or accept any input from the console.
    // Initialization code is already written and hidden from you. Do not write code for it again.
    public int solve(ArrayList<Integer> A) {
          // Just write your code below to complete the function. Required input is available to you as the function arguments.
          // Do not print the result or any output. Just return the result via this function.
          long[] pf = new long[A.size()];
          pf[0] = (long)A.get(0);
          Long value;
          Set<Long> set = new HashSet<>();
          long sum = 0;
          set.add(sum);
          for (int i = 0; i < A.size(); i++) {
              sum += A.get(i);
              if (set.contains(sum)) return 1;
              set.add(sum);
          }
          return 0;
    }
  }
  