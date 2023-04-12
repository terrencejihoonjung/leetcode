
package StacksAndQueues.StringProblems;

import java.util.*;

/**
 * DESCRIPTION
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * 
 * CONSTRANTS
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * 
 * EXAMPLES
 * Input: s = "()"
 * Output: true
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Input: s = "(]"
 * Output: false
 */

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) {
                stack.push(brackets.get(c));
            } else {
                if (stack.empty()) {
                    return false;
                } 
                
                char top = stack.pop();
                if (c != top) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}