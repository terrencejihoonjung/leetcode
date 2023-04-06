package LinkedList.ReverseLinkedList;

/**
 * DESCRIPTION
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, 
 * if 0 <= i <= (n / 2) - 1.
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. 
 * These are the only nodes with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 * 
 * CONSTRANTS
 * The number of nodes in the list is an even integer in the range [2, 105].
 * 1 <= Node.val <= 105
 * 
 * EXAMPLES
 * Input: head = [5,4,2,1]
 * Output: 6
 * 
 * Input: head = [4,2,2,3]
 * Output: 7
 * 
 * Input: head = [1,100000]
 * Output: 100001
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

 class Solution {
    public int pairSum(ListNode head) {
        // Fast and Slow pointer to get the middle node 
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Find and return maximum pair sum by iteration
        int max = 0;
        ListNode p = head;
        while (prev != null && p != null) {
            max = Math.max(prev.val + p.val, max);
            prev = prev.next;
            p = p.next;
        }

        return max;
    }
}