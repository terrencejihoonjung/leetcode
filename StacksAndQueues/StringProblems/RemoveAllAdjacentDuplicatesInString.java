
package StacksAndQueues.StringProblems;
import java.util.*;

/**
 * DESCRIPTION
 * You are given a string s consisting of lowercase English letters. 
 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 * 
 * CONSTRANTS
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * 
 * EXAMPLES
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation: 
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 */

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder string = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (string.length() > 0 && string.charAt(string.length() - 1) == c) {
                string.deleteCharAt(string.length() - 1);
            } else {
                string.append(c);
            }
        }

        return string.toString();
    }
}