/*
Problem Description
Write a recursive function that takes a string, S, as input and prints the characters of S in reverse order.



Problem Constraints
1 <= |s| <= 1000



Input Format
First line of input contains a string S.



Output Format
Print the character of the string S in reverse order.



Example Input
Input 1:

 scaleracademy
Input 2:

 cool


Example Output
Output 1:

 ymedacarelacs
Output 2:

 looc


Example Explanation
Explanation:

 Print the reverse of the string in a single line.

*/

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);  
        String s = scan.next();  
        reverse(s, 0, s.length() - 1);
        
    }

    public static void reverse(String s, int left, int right) {
        if (left > right) return;
        if (left == right) {System.out.print(s.charAt(left)); return;}
        System.out.print(s.charAt(right));
        reverse(s, left + 1, right - 1);
        System.out.print(s.charAt(left));
    }
}