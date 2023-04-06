package Hashing.Counting;
import java.util.*;

/**
 * DESCRIPTION
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
 * Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * 
 * CONSTRANTS
 * 1 <= jewels.length, stones.length <= 50 
 * jewels and stones consist of only English letters.
 * All the characters of jewels are unique.
 * 
 * EXAMPLES
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 * 
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 */

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // Initialize a hashmap for jewels
        Map<Character, Integer> counts = new HashMap<>();
        char[] gems = jewels.toCharArray();
        for (char gem : gems) {
            counts.put(gem, 0);
        }

        // Count frequency of stones that match jewels
        char[] rocks = stones.toCharArray();
        for (char rock : rocks) {
            if (counts.containsKey(rock)) {
                counts.put(rock, counts.get(rock) + 1);
            }
        }

        // Return the sum of hashmap values
        int sum = 0;
        for (int num : counts.values()) {
            sum += num;
        }
        return sum;
    }
}