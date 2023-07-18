/*
Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints
1 <= N <= 6000



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the longest palindromic substring of string A.



Example Input
Input 1:
A = "aaaabaaa"
Input 2:
A = "abba


Example Output
Output 1:
"aaabaaa"
Output 2:
"abba"


Example Explanation
Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
Explanation 2:
We can see that longest palindromic substring is of length 4 and the string is "abba".
*/

public class Solution {
    // static int MAX = 0, LEFT = Integer.MAX_VALUE, RIGHT = -1;
    public String longestPalindrome(String A) {
        String max = "";
        Answer ans = new Answer();
        ans.MAX = 0;
        ans.LEFT = Integer.MAX_VALUE;
        ans.RIGHT = -1;
        // Integer MAX = 0, LEFT = Integer.MAX_VALUE, RIGHT = -1;
        for (int i = 0; i < A.length() - 1; i++) {
            getMaxPalindrome(A, i, i, ans);
            getMaxPalindrome(A, i, i+1, ans);
        }
        getMaxPalindrome(A, A.length() -1, A.length() -1, ans);
        // System.out.println("MAX left: "+ LEFT+" and RIGHT: "+ RIGHT+ " m = "+ MAX);
        return A.substring(ans.LEFT, ans.RIGHT+1);
    }

    public static int getMaxPalindrome(String a, int left, int right, Answer ans) {
        int max;
        if (left == right) {
            max = 1;
        } else {
            if (a.charAt(left) != a.charAt(right)) return 0;
            max = 2;
        }
        if (max > ans.MAX) {
            ans.MAX = max;
            ans.LEFT = left;
            ans.RIGHT = right;
        }
        // System.out.println("For left: "+ left+" and right: "+ right+ " s = "+ max);
        // System.out.println("MAX left: "+ LEFT+" and RIGHT: "+ RIGHT+ " m = "+ MAX);
        while (left >= 0 && right < a.length()) {
            if (a.charAt(left) != a.charAt(right)) {
                return 0;
            }
            if (right - left + 1 > max && right - left + 1 > ans.MAX) {
                max = right - left + 1;
                ans.MAX = max;
                ans.LEFT = left;
                ans.RIGHT = right;
            }
            left--;
            right++;
        }
        return 0;
    }
}

class Answer {
    int LEFT;
    int RIGHT;
    int MAX;
}