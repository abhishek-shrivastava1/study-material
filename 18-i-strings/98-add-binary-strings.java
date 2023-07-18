/*
Problem Description
Given two binary strings A and B. Return their sum (also a binary string).


Problem Constraints
1 <= length of A <= 105

1 <= length of B <= 105

A and B are binary strings



Input Format
The two argument A and B are binary strings.



Output Format
Return a binary string denoting the sum of A and B



Example Input
Input 1:
A = "100"
B = "11"
Input 2:
A = "110"
B = "10"


Example Output
Output 1:
"111"
Output 2:
"1000"


Example Explanation
For Input 1:
The sum of 100 and 11 is 111.
For Input 2:
 
The sum of 110 and 10 is 1000.
*/

public class Solution {
    public String addBinary(String A, String B) {
        String ans;
        // System.out.println(A.length());
        // System.out.println(B.length());
        if(A.length() >= B.length()) {
            ans = addBinaryString(A, B);
        } else {
            ans = addBinaryString(B, A);
        }
        return ans;
    }

    public static String addBinaryString(String A, String B) {
        int sum, carry = 0, num1, num2;
        String ans = "";
        int bLength = B.length();
        int aLength = A.length();
        for (int i = aLength - 1; i >= 0; i--) {
            // System.out.println(i);
            num1 = A.charAt(i) == '1' ? 1 : 0;
            if (bLength - 1 >= 0) num2 = B.charAt(bLength - 1) == '1' ? 1 : 0;
            else num2 = 0;
            sum = (num1 + num2 + carry);
            carry = sum / 2;
            sum = sum % 2;
            ans = sum + ans;
            bLength--;
        }
        if (carry == 1) ans = 1 + ans;
        return ans;
    }
}
