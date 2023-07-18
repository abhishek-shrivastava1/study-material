/*
Problem Description
You will be given an integer n. You need to return the count of prime numbers less than or equal to n.


Problem Constraints
0 <= n <= 10^3


Input Format
Single input parameter n in function.


Output Format
Return the count of prime numbers less than or equal to n.


Example Input
Input 1:
19
Input 2:
1


Example Output
Output 1:
8
Output 2:
0


Example Explanation
Explanation 1:
Primes <= 19 are 2, 3, 5, 7, 11, 13, 17, 19
Explanation 2:
There are no primes <= 1 
*/

public class Solution {
    public int solve(int A) {
        int count = 0;
        for (int i = 1; i <= A; i++) {
            if(isPrime(i)) count++;
        }
        return count;
    }

    public static boolean isPrime(int number) {
        int count = 0;
        for( int i = 1; i <= number/i; i++) {
            if(number % i == 0) {
                if (i == number/i) count++;
                else count+=2;
            }
        }
        return count == 2;
    }
}
