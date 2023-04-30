package StacksAndQueues.StringProblems;
// https://leetcode.com/problems/simplify-path/

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] splitPath = path.split("/");

        for (String s: splitPath) {
            if (s.equals("..") && stack.size() > 0) {
                stack.pop();
            }
            else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
                stack.push(s);
            }
        }

        List<String> list = new ArrayList<>(stack);
        return "/" + String.join("/", list);
    }
}