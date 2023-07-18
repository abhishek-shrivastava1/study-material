/*
Problem Description
You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.

You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.



Problem Constraints
1 <= N <= 10^5

A[i] ∈ ['a'-'z', 'A'-'Z']



Input Format
First and only argument is a character string A.



Output Format
Return a character string.



Example Input
Input 1:

 A = "Hello" 
Input 2:

 A = "tHiSiSaStRiNg" 


Example Output
Output 1:

 hELLO 
Output 2:

 ThIsIsAsTrInG 


Example Explanation
Explanation 1:

 'H' changes to 'h'
 'e' changes to 'E'
 'l' changes to 'L'
 'l' changes to 'L'
 'o' changes to 'O'
Explanation 2:

 "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
*/

public class Solution {
    public String solve(String A) {
        StringBuilder s = new StringBuilder(A);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) >= 65 && A.charAt(i) < 91) {
                s.setCharAt(i, (char)(A.charAt(i) + 32)); 
            } else if (A.charAt(i) >= 97 && A.charAt(i) < 123) {
                s.setCharAt(i, (char)(A.charAt(i) - 32)); 
            }
        }
        return s.toString();
    }
}
