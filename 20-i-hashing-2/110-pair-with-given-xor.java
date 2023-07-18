/*
Problem Description
Given an integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be the same and should be counted once.


Problem Constraints
1 <= N <= 105

1 <= A[i], B <= 107



Input Format
The first argument is an integer array A.

The second argument is an integer B.



Output Format
Return a single integer denoting the number of unique pairs of integers in the array A whose XOR is equal to B.



Example Input
Input 1:

 A = [5, 4, 10, 15, 7, 6]
 B = 5
Input 2:

 A = [3, 6, 8, 10, 15, 50]
 B = 5


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 (10 ^ 15) = 5
Explanation 2:

 (3 ^ 6) = 5 and (10 ^ 15) = 5 
*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i: A) {
            map.computeIfPresent(i, (k, v) -> v+1);
            map.putIfAbsent(i, 1);
        }
        // for(Integer key: map.keySet()) {
        //     System.out.println(key+ ": "+map.get(key));
        // }
        Integer value1, value2;
        for(Integer key: A) {
            // System.out.print((key^B)+ " ");
            value1 = map.get(key^B);
            value2 = map.get(key);

            if (value1 != null && value2 != null) {
                count += (value1*value2);
                map.remove(key);
                map.remove(key^B);
            }

        }

        return count;
    }
}