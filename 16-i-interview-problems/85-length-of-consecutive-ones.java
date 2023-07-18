/*
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7
*/

public class Solution {
    public int solve(String A) {
        int max = 0;
        int lastZeroIndex = -1;
        int zeroCount = 0;
        int count = 0;
        
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1') {
                count++;
            } else if (A.charAt(i) == '0' && zeroCount == 0) {
                count++;
                zeroCount++;
                lastZeroIndex = i;
            } else if (A.charAt(i) == '0' && zeroCount == 1) {
                if (count > max) max = count;
                zeroCount = 1;
                count = i - lastZeroIndex;
                lastZeroIndex = i;
            }
        if (count > max) max = count;
        return max;
    }
}