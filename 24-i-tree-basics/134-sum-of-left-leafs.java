/*
Problem Description

Given a binary tree, find and return the sum of node value of all left leaves in it.



Problem Constraints

1 <= number of nodes <= 5 * 10^5

1 <= node value <= 10^5



Input Format

First and only argument is a pointer to the root node of the Binary Tree, A.



Output Format

Return an integer denoting the sum of node value of all left leaves in it.



Example Input

Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output

Output 1:

 24
Output 2:

 9


Example Explanation

Explanation 1:

 Left leaf node in the given tree are 9 and 15. Return 24 (9 + 15).
Explanation 2:

 Left leaf node in the given tree are 6 and 3. Return 9 (6 + 3).
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
        return solveIt(A, false);
    }

    public static int solveIt(TreeNode A, boolean isLeftNode) {
        if (A == null) return 0;
        if (A.left == null && A.right == null && isLeftNode) return A.val;
        if (A.left == null && A.right == null && !isLeftNode) return 0;

        int val = 0;
        val += solveIt(A.left, true);
        val += solveIt(A.right, false);
        return val;
    }
}
