/*
Problem Description
You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. If 2 elements have same number of factors, then number with less value should come first.

Note: You cannot use any extra space


Problem Constraints
1 <= N <= 10^4
1 <= A[i] <= 10^4


Input Format
First argument A is an array of integers.


Output Format
Return an array of integers.


Example Input
Input 1:
A = [6, 8, 9]
Input 2:
A = [2, 4, 7]


Example Output
Output 1:
[9, 6, 8]
Output 2:
[2, 7, 4]


Example Explanation
For Input 1:
The number 9 has 3 factors, 6 has 4 factors and 8 has 4 factors.
For Input 2:
The number 2 has 2 factors, 7 has 2 factors and 4 has 3 factors.

*/

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        A.sort((a, b) -> {
            int aFactors = countFactors(a);
            int bFactors = countFactors(b);

            if (aFactors < bFactors) return -1;
            else if (aFactors > bFactors) return 1;
            else if (a < b) return -1;
            else if (a > b) return 1;
            else return 0;
            // return 1;
        });
        return A;
    }

    public static int countFactors(int n) {
        int count = 0;
        for (int i = 1; i*i <= n; i++) {
            if ((float)i == (float) n/i) count++;
            else if (n%i == 0) count += 2;
        }
        return count;
    }
}
