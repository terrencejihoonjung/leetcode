package StacksAndQueues.Monotonic;
// https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (deque.getFirst() + k == i) {
                deque.removeFirst();
            }

            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.getFirst()];
            }
        }

        return ans;
    }
}
