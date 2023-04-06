package LinkedList.FastandSlow;

/**
 * DESCRIPTION
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * 
 * CONSTRANTS
 * The number of nodes in the list is in the range [1, 100].
 * 1 <= Node.val <= 100
 * 
 * EXAMPLES
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * 
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}