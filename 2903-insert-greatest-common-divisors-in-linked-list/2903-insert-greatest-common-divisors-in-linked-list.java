/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            int g = gcd(curr.val, curr.next.val);

            // Insert new node with gcd value
            ListNode newNode = new ListNode(g);
            newNode.next = curr.next;
            curr.next = newNode;

            // Move to the node after the inserted one
            curr = newNode.next;
        }

        return head;
    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}