/*
Problem Description
You are given a number A. You are also given a base B. A is a number on base B.
You are required to convert the number A into its corresponding value in decimal number system.


Problem Constraints
0 <= A <= 10^9
2 <= B <= 9


Input Format
First argument A is an integer.
Second argument B is an integer.


Output Format
Return an integer.


Example Input
Input 1:
A = 1010
B = 2
Input 2:
A = 22 
B = 3


Example Output
Output 1:
10
Output 2:
8


Example Explanation
For Input 1:
The decimal 10 in base 2 is 1010.
For Input 2:
The decimal 8 in base 3 is 22.
*/

public class Solution {
    public int solve(int A, int B) {
        int ans = 0;
        int remainder = 0;
        int multiplier = 0;
        int numToAdd;
        while (A > B) {
            remainder = A % 10;
            numToAdd = remainder * getMultiplier(B, multiplier);
            // System.out.println("n2a: "+ numToAdd);
            ans += numToAdd;
            multiplier++;
            A = A / 10;
            // System.out.println("A: "+ A);
        }
        remainder = A % 10;
        // System.out.println("R: "+ remainder);
        numToAdd = remainder * getMultiplier(B, multiplier);
        // System.out.println("n2a: "+ numToAdd);
        ans += numToAdd;
        return ans;
    }

    public static int getMultiplier(int Base, int multiplier) {
        int ans = 1;
        if (multiplier == 0) return 1;
        for (int i = 1; i <= multiplier; i++) {
            ans = ans * Base;
        }
        return ans;
    }
}

// 1 0 1 0 0

