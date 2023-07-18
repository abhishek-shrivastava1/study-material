/*
Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
The first argument is an array of integers.



Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

*/

import java.util.stream.Collectors;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        List<String> S = A.stream().map((a) -> a.toString()).collect(Collectors.toList());
        S.sort((a, b) -> {
            return (a+b).compareTo(b+a) * -1;
        });
        String ans = "";
        for (int i = 0; i < S.size(); i++) {
            if (ans.equals("") && S.get(i).equals("0")) continue;
            ans += S.get(i);
        }
        return ans.equals("") ? "0" : ans;
    }
}
