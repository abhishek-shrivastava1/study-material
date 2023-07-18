/*
Problem Description
Given a decimal number A and a base B, convert it into its equivalent number in base B.


Problem Constraints
0 <= A <= 512
2 <= B <= 10


Input Format
The first argument will be decimal number A.
The second argument will be base B.


Output Format
Return the conversion of A in base B.


Example Input
Input 1:
A = 4
B = 3
Input 2:
A = 4
B = 2 


Example Output
Output 1:
11
Output 2:
100


Example Explanation
Explanation 1:
Decimal number 4 in base 3 is 11.
Explanation 2:
Decimal number 4 in base 2 is 100. 
*/

public class Solution {
    public int DecimalToAnyBase(int A, int B) {
        String ans = "";
        int remainder;
        while (A >= B) {
            // System.out.println("A:"+A);
            // System.out.println("ans:"+ans);
            remainder = A % B;
            // System.out.println("R:"+remainder);
            A = A / B;
            ans += remainder;
        }
        // System.out.println(A);
        // System.out.println(ans);
        ans += A;
        // System.out.println(ans);
        char[] ansArray = ans.toCharArray();
        char temp;
        for(int i = 0, j = ansArray.length - 1; i<j; i++, j--) {
            temp = ansArray[i];
            ansArray[i] = ansArray[j];
            ansArray[j] = temp;
        }
        // System.out.println(new String(ansArray));
        return Integer.parseInt(new String(ansArray));
    }
}
