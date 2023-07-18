/*
Problem Description
Given an array B of length A with elements 1 or 0. Find the number of subarrays such that the bitwise OR of all the elements present in the subarray is 1.
Note : The answer can be large. So, return type must be long.



Problem Constraints
1 <= A <= 10^5


Input Format
The first argument is a single integer A.
The second argument is an integer array B.


Output Format
Return the number of subarrays with bitwise array 1.


Example Input
Input 1:
 A = 3
B = [1, 0, 1]
Input 2:
 A = 2
B = [1, 0]


Example Output
Output 1:
5
Output2:
2


Example Explanation
Explanation 1:
The subarrays are :- [1], [0], [1], [1, 0], [0, 1], [1, 0, 1]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1
Explanation 2:
The subarrays are :- [1], [0], [1, 0]
Except the subarray [0] all the other subarrays has a Bitwise OR = 1
*/

public class Solution {
    public long solve(int B, int[] A) {
        long ans = 0;
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                if (prefixSum(A, i, j) != 0) ans++;
            }
        }
        return ans;
    }

    public static int prefixSum (int[] A, int L, int R) {
        if (L == 0) return A[R];
        return A[R] - A[L - 1];
    }
}

// 1 1 2
