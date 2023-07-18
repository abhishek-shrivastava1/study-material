/*
Problem Description
Given a number A, we need to find the sum of its digits using recursion.


Problem Constraints
1 <= A <= 10^9


Input Format
The first and only argument is an integer A.


Output Format
Return an integer denoting the sum of digits of the number A.


Example Input
Input 1:

 A = 46
Input 2:

 A = 11


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

 Sum of digits of 46 = 4 + 6 = 10
Explanation 2:

 Sum of digits of 11 = 1 + 1 = 2

*/

public class Solution {
    public int solve(int A) {
        return sum(A);
    }

    public static int sum(int A) {
        if (A == 0) return 0;
        return A%10 + sum(A/10);
    }
}
// 3 + sum(12)
// 3 + 2 + sum(1)
// 3 + 2 + 1 + sum(0)