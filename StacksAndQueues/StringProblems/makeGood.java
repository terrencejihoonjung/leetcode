package StacksAndQueues.StringProblems;
// https://leetcode.com/problems/make-the-string-great/

class Solution {
    public String makeGood(String s) {
        StringBuilder string = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (string.length() > 0 && isOppositeAndEqual(string.charAt(string.length() - 1), c)) {
                string.deleteCharAt(string.length() - 1);
            }
            else {
                string.append(c);
            }
        }

        return string.toString();
    }

    public boolean isOppositeAndEqual(char a, char b) {
        if (Character.toLowerCase(a) == Character.toLowerCase(b) &&
        (Character.isUpperCase(a) == Character.isLowerCase(b) ||
         Character.isLowerCase(a) == Character.isUpperCase(b))) {
            return true;
        }
        else {
            return false;
        }
    }
}
