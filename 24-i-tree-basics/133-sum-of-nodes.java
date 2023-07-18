/*
Problem Description
Given the root of a binary tree A. Return the sum of all the nodes of the binary tree.


Problem Constraints
1 <= Number of nodes in A <= 104

1 <= value of each node <= 104



Input Format
First argument is the root of binary tree A.



Output Format
Return an integer denoting the sum of all the nodes



Example Input
Input 1:

 A =   2                 
      / \                           
     1   4            
    /                           
   5


Input 2:

A =   3
      / \
      6  1
      \   \
       2   7


Example Output
Output 1:

12
Output 2:

19


Example Explanation
Explanation 1:

The sum of all the nodes is 12
Explanation 2:

The sum of all the nodes is 19
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int solve(TreeNode A) {
        if (A == null) return 0;
        int v1 = solve(A.left);
        int v2 = solve(A.right);
        return A.val + v1 + v2;
    }
}
