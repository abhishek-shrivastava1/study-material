/*
Problem Description
You are given an integer array A of size N.

You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you removed.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [ 2, 3, -1, 4, 2, 1 ]
 B = 4


Example Output
Output 1:

 8
Output 2:

 9


Example Explanation
Explanation 1:

 Remove element 5 from front and element (1, 2) from back so we get 5 + 1 + 2 = 8
Explanation 2:

 Remove the first element and the last 3 elements. So we get 2 + 4 + 2 + 1 = 9
*/

public class Solution {
    public int solve(int[] A, int B) {
        int[] arr = prefixSum(A);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < B; i++) {
            int leftSum = prefixSumInRange(arr, (0), (B - i - 1));
            int rightSum = prefixSumInRange(arr, (arr.length - i), (arr.length - 1));
            int sumMax = leftSum + rightSum;
            max = max >= sumMax ? max : sumMax;
        }
        return max;
    }


    public static int prefixSumInRange(int arr[], int l, int r) {
        if (l == -1 || l == arr.length) return 0;
        if (l == 0) return arr[r];
        return arr[r] - arr[l - 1];
    }

    public static int[] prefixSum(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }
}