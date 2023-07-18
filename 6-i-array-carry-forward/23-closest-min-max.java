/*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3, 2]
Input 2:

A = [2, 6, 1, 6, 9]


Example Output
Output 1:

 2
Output 2:

 3


Example Explanation
Explanation 1:

 Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2:

 Take the last 3 elements of the array.
*/

public class Solution {
    public int solve(int[] A) {
        int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int maxIndex = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                // maxIndex = i;
            }
            if (A[i] < min) {
                min = A[i];
                // minIndex = i;
            }
        }
        int minMaxLength = 2001;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == max) {
                for (int j = i; j < A.length; j++) {
                    if (A[j] == min) {
                        if (minMaxLength > (j - i + 1)) minMaxLength = (j - i + 1);
                    }
                }
            }
            if (A[i] == min) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] == max) {
                        if (minMaxLength > (j - i + 1)) minMaxLength = (j - i + 1);
                    }
                }
            }
        }
        return minMaxLength;
    }
}
