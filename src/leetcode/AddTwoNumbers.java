package leetcode;

import java.util.LinkedList;
import java.util.List;

public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = 0;
            int y = 0;

            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummyHead.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);

            if (node.next != null) {
                System.out.print(" -> ");
            }

            node = node.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);

        printList(result);
    }
}
