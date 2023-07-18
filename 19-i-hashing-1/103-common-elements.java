/*
Problem Description
Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.

NOTE:

Each element in the result should appear as many times as it appears in both arrays.
The result can be in any order.


Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109



Input Format
First argument is an integer array A of size N.

Second argument is an integer array B of size M.



Output Format
Return an integer array denoting the common elements.



Example Input
Input 1:

 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]
Input 2:

 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]


Example Output
Output 1:

 [1, 2, 2]
Output 2:

 [2, 10]


Example Explanation
Explanation 1:

 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:

 Elements (2, 10) appears in both the array.
*/

// Do not write code to include libraries, main() function or accept any input from the console.
// Initialization code is already written and hidden from you. Do not write code for it again.
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> AL, ArrayList<Integer> BL) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
    int[] A = AL.stream().mapToInt(i -> i).toArray();
    int[] B = BL.stream().mapToInt(i -> i).toArray();
    ArrayList<Integer> ans = new ArrayList<>();
    Integer value;
    Map<Integer, Integer> mapA = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
        value = mapA.get(A[i]);
        if (value == null) mapA.put(A[i], 1);
        else mapA.put(A[i], value+1);
    }
    Map<Integer, Integer> mapB = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
        value = mapB.get(B[i]);
        if (value == null) mapB.put(B[i], 1);
        else mapB.put(B[i], value+1);
    }

    Integer v1, v2;
    for (Integer key: mapA.keySet()) {
        v1 = mapA.get(key);
        v2 = mapB.get(key);
        // System.out.println("key: "+ key+" v1: "+v1+" v2: "+v2);
        if (v1 != null && v2 != null)  {
            if (v1 >= v2) {
                for (int j = 1; j <= v2; j++) {
                    ans.add(ans.size(), key);
                }
                // add element v2 times
            } else {
                // v1 times
                for (int j = 1; j <= v1; j++) {
                    ans.add(ans.size(), key);
                }
            }
        }
    }
    return ans;
    }
}
