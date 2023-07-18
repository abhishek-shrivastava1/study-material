/*
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints
1 <= n <= 105
-105 <= A[i] <= 105


Input Format
First argument contains an array A of integers of size N


Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Example Input
Input 1:
A=[2, 1, 6, 4]
Input 2:

A=[1, 1, 1]


Example Output
Output 1:
1
Output 2:

3


Example Explanation
Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 
Explanation 2:

Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.
*/

public class Solution {
    public int solve(int[] A) {
        int[] prefixOdd = new int[A.length];
        int[] prefixEven = new int[A.length];
        prefixEven[0] = A[0];
        prefixOdd[0] = 0;
        for(int i = 1; i < A.length; i++) {
            if(i % 2 == 0) {
                prefixOdd[i] = prefixOdd[i - 1];
                prefixEven[i] = A[i]+ prefixEven[i - 1];
            } else {
                prefixOdd[i] = A[i] + prefixOdd[i - 1];
                prefixEven[i] = prefixEven[i - 1];
            }
        }
        int prefixEvenSum, prefixOddSum;
        int specialIndices = 0;
        for (int i = 0; i < A.length; i++) {
            // System.out.println("index: " + i);
            if (i == 0) {
                prefixEvenSum = prefixSum(prefixOdd, i + 1, A.length - 1);
                prefixOddSum = prefixSum(prefixEven, i + 1, A.length - 1);
                if (prefixEvenSum == prefixOddSum) specialIndices++;
            } else {
                // even total  ==  odd total 
                prefixEvenSum = prefixSum(prefixEven, 0, i - 1) + prefixSum(prefixOdd, 0, A.length - 1) - prefixSum(prefixOdd, 0, i);
                prefixOddSum = prefixSum(prefixOdd, 0, i - 1) + prefixSum(prefixEven, 0, A.length - 1) - prefixSum(prefixEven, 0, i);
                if (prefixEvenSum == prefixOddSum) specialIndices++;
            }
            // System.out.println("pfe: " + prefixEvenSum);
            // System.out.println("pfo: " + prefixOddSum);
        }
        return specialIndices;
    }

    public static int prefixSum (int[] A, int L, int R) {
        if (L == 0) return A[R];
        return A[R] - A[L - 1];
    }
}
