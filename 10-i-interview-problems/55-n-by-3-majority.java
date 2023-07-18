/*
Problem Description
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Note: Read-only array means that the input array should not be modified in the process of solving the problem



Problem Constraints
1 <= N <= 7*10^5
1 <= A[i] <= 10^9


Input Format
The only argument is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:
[1 2 3 1 1]
Input 2:
[1 2 3]


Example Output
Output 1:
1
Output 2:
-1


Example Explanation
Explanation 1:
1 occurs 3 times which is more than 5/3 times.
Explanation 2:
No element occurs more than 3 / 3 = 1 times in the array.
*/

public class Solution {
    public int repeatedNumber(int[] A) {
        int majority1 = A[0];
        int majority2 = -1;
        int majority3 = -1;
        int count1 = 1;
        int count2 = 0;
        int count3 = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == majority1) count1++;
            else if (majority2 == -1 || majority2 == A[i]) {majority2 = A[i]; count2++;}
            else if (majority3 == -1 || majority3 == A[i]) {majority3 = A[i]; count3++;}

            // if (count1 == 0 && count2 == 0 && count3 == 0) {
            //     majority1 = A[i];
            //     count1 = 1;
            // }
            if (A[i] != majority1 && A[i] != majority2 && A[i] != majority3) {
                if (count1 > 0 && count2 > 0 && count3 > 0) {
                    count1--;
                    count2--;
                    count3--;
                }
                if (count1 == 0) {
                    majority1 = A[i];
                    count1++;
                } else if (count2 == 0) {
                    majority2 = A[i];
                    count2++;
                } else if (count3 == 0) {
                    majority3 = A[i];
                    count3++;
                } 
            }
            if(count1 < 0) {
                majority1 = A[i];
                count1 = 1;
            }
            if(count2 < 0) {
                majority2 = A[i];
                count2 = 1;
            }
            if(count3 < 0) {
                majority3 = A[i];
                count3 = 1;
            }
            // System.out.println(i +":"+ A[i]);
            // System.out.println("m1:"+ majority1+ " count:" + count1);
            // System.out.println("m2:"+ majority2+ " count:" + count2);
            // System.out.println("m3:"+ majority3+ " count:" + count3);
        }
        int majorityCount1 = 0;
        int majorityCount2 = 0;
        int majorityCount3 = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == majority1) majorityCount1++;
            if(A[i] == majority2) majorityCount2++;
            if(A[i] == majority3) majorityCount3++;
        }
        // System.out.println("1:"+ majority1+ " count:" + count1);
        // System.out.println("2:"+ majority2+ " count:" + count2);
        if ((float) majorityCount1 > (float) A.length/3) return majority1;
        if ((float) majorityCount2 > (float) A.length/3) return majority2;
        if ((float) majorityCount3 > (float) A.length/3) return majority3;
        return -1;
    }
}
// 1 1 1 1 3 4 5 6 7 8