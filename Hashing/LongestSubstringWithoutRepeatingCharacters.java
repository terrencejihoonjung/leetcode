package Hashing;
import java.util.*;

/**
 * DESCRIPTION
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * CONSTRANTS
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 * 
 * EXAMPLES
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding Window with hashmap! First, initialize hashmap and pointers
        Map<Character, Integer> counts = new HashMap<>();
        int left = 0, max = 0;

        // Iterate through string s
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Check hashmap and see if freq > 1
            if (counts.containsKey(c) && counts.get(c) >= left) {
                left = counts.get(c) + 1;
            }

            // Calculate max and update hashmap
            max = Math.max(max, right - left + 1);
            counts.put(c, right);
        }

        return max;
    }
}