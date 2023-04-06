package Hashing.Counting;
import java.util.*;

/**
 * DESCRIPTION
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * CONSTRANTS
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 * 
 * EXAMPLES
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * 
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * 
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Initialize a map and count letters in magazine
        Map<Character, Integer> counts = new HashMap<>();
        char[] magazineLetters = magazine.toCharArray();
        for (char letter : magazineLetters) {
            counts.put(letter, counts.getOrDefault(letter,  0) + 1);
        }

        // Iterate through magazine and check for existence. With each found letter, remove from hashmap
        char[] ransomLetters = ransomNote.toCharArray();
        for (char letter : ransomLetters) {
            // return false if there are no more letters to use
            if (counts.getOrDefault(letter, 0) == 0) {
                return false;
            }

            // update counts if we use a letter
            counts.put(letter, counts.get(letter) - 1);
        }

        return true;
    }
}