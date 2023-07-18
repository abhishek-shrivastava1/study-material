/*
Problem Description
Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.



Problem Constraints
1<=N<=100000


Input Format
First argument is a string A of size N.



Output Format
Return the resultant string.



Example Input
Input 1:
A="aeiOUz"
Input 2:
A="AbcaZeoB"


Example Output
Output 1:
"###z###z"
Output 2:
"bc###bc###"


Example Explanation
Explanatino 1:
First concatenate the string with itself so string A becomes "aeiOUzaeiOUz".
Delete all the uppercase letters so string A becomes "aeizaeiz".
Now replace vowel with '#', A becomes "###z###z".
Explanatino 2:
First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
Delete all the uppercase letters so string A becomes "bcaeobcaeo".
Now replace vowel with '#', A becomes "bc###bc###".
*/

public class Solution {
    public String solve(String A) {
        String str = A+A;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 97 || str.charAt(i) == 101 || str.charAt(i) == 105 || str.charAt(i) == 111 || str.charAt(i) == 117) s.append('#');
            else if (str.charAt(i) >= 97 && str.charAt(i) < 123) s.append(str.charAt(i));
        }
        return s.toString();
    }
}
