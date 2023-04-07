package LinkedList.ReverseLinkedList;

/**
 * DESCRIPTION
 * Given the head of a singly linked list and two integers left and right where left <= right, 
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * 
 * CONSTRANTS
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * 
 * EXAMPLES
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * 
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        // Make dummy node to return it later
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        dummy.next = head;

        // Have tail point to the tail of the reversed list
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
        }
        ListNode tail = p.next;

        // Reverse Linked List from left to right
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = p.next;
            p.next = tail.next;
            tail.next = tail.next.next;
            p.next.next = tmp;
        }

        return dummy.next;
    }
}