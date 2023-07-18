/*
Problem Description
You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
1 <= B <= 109


Input Format
First argument A is an array of integers and second argument B is an integer.


Output Format
Return an integer.


Example Input
Input 1:

A = [3, 5, 1, 2]
B = 8
Input 2:

A = [1, 2, 1, 2]
B = 3


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Example 1:

The only pair is (1, 2) which gives sum 8
Example 2:

The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4). 

*/

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer value;
        for(Integer a: A) {
            value = map.get(a);
            if (value == null) map.put(a, 1);
            else map.put(a, ++value);
        }

        // for (Integer key: map.keySet()) {
        //     System.out.println(key+ ": "+map.get(key));
        // }

        long count = 0;
        Integer value2;
        for(int i = 0; i < A.size(); i++) {
            value = map.get(B - A.get(i));
            value2 = map.get(A.get(i));
            if(value != null && value2 != null) {
                if ((B-A.get(i)) == A.get(i)) {
                    // System.out.println(value);
                    long v = (long) (value);
                    count = (count %1000000007) + ((((v) %1000000007) * ((v - 1) %1000000007)) / 2);
                }
                    // count+= (long)(((((value-1)%1000000007)*((value-2)%1000000007))/2)% 1000000007);
                else count += (long)(value * value2);
                map.remove(B-A.get(i));
                map.remove(A.get(i));
                count = count % 1000000007;
            };
        }
        return (int)(count % 1000000007);
        // for(Integer key: map.keySet()) {
        //     if 
        // }
    }
}
