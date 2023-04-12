
package StacksAndQueues.StringProblems;

/**
 * DESCRIPTION
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. 
 * '#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * CONSTRANTS
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 * 
 * EXAMPLES
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * 
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * 
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String str) {
        StringBuilder ret = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                ret.append(c);
            } else if (ret.length() > 0) {
                ret.deleteCharAt(ret.length() - 1);
            }
        }
        
        return ret.toString();
    }
}