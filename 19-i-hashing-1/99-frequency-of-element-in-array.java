/*
Problem Description
Given an array A. You have some integers given in the array B.
For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.


Problem Constraints
1 <= |A| <= 10^5
1 <= |B| <= 10^5
1 <= A[i] <= 10^5
1 <= B[i] <= 10^5


Input Format
First argument A is an array of integers.
Second argument B is an array of integers denoting the queries.


Output Format
Return an array of integers containing frequency of the each element in B.


Example Input
Input 1:
A = [1, 2, 1, 1]
B = [1, 2]
Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]


Example Output
Output 1:
[3, 1]
Output 2:
[0, 2]


Example Explanation
For Input 1:
The frequency of 1 in the array A is 3.
The frequency of 2 in the array A is 1.
For Input 2:
The frequency of 3 in the array A is 0.
The frequency of 2 in the array A is 2.
*/

public class Solution {
    public int[] solve(int[] A, int[] B) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Integer value;
        for (int i = 0; i < A.length; i++) {
            value = frequencyMap.get(A[i]);
            if (value == null) {
                frequencyMap.put(A[i], 1);
            } else {
                frequencyMap.put(A[i], value + 1);
            }
        }

        int[] ans =  new int[B.length];
        for (int i = 0; i < B.length; i++) {
            value = frequencyMap.get(B[i]);
            ans[i] = value == null ? 0 : value;
        }
        return ans;
    }
}
