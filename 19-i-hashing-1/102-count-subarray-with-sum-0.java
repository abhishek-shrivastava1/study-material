/*
Problem Description
Given an array A of N integers.

Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -1, -2, 2]
Input 2:

 A = [-1, 2, -1]


Example Output
Output 1:

3
Output 2:

1


Example Explanation
Explanation 1:

 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:

 The subarray with zero sum is [-1, 2, -1].


*/

import java.util.stream.Collectors;
public class Solution {
    public int solve(ArrayList<Integer> B) {
        List<Long> A = B.stream().mapToLong(Integer::longValue).boxed().collect(Collectors.toList());
        Map<Long, Integer> map = new HashMap<>();
        ArrayList<Long> pf = new ArrayList<>();
        int count = 0;
        pf.add(0, A.get(0));
        map.put(new Long(0), 1);
        long sum;
        for (int i = 1; i < A.size(); i++) {
            sum = (pf.get(i-1) + A.get(i));
            pf.add(i, sum);
        }
        for (Long element: pf) {
            if (map.get(element) == null) map.put(element, 1);
            else {
                int newVal = map.get(element) + 1;
                map.put(element, newVal);
                }
        }
        for(Long item: map.keySet()) {
            count += fn(map.get(item));
        }
        return count;
    }

    public static int fn(int num) {
        int ans = 0;
        if (num > 1){
            int i = 2;
            while(i <= num) {
                ans += i - 1;
                i++;
            }
        }
        return ans;
    }

}