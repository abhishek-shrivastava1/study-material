/*
Problem Description
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements added in spiral order.



Example Input
Input 1:

1
Input 2:

2
Input 3:

5


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], 
  [4, 3] ]
Output 2:

[ [1,   2,  3,  4, 5], 
  [16, 17, 18, 19, 6], 
  [15, 24, 25, 20, 7], 
  [14, 23, 22, 21, 8], 
  [13, 12, 11, 10, 9] ]


Example Explanation
Explanation 1:

Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
Explanation 3:



*/

public class Solution {
    public int[][] generateMatrix(int A) {
        int[][] sol = new int[A][A];
        int N = A;
        int row = 0;
        int column = 0;
        int start = 0;
        int num = 1;
        while (N > 1) {
            for (int i = start; i < N; i++) {
                sol[row][i] = num;
                num++;
            }
            for (int i = start + 1; i < N; i++) {
                sol[i][N - 1] = num;
                num++;
            }
            for (int i = N - 2; i >= start; i--) {
                sol[N - 1][i] = num;
                num++;
            }
            for (int i = N - 2; i > start; i--) {
                sol[i][column] = num;
                num++;
            }
            row++;
            column++;
            start++;
            N -= 1;
        }
        int center = A/2;
        if (A % 2 == 1) {
            sol[center][center] = A * A;
        }
        return sol;
    }
}
