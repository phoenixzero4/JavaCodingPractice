package leetcode.easy;

public class RemoveDupsSortedList {
    /*
  https://leetcode.com/problems/remove-duplicates-from-sorted-list/

  Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
  Return the linked list sorted as well.

  Constraints:

  The number of nodes in the list is in the range [0, 300].
  -100 <= Node.val <= 100
  The list is guaranteed to be sorted in ascending order.
   */

  static void main() {

    ListNode head = new ListNode( 1, new ListNode( 1, new ListNode( 2 ) ) );

    System.out.println( "List before removing duplicates" );
    printNodeList( head );
    deleteDuplicates( head );
    System.out.println( "List after removing duplicates" );
    printNodeList( head );

    ListNode head2 = new ListNode( 1, new ListNode( 1, new ListNode( 2, new ListNode( 3, new ListNode( 3 ) ) ) ) );
    System.out.println( "List before removing duplicates" );
    printNodeList( head2 );
    deleteDuplicates( head2 );
    System.out.println( "List after removing duplicates" );
    printNodeList( head2 );

  }

  public static void printNodeList( ListNode head ) {

    while ( head != null ) {
      System.out.println( "Node val: " + head.val );
      head = head.next;
    }
  }

  public static ListNode deleteDuplicates( ListNode head ) {
    /*
      Time complexity = O(n)
      Space complexity = O(1)
    */
    if ( head == null ) {
      return null;
    }

    ListNode previous = head;
    ListNode current = head.next;

    while ( current != null ) {

      if ( current.val != previous.val ) {
        previous.next = current;
        previous = current;
      }
     current = current.next;

    }
    previous.next = null;

    return head;
  }

}