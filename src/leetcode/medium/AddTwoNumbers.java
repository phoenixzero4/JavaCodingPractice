package leetcode.medium;


/*
Given 2 non-empty linked lists representing 2 non-negative integers.
The digits are stored in reverse order and each of their nodes contains 1 digit.

Add the 2 numbers and return the sum as a linked list

The 2 numbers do not contain any leading zeroes except the number 0 itself
 */

import static leetcode.medium.ListNode.printList;
import static leetcode.medium.ListNode.reverseList;

public class AddTwoNumbers {

  static void main() {

    ListNode first = new ListNode( 3 );
    first.next = new ListNode( 4, new ListNode( 2 ) );

    ListNode second = new ListNode( 4 );
    second.next = new ListNode( 6, new ListNode( 5 ) );

    // 243 + 564 = 807
    // returned as ( 7, 0, 8 );
    ListNode result = addTwoNumbers( first, second );

    while ( result != null ) {
      System.out.print( result.val );
      result = result.next;
    }
    System.out.println();
    
    result = addTwoNumbers( first, second );
    printList( reverseList( result ) );

    // printList( result );
  }

  public static ListNode addTwoNumbers( ListNode one, ListNode two ) {

    ListNode dummy = new ListNode( 0 );
    ListNode current = dummy;

    int carry = 0;

    while ( one != null || two != null || carry != 0 ) {

      int x = ( one != null ) ? one.val : 0;
      int y = ( two != null ) ? two.val : 0;

      int sum = x + y + carry;

      carry = sum / 10;
      int digit = sum % 10;

      current.next = new ListNode( digit );
      current = current.next;

      if ( one != null ) {
        one = one.next;
      }

      if ( two != null ) {
        two = two.next;
      }
    }
    return dummy.next;

  }
}
