/*
Problem Description
Given an integer A, find and return the Ath magic number.

A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….



Problem Constraints
1 <= A <= 5000



Input Format
The only argument given is integer A.



Output Format
Return the Ath magic number.



Example Input
Example Input 1:

 A = 3
Example Input 2:

 A = 10


Example Output
Example Output 1:

 30
Example Output 2:

 650


Example Explanation
Explanation 1:

 Magic Numbers in increasing order are [5, 25, 30, 125, 130, ...]
 3rd element in this is 30
Explanation 2:

 In the sequence shown in explanation 1, 10th element will be 650.
*/

public class Solution {
    public int solve(int A) {
        int multiplier = 0;
        int ans = 0;
        int i = 0;
        while ((A >> i) != 0) {
            if (((A >> i) & 1) == 1)  {
                // System.out.println("I: "+ i);
                multiplier = getMultiplier(5, i);
                // System.out.println("M: "+ multiplier);
                ans += multiplier;
                // System.out.println("A: "+ ans);
            }
            i++;
        }
        return ans;
    }

    public static int getMultiplier(int base, int index) {
        // if (index == 0) return 1;
        index++;
        int sol = 1;
        for (int i = 1; i <= index; i++) {
            sol = sol * base;
        }
        return sol;
    }
}

// 3
// 1010