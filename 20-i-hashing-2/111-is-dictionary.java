/*
Problem Description
Surprisingly, in an alien language, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given an array of words A of size N written in the alien language, and the order of the alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.



Problem Constraints
1 <= N, length of each word <= 10^5

Sum of the length of all words <= 2 * 10^6



Input Format
The first argument is a string array A of size N.

The second argument is a string B of size 26, denoting the order.



Output Format
Return 1 if and only if the given words are sorted lexicographically in this alien language else, return 0.



Example Input
Input 1:

 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Input 2:

 A = ["fine", "none", "bush"]
 B = "qwertyuiopasdfghjklzxcvbnm"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The order shown in string B is: h < s < i (adhbcfegskjlponmirqtxwuvzy) for the given words. 
 So, Return 1.
Explanation 2:

 "none" should be present after "bush", Since b < n (qwertyuiopasdfghjklzxcvbnm). 
 So, Return 0.
*/

public class Solution {
    public int solve(ArrayList<String> A, String B) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < B.length(); i++) {
            map.put(B.charAt(i), i);
        }
        int maxIndex = -1;
        String maxWord = "";
        for (String word: A) {
            if (map.get(word.charAt(0)) > maxIndex) {
                maxIndex = map.get(word.charAt(0));
                maxWord = word;
            } else if (map.get(word.charAt(0)) == maxIndex) {
                // System.out.println("here "+ word);
                int i = 0;
                boolean found = false;
                while(i < word.length() && i < maxWord.length()) {
                    if (map.get(word.charAt(i)) > map.get(maxWord.charAt(i))) {
                        maxIndex = map.get(word.charAt(0));
                        maxWord = word;
                        found = true;
                    }
                    i++;
                }
                if (!found) {
                    // System.out.println("here "+ word);
                    if (word.length() < maxWord.length()) return 0;
                    // System.out.println("here1 "+ word);
                    // maxIndex = map.get(maxWord.charAt(0));
                }
            }
            else return 0;
        }
        return 1;
    }
}
