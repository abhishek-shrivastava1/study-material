/*
Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.



Problem Constraints
1 <= A.size() <= 10^3

1 <= A[i].size() <= 10^3

0 <= A[i][j] <= 10^3



Input Format
First argument is a 2D integer matrix A.



Output Format
Return a 2D matrix after doing required operations.



Example Input
Input 1:

[1,2,3,4]
[5,6,7,0]
[9,2,0,4]


Example Output
Output 1:

[1,2,0,0]
[0,0,0,0]
[0,0,0,0]


Example Explanation
Explanation 1:

A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.
*/

public class Solution {
    public int[][] solve(int[][] A) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        int k;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 0) {
                   rows.add(i);
                   columns.add(j);
                }
            }    
        }
        for(int i = 0; i < rows.size(); i++) {
            k = rows.get(i);
            for (int j = 0; j < A[0].length; j++) {
                A[k][j] = 0;
            }
        }
        for(int i = 0; i < columns.size(); i++) {
            k = columns.get(i);
            for (int j = 0; j < A.length; j++) {
                A[j][k] = 0;
            }
        }
        return A;
    }
}

// 1 3