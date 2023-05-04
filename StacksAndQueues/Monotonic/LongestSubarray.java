package StacksAndQueues.Monotonic;
// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> increasing = new ArrayDeque<>();
        ArrayDeque<Integer> decreasing = new ArrayDeque<>();
        int ans = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!increasing.isEmpty() && increasing.getLast() > nums[right]) {
                increasing.removeLast();
            }
            while (!decreasing.isEmpty() && decreasing.getLast() < nums[right]) {
                decreasing.removeLast();
            }

            increasing.addLast(nums[right]);
            decreasing.addLast(nums[right]);

            // Maintaining window constrant
            while (decreasing.getFirst() - increasing.getFirst() > limit) {
                if (nums[left] == increasing.getFirst()) {
                    increasing.removeFirst();
                }
                if (nums[left] == decreasing.getFirst()) {
                    decreasing.removeFirst();
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
