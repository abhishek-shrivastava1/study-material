/*
Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.



Problem Constraints
1 <= |A| <= 10^5

String A consist only of lowercase characters.



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the reversed string.



Example Input
Input 1:

 A = "scaler"
Input 2:

 A = "academy"


Example Output
Output 1:

 "relacs"
Output 2:

 "ymedaca"


Example Explanation
Explanation 1:

 Reverse the given string.
*/

public class Solution {
    public String solve(String A) {
        StringBuilder s = new StringBuilder(A);
        for (int i = 0, j = A.length() - 1; i <= j; i++, j--) {
            if (i == j) s.setCharAt(i, A.charAt(i));
            else {
                s.setCharAt(i, A.charAt(j));
                s.setCharAt(j, A.charAt(i));
            }
        }
        return s.toString();
    }
}
