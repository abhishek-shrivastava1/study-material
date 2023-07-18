/*
Problem Description
Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.



Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000


Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.


Output Format
Return the resultant matrix.


Example Input
Input 1:
 
    A = [1, 2, 3, 4, 5]
    B = [2, 3]

Input 2:

  
    A = [5, 17, 100, 11]
    B = [1]




Example Output
Output 1:
 
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]


Output 2:

    
    [ [17, 100, 11, 5] ]



Example Explanation
for input 1 -> B[0] = 2 which requires 2 times left rotations

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

B[1] = 3 which requires 3 times left rotation

1: [2, 3, 4, 5, 1]

2: [3, 4, 5, 1, 2]

2: [4, 5, 1, 2, 4]


*/

public class Solution {
    public int[][] solve(int[] A, int[] B) {
        int[][] ans = new int[B.length][A.length];
        int rotate;
        for (int i = 0; i < B.length; i++) {
            int[] temp = new int[A.length];
            int[] X = Arrays.copyOf(A, A.length);
            // A = X;
            rotate = B[i] % A.length;
            reverse(X, 0, A.length - 1);
            reverse(X, 0, A.length - 1 - rotate);
            temp = reverse(X, A.length - rotate, A.length - 1);
            ans[i] = temp;
        }
        return ans;
    }

    public static int[] reverse (int[] A, int start, int end) {
        for (int i = start, j = end; i < j && i!=j; i++, j--) {
            A[i] = A[i] + A[j];
            A[j] = A[i] - A[j];
            A[i] = A[i] - A[j];
        }
        int[] temp = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            temp[i] = A[i];
        }
        return temp;
    }
}
